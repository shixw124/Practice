package com.changan.study;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/13 0013.
 *
 */

import java.util.LinkedList;

/**
 * the data structure -- Stack
 */
public class Stack<T> {
    private LinkedList<T> storage = new LinkedList<T>();

    /**
     * add one element
     *
     * @param t element to be added
     */
    public void push(T t) {
        storage.addFirst(t);
    }

    /**
     * get the top element
     *
     * @return top element
     */
    public T peek() {
        return storage.getFirst();
    }

    /**
     * pop-up the top element
     *
     * @return top element
     */
    public T pop() {
        return storage.removeFirst();
    }

    /** determine whether the stack is empty
     * @return a boolean value to indicate the status
     */
    public boolean empty() {
        return storage.isEmpty();
    }

    public String toString() {
        return storage.toString();
    }


}
