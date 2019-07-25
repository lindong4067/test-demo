package com.example.testpractice.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.*;

public class DisruptorDemo {
    public static void main(String[] args) throws Exception {

        TimeUnit.SECONDS.sleep(10);
        // Executor that will be used to construct new threads for consumers
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("consumer-%d")
                .setDaemon(true)
                .build();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(15, 15, 1, TimeUnit.MILLISECONDS, queue, namedThreadFactory);

        ThreadFactory product = new ThreadFactoryBuilder()
                .setNameFormat("product-%d")
                .setDaemon(true)
                .build();

        ThreadPoolExecutor productExecutor = new ThreadPoolExecutor(2, 2, 1, TimeUnit.MILLISECONDS, queue, product);

        // The factory for the event
        LongEventFactory factory = new LongEventFactory();

        // Specify the size of the ring buffer, must be power of 2.
        int bufferSize = 8;

        for (int i = 0; i < 1; i++) {
            // Construct the Disruptor
            //Disruptor<LongEvent> disruptor = new Disruptor<>(factory, bufferSize, executor);
            Disruptor<LongEvent> disruptor = new Disruptor<>(factory, bufferSize, executor, ProducerType.SINGLE,
                    new YieldingWaitStrategy());

            // Connect the handler
            disruptor.handleEventsWith(new LongEventHandler());

            // Start the Disruptor, starts all threads running
            disruptor.start();

            // Get the ring buffer from the Disruptor to be used for publishing.
            RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

            LongEventProducer producer = new LongEventProducer(ringBuffer);

            for (long l = 0; l < 1000000; l++) {
                //producer.onData(l);
                //Thread.sleep(1000);
                productExecutor.execute(new Work(producer,l));
            }

        }

        productExecutor.shutdown();
        while (!productExecutor.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("线程还在执行。。。");
        }
        System.out.println("main over");

    }



    private static class Work implements Runnable{

        private LongEventProducer producer ;
        private long bb ;

        public Work(LongEventProducer producer,long bb) {
            this.producer = producer;
            this.bb = bb ;
        }

        @Override
        public void run() {
            producer.onData(bb);
        }
    }
}

/**
 * Use as event
 */
class LongEvent {
    private long value;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}

class LongEventFactory implements EventFactory<LongEvent> {

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}

class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("customer Event=" + event.getValue());
    }
}

class LongEventProducer {
    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(long bb) {

        ringBuffer.getCursor();

        long sequence = ringBuffer.next();  // Grab the next sequence
        try {
            LongEvent event = ringBuffer.get(sequence); // Get the entry in the Disruptor
            // for the sequence
            System.out.println("product Event=" + bb);
            event.setValue(bb);  // Fill with data、
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}