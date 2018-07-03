
package com.example.testdemo;

import org.junit.Test;

public class InheritTest {

    class A {
        String show(D d) {
            return "A and D";
        }

        String show(A a) {
            return "A and A";
        }

    }

    class B extends A {
        String show(B b) {
            return "B and B";
        }

        String show(A a) {
            return "B and A";
        }
    }

    public class C extends B {

    }

    public class D extends B{

    }

    @Test
    public void main() {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println("1--" + a1.show(b));//"A and A"
        System.out.println("2--" + a1.show(c));//"A and A"
        System.out.println("3--" + a1.show(d));//"A and D"
        System.out.println("4--" + a2.show(b));//"B and A"
        System.out.println("5--" + a2.show(c));//"B and A"
        System.out.println("6--" + a2.show(d));//"A and D"
        System.out.println("7--" + b.show(b));//"B and B"
        System.out.println("8--" + b.show(c));//"B and B"
        System.out.println("9--" + b.show(d));//"A and D"

//        其实在继承链中对象方法的调用存在一个优先级：this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)
    }
}


