package com.example.testpatterns.interpreter.demo;

public class MultiNode extends SymbolNode {

    public MultiNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return left.interpret() * right.interpret();
    }
}
