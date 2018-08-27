package com.changan.studyList;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/26 0026.
 *
 */

import com.sun.org.apache.xpath.internal.operations.Mod;

public class Node {
     Object object;
     Node nextNode;


    /**
     * construction method (normal node)
     *
     * @param object   data yield
     * @param nextNode next node
     */
    Node(Object object, Node nextNode) {
        this.object = object;
        this.nextNode = nextNode;
    }

    /**
     * construction method (head node)
     *
     * @param nextNode
     */
    Node(Node nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * get the data
     *
     * @return the data yield
     */
    Object getData() {
        return this.object;
    }


    /**
     * get the next node
     *
     * @return next node
     */
    Node getNextNode() {
        return this.nextNode;
    }

    /**
     * set data
     *
     * @param object the element need to be replaced
     */
    void setData(Object object) {
        this.object = object;
    }

    /**
     * set next node
     *
     * @param node new next node
     */
    void setNextNode(Node node) {
        this.nextNode = node;
    }

    @Override
    public String toString() {
        return object.toString();
    }
}
