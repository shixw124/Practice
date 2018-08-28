package com.changan.studyList;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/27 0027.
 *
 */

import javax.sound.sampled.DataLine;

public class DoublyNode<T> {
    public T data;
    public DoublyNode<T> pre, next;

    public DoublyNode(T data, DoublyNode<T> pre, DoublyNode<T> next) {
        this.data = data;
        this.next = next;
        this.pre = pre;

    }

    public DoublyNode(T data) {
        this(data, null, null);
    }

    public DoublyNode() {
        this(null, null, null);
    }

    public String toString() {
        return this.data.toString();
    }


}
