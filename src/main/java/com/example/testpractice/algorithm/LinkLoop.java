package com.example.testpractice.algorithm;

import org.junit.Assert;

/**
 * 链表是否有环
 *
 * @author Lindong Zhao
 * @create 2019-07-28 12:21
 **/
public class LinkLoop {
    public static class Node {
        private Object data;
        public Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Object data) {
            this.data = data;
        }
    }

    public boolean isLoop(Node node) {
        Node slow = node;
        Node fast = node.next;

        while (slow.next != null) {
            Object dataSlow = slow.data;
            Object dataFast = fast.data;

            if (dataFast == dataSlow) {
                return true;
            }

            if (fast.next == null) {
                return false;
            }

            slow = slow.next ;
            fast = fast.next.next ;

            if (fast == null){
                return false ;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        isLoop();
        isLoop2();
        isLoop3();
    }

    public static void isLoop() throws Exception {
        LinkLoop.Node node3 = new LinkLoop.Node("3");
        LinkLoop.Node node2 = new LinkLoop.Node("2") ;
        LinkLoop.Node node1 = new LinkLoop.Node("1") ;

        node1.next = node2 ;
        node2.next = node3 ;

        LinkLoop linkLoop = new LinkLoop() ;
        boolean loop = linkLoop.isLoop(node1);
        Assert.assertFalse(loop);
    }

    /**
     * 有环
     * @throws Exception
     */
    public static void isLoop2() throws Exception {
        LinkLoop.Node node3 = new LinkLoop.Node("3");
        LinkLoop.Node node2 = new LinkLoop.Node("2") ;
        LinkLoop.Node node1 = new LinkLoop.Node("1") ;

        node1.next = node2 ;
        node2.next = node3 ;
        node3.next = node1 ;

        LinkLoop linkLoop = new LinkLoop() ;
        boolean loop = linkLoop.isLoop(node1);
        Assert.assertTrue(loop);
    }

    /**
     * 无环
     * @throws Exception
     */
    public static void isLoop3() throws Exception {
        LinkLoop.Node node2 = new LinkLoop.Node("2") ;
        LinkLoop.Node node1 = new LinkLoop.Node("1") ;

        node1.next = node2 ;


        LinkLoop linkLoop = new LinkLoop() ;
        boolean loop = linkLoop.isLoop(node1);
        Assert.assertFalse(loop);
    }
}
