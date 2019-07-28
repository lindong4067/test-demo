package com.example.testpractice.algorithm;

import java.util.LinkedList;

/**
 * 二叉树遍历算法
 *
 * @author Lindong Zhao
 * @create 2019-07-28 11:04
 **/
public class BinaryNode {
    private Object data;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode() {
    }

    public BinaryNode(Object data, BinaryNode left, BinaryNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public BinaryNode createNode() {
        BinaryNode node = new BinaryNode(1, null, null);
        BinaryNode node2 = new BinaryNode(2, null, null);
        BinaryNode node3 = new BinaryNode(3, null, null);
        BinaryNode node4 = new BinaryNode(4, null, null);
        BinaryNode node5 = new BinaryNode(5, null, null);
        BinaryNode node6 = new BinaryNode(6, null, null);
        node.setLeft(node2);
        node2.setLeft(node4);
        node2.setRight(node6);
        node.setRight(node3);
        node3.setRight(node5);
        return node;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public void levelIterator(BinaryNode node) {
        LinkedList<BinaryNode> queue = new LinkedList<>();
        queue.offer(node);
        BinaryNode current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            System.out.print(current.data + "--->");
            if (current.getLeft() != null) {
                queue.offer(current.getLeft());
            }
            if (current.getRight() != null){
                queue.offer(current.getRight());
            }
        }
    }

    public static void main(String[] args) {
        BinaryNode node = new BinaryNode();
        node = node.createNode();
        System.out.println(node);
        node.levelIterator(node);
    }
}
