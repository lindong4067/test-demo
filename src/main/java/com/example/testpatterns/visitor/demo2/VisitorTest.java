package com.example.testpatterns.visitor.demo2;

public class VisitorTest {
    public static void main(String[] args) {

    }
}

interface Bill {
    void accept(Visitor visitor);
}

interface Visitor {
    void visite(Bill bill);
}

class ConsumerBill implements Bill {
    private String item;
    private double acount;

    public ConsumerBill(String item, double acount) {
        this.item = item;
        this.acount = acount;
    }

    public String getItem() {
        return item;
    }

    public double getAcount() {
        return acount;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visite(this);
    }
}

class IncomeBill implements Bill {
    private String item;
    private double acount;

    public IncomeBill(String item, double acount) {
        this.item = item;
        this.acount = acount;
    }

    public String getItem() {
        return item;
    }

    public double getAcount() {
        return acount;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visite(this);
    }
}

class Boss implements Visitor {

    private double totalConsumer;
    private double totalIncome;

    // 查看消费的单子
    public void view(ConsumerBill consumerBill) {
        totalConsumer = totalConsumer + consumerBill.getAcount();
    }

    // 查看收入单子
    public void view(IncomeBill incomeBill) {
        totalIncome = totalIncome + incomeBill.getAcount();
    }

    public void getTotalConsumer() {
        System.out.println("老板一共消费了" + totalConsumer);
    }

    public void getTotalIncome() {
        System.out.println("老板一共收入了" + totalIncome);
    }

    @Override
    public void visite(Bill bill) {

    }
}
