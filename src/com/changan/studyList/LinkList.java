package com.changan.studyList;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/26 0026.
 *
 */


public class LinkList implements List {

    Node head; // head node(the head pointer is the linklist reference)
    Node currentNode; // current node
    int size = 0; // the size of list

    /**
     * initialize the linklist
     */
    public LinkList() {
        this.head = currentNode = new Node(null);
        size = 1;
    }

    /**
     * locate the specified element
     *
     * @param i locate argument
     * @return
     */
    public void index(int i) {
        if (i < -1 || i > size) {
            System.out.println("the argument is not suitable");
            return;
        }
        if (i == 0) {
            System.out.println("you selected the head node");
            currentNode = head;
            return;
        }

        currentNode = head.nextNode;
        int j = 0;
        while (currentNode != null && j < i - 1) {
            currentNode = currentNode.nextNode;
            j++;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(int index, Object object) throws Exception {
        if (index < -1 && index > this.size) {
            System.out.println("your argument is wrong");
        }

        index(index);
        // System.out.println(node);
        currentNode.setNextNode(new Node(object, currentNode.nextNode));
        currentNode = currentNode.nextNode;
        size++;
    }

    @Override
    public void delete(int index) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("this list is empty !0_0!");
        }

        if (index <= -1 && index > this.size) {
            System.out.println("your argument is wrong");
        }

        index(index);
        currentNode.setNextNode(currentNode.nextNode.nextNode);
        size--;
    }

    @Override
    public Object get(int index) throws Exception {
        if (index < -1 && index > this.size) {
            System.out.println("your argument is wrong");
        }

        index(index);
        return currentNode.object;
    }


    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        try {
            for (int i = 0; i < 9; i++) {
                int temp = ((int) (Math.random() * 100)) % 100;
                linkList.insert(i, i + 1);
                System.out.print(i + 1 + " ");
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            linkList.delete(0);
            System.out.println("------after the delete operation------");
            linkList.currentNode = linkList.head.nextNode;
            for (int i = 0; i < linkList.size - 1; i++) {
                System.out.print(linkList.currentNode.object + " ");
                linkList.currentNode = linkList.currentNode.nextNode;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
