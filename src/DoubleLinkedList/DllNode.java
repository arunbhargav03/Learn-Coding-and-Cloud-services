package DoubleLinkedList;

public class DllNode {

    DllNode prev;
    String data;
    DllNode next;

    public DllNode() {
        this.prev = null;
        this.data = null;
        this.next = null;
    }

    public DllNode(DllNode prev, String data, DllNode next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

}
