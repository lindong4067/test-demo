package com.example.testpractice.algorithm;

import java.util.Stack;

/**
 * 使用两个栈实现队列
 */
public class TwoStackQueue<T> {
    private Stack<T> input = new Stack<>();
    private Stack<T> out = new Stack<>();
    /**
     * 写入队列
     * @param t
     */
    public void appendTail(T t){
        input.push(t) ;
    }

    /**
     * 删除队列头结点 并返回删除数据
     * @return
     */
    public T deleteHead(){

        //是空的 需要将 input 出栈写入 out
        if (out.isEmpty()){
            while (!input.isEmpty()){
                out.push(input.pop()) ;
            }
        }

        //不为空时直接移除出栈就表示移除了头结点
        return out.pop() ;
    }


    public int getSize(){
        return input.size() + out.size() ;
    }

    public static void main(String[] args) {

    }
}
