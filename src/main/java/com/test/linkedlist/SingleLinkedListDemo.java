package com.test.linkedlist;

import lombok.*;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

//按照编号顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

//        System.out.println("修改前");
//        singleLinkedList.list();
//
//        HeroNode newNode = new HeroNode(2, "小卢", "玉麒麟～～");
//        singleLinkedList.update(newNode);
//        System.out.println("修改后");
//        singleLinkedList.list();
//
//        singleLinkedList.remove(1);
//        System.out.println("删除后");
//        singleLinkedList.list();
//        singleLinkedList.remove(3);
//        System.out.println("删除后");
//        singleLinkedList.list();

//        System.out.println(getLength(singleLinkedList.getHead()));
//
//        System.out.println(findReciprocalNode(singleLinkedList.getHead(), 3));

//        System.out.println("倒序前");
//        singleLinkedList.list();
//        reverse(singleLinkedList.getHead());
//        System.out.println("倒序后");
//        singleLinkedList.list();

        System.out.println("测试逆序打印");
        System.out.println("前");
        singleLinkedList.list();
        System.out.println("开始");
        //没有改变链表的结构
        reversePrint(singleLinkedList.getHead());
    }

    public static void reversePrint(HeroNode head) {
        if(head.getNext() == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.getNext();
        //将链表的所有节点压入栈中
        while(cur != null) {
            stack.push(cur);
            cur = cur.getNext();
        }
        //将栈中的节点进行答应
        while(stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    public static void reverse(HeroNode head) {
        if(head.getNext() == null || head.getNext().getNext() == null) {
            return;
        }

        HeroNode cur = head.getNext();
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(-1, "", "");

        while(cur != null) {
            next = cur.getNext();
            cur.setNext(reverseHead.getNext());
            reverseHead.setNext(cur);
            cur = next;
        }

        head.setNext(reverseHead.getNext());
    }



    //查找单链表中倒数第k个节点
    //思路
    //1. 遍历获得链表的长度
    //2. 得到
    public static HeroNode findReciprocalNode(HeroNode head, int index) {
        if(head.getNext() == null) {
            return null;
        }
        int size = getLength(head);

        if(index <= 0 || index > size) {
            return null;
        }

        HeroNode cur = head.getNext();
        for(int i = 0; i < size - index; i++) {
            cur = cur.getNext();
        }
        return cur;
    }


    //获取单链表的节点个数（如果是带头节点的链表，不统计头节点
    /**
     * 输入链表头节点，返回链表节点个数
     * @param head
     * @return
     */
    public static int getLength(HeroNode head) {
        if(head.getNext() == null) {
            return 0;
        }

        int length = 0;
        HeroNode cur = head.getNext();
        while(cur != null) {
            length++;
            cur = cur.getNext();
        }
        return length;
    }
}

class SingleLinkedList {
    //初始化一个头节点, 头节点不要动
    //不存放具体的数据

    @Getter
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点到单向链表
    public void add(HeroNode heroNode) {
        HeroNode temp = head;

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(heroNode);
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean isExists = false;
        while(true) {
            if(temp.getNext() == null) {
                break;
            }
            if(temp.getNext().getNo() > heroNode.getNo()) {
                break;
            } else if(temp.getNext().getNo() == heroNode.getNo()) {
                isExists = true;
                break;
            }
            temp = temp.getNext();
        }

        if(isExists) {
            System.out.println("node is already exists " + heroNode);
        } else {
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
        }
    }

    //修改节点的信息， 根据编号来修改， 也就是说编号不能修改
    //1. 根据新节点的编号来修改
    public void update(HeroNode node) {
        if(head.getNext() == null) {
            System.out.println("链表为空");
        }

        //找到需要修改的节点
        HeroNode temp = head.getNext();
        boolean isExists = false;
        while(true) {
            if(temp == null) {
                break;
            }
            if(temp.no == node.getNo()) {
                isExists = true;
                break;
            }
            temp = temp.getNext();
        }

        if(isExists) {
            temp.setName(node.getName());
            temp.setNickname(node.getNickname());
        } else {
            System.out.printf("没有找到 编号%d的节点， 不能修改\n", node.getNo());
        }
    }

    public void remove(int no) {
        HeroNode temp = head;
        boolean isExists = false;

        while(true) {
            if(temp.getNext() == null) {
                break;
            }

            if(temp.getNext().getNo() == no) {
                isExists = true;
                break;
            }
            temp = temp.getNext();
        }

        if(isExists) {
            temp.setNext(temp.getNext().getNext());
        } else {
            System.out.println("没有找到要删除的节点");
        }
    }

    public void list() {
        if(head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动, 因此,需要一个辅助变量来遍历
        HeroNode temp = head.getNext();

        while (temp != null) {
            //判断是否到最后
            System.out.println(temp);
            temp = temp.getNext();
        }
    }


}


