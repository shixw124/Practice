package com.changan.studyList;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/27 0027.
 *
 */

public class DoublyLinkedList implements List {
    int size;
    /**
     * head node
     */
    DoublyNode head;

    /**
     * eatablish a empty two-way linked-list
     */
    public DoublyLinkedList() {
        head = new DoublyNode();
        head.next = head;
        head.pre = head;
        size = 0;
    }

    /**
     * acquire the specified element
     *
     * @param index which node
     * @return node
     */
    public DoublyNode getNode(int index) {
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException("the index is out of bounds");
        }
        DoublyNode node = head;
        int i = 0;
        while (i < index && node.next != null) {
            i++;
            node = node.next;
        }

        return node;
    }

    /**
     * default add operation
     *
     * @param value the value of node waiting be add
     * @return is successfully added?
     */
    private boolean add(Object value) {
        addLast(value);
        return true;
    }

    /**
     * add the element before the aim element
     *
     * @param newNode new node
     * @param node    aim node
     */
    private void addBefore(DoublyNode newNode, DoublyNode node) {
        newNode.next = node;
        newNode.pre = node.pre;
        node.pre.next = newNode;
        node.pre = newNode;
        size++;
    }

    /**
     * add the element before the aim element
     *
     * @param newNode new node
     * @param node    aim node
     */
    private void addAfter(DoublyNode newNode, DoublyNode node) {
        newNode.pre = node;
        node.next.pre = newNode;
        newNode.next = node.next;
        node.next = newNode;
        size++;
    }

    /**
     * remove the aim node
     *
     * @param node aim node
     * @throws Exception if the list is empty
     */
    private void removeNode(DoublyNode node) throws Exception {
        if (isEmpty()) {
            throw new Exception("the doubly linked list is empty!");
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = null;
        node.pre = null;
        size--;
    }

    /**
     * add the node before the head node
     *
     * @param value new node's value
     * @return boolean
     */
    private boolean addFirst(Object value) {
        addAfter(new DoublyNode(value), head);
        return true;
    }

    /**
     * add new node at the last
     *
     * @param value
     * @return
     */
    private boolean addLast(Object value) {
        addBefore(new DoublyNode(value), head);
        return true;
    }

    /**
     * add a new node at the specified location
     *
     * @param index specified location
     * @param value node's value
     */
    private void add(int index, Object value) {
        addBefore(new DoublyNode(value), getNode(index));
    }

    /**
     * acquire the value of specified node
     *
     * @param index specified location
     * @return
     */
    private Object getValue(int index) {
        return getNode(index).data;
    }

    /**
     * remove node at specified location
     *
     * @param index specified location
     */
    private void remove(int index) {
        try {
            removeNode(getNode(index));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * remove the node next the head node
     */
    private void removeFirst() {
        try {
            removeNode(head.next);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * remove the tail node
     */
    private void removeLast() {
        try {
            removeNode(head.pre);
        } catch (Exception e) {
            e.printStackTrace();
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

    }

    @Override
    public void delete(int index) throws Exception {

    }

    @Override
    public Object get(int index) throws Exception {
        return null;
    }

    /**
     * override the toString method
     * @return
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        DoublyNode node = head;
        for (int i = 0; i <= size; i++) {
            stringBuilder.append(node.data);
            stringBuilder.append("->");
            node = node.next;
        }
        stringBuilder.append(node.data);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.add(4);
        linkedList.add(7);
        linkedList.add(8);
        System.out.println(linkedList);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        System.out.println(linkedList);
        linkedList.addLast(9);
        linkedList.addLast(10);
        System.out.println(linkedList);

        linkedList.add(4, "5");
        linkedList.add(5, 6);
        linkedList.add(0, "在0索引出加上:0");
        System.out.println(linkedList);
        linkedList.add(5, "第5个索引添加后获得这个位置的值");
        System.out.println(linkedList);
        System.out.println(linkedList.getValue(5));
        System.out.println(linkedList.getValue(10));
        System.out.println(linkedList.getValue(11));
//		System.out.println(link.getValue(15));

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.remove(4);
        System.out.println(linkedList);

        System.out.println(linkedList.size());


        linkedList.removeLast();
        linkedList.removeLast();
        linkedList.removeLast();
        linkedList.removeLast();
        linkedList.removeLast();
        System.out.println(linkedList);
        linkedList.removeLast();
        linkedList.removeLast();
        linkedList.removeLast();
        linkedList.removeLast();
        System.out.println(linkedList);
       /* linkedList.removeLast();
        System.out.println(linkedList);
        linkedList.removeLast();
*/
    }
}
