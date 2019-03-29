package com.example.testpatterns.interpreter.demo;

public abstract class SymbolNode implements Node {
    protected Node left;
    protected Node right;

    SymbolNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

}
