package cn.com.queue;

/**
 * @author xuekun
 * @create 2020-05-25 16:28
 **/
public class Buffer<E> {
    private Node<E> head;
    private Node<E> tail;

    public E poll() {
        final Node<E> f = head;
        return (f == null) ? null : unlinkFirst(f);
    }

    private E unlinkFirst(Node<E> f) {
        final E element = f.value;
        final Node<E> next = f.next;
        f.value = null;
        f.next = null; // help GC
        head = next;
        if (next == null) {
            tail = null;
        } else {
            next.pro = null;
        }
        return element;
    }

    public void offer(E e) {

        Node t = tail;
        Node newNode = new Node<>(t, e, null);
        tail = newNode;
        if (t == null) {
            head = newNode;
        } else {
            t.next = newNode;
        }

    }

    private class Node<E> {
        private E value;
        private Node next;
        private Node pro;

        public Node(Node pro, E value, Node next) {
            this.pro = pro;
            this.value = value;
            this.next = next;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPro() {
            return pro;
        }

        public void setPro(Node pro) {
            this.pro = pro;
        }
    }
}
