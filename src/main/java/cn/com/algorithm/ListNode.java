package cn.com.algorithm;

public class ListNode<E> {
    E val;
    ListNode<E> next;

    public ListNode(E val, ListNode<E> next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {
    }

    public ListNode<E> build(E val) {
        ListNode<E> listNode = new ListNode<>(val, this);
        return listNode;
    }

    public ListNode<E> getNext() {
        return next;
    }

    public void setNext(ListNode<E> next) {
        this.next = next;
    }
}
