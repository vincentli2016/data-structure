package com.test.stack;

public class LinkedListStackDemo {

    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack(4);
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");


        linkedListStack.push(hero1);
        linkedListStack.push(hero2);
        linkedListStack.push(hero3);
        linkedListStack.push(hero4);

        linkedListStack.list();
    }
}

class LinkedListStack {
    private int maxSize;
    private HeroNode head;

    public LinkedListStack(int maxSize) {
        this.maxSize = maxSize;
        head = new HeroNode(-1, "", "");
    }

    public boolean isFull() {
        int count = 0;
        HeroNode cur = head.getNext();
        while(cur != null) {
            count++;
            cur = cur.getNext();
        }

        return count == maxSize;
    }

    public boolean isEmpty() {
        return head.getNext() == null;
    }

    public void push(HeroNode node) {
        if(isFull()) {
            System.out.println("full");
            return;
        }
        node.setNext(head.getNext());
        head.setNext(node);
    }

    public HeroNode pop() {
        if(isEmpty()) {
            throw new RuntimeException("empty");
        }
        HeroNode result = head.getNext();
        head.setNext(head.getNext().getNext());
        return result;
    }

    public void list() {
        HeroNode cur = head.getNext();
        while(cur != null) {
            System.out.println(cur.getName());
            cur = cur.getNext();
        }
    }

}