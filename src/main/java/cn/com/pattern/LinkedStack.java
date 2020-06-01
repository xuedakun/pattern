package cn.com.pattern;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author xuekun
 * @create 2020-03-20 14:58
 **/
public class LinkedStack<T> {
    private AtomicReference <Node<T>> stacks=new AtomicReference<Node<T>>();
    public T push(T object){
        Node<T> oldNode,newNode;
        while (true){
            oldNode=stacks.get();
            newNode=new Node<>(object,oldNode);
            if (stacks.compareAndSet(oldNode,newNode)){
                return object;
            }
        }
    }
    public T pop(){
        Node<T> oldNode,newNode;
        while (true){
            oldNode=stacks.get();
            newNode=oldNode.next;
            if (stacks.compareAndSet(oldNode,newNode)){
                return oldNode.object;
            }
        }
    }
    private static final class Node<T>{
        private T object;
        private Node<T> next;

        public Node(T object, Node<T> next) {
            this.object = object;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }
}
