package com.example.testframe.akka.pingpang;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import org.junit.Test;
import scala.concurrent.Future;

import java.util.concurrent.*;

import static scala.compat.java8.FutureConverters.toJava;
import static akka.pattern.Patterns.ask;
import static org.junit.Assert.assertEquals;

public class PangActorTest {

    ActorSystem system;
    ActorRef actorRef;

    @Test
    public void replyToPingWithPang() throws InterruptedException, ExecutionException, TimeoutException {
        system = ActorSystem.create();
        actorRef = system.actorOf(Props.create(PangActor.class), "Lyndon");
        Future sFutrue = ask(actorRef, "ping", 1000);
        final CompletionStage cs = toJava(sFutrue);
        final CompletableFuture<String> jFuture = (CompletableFuture<String>) cs;
        assertEquals("pang", jFuture.get(1000, TimeUnit.MILLISECONDS));
    }

}
