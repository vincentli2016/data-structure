package com.test.linkedlist;

import lombok.Getter;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        System.out.println("双向链表的一个测试");
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        //创建一个双向链表对象
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        HeroNode2 update = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(update);
        System.out.println("修改后=========================");
        doubleLinkedList.list();

        doubleLinkedList.remove(3);
        System.out.println("删除后=========================");
        doubleLinkedList.list();

    }
}

class DoubleLinkedList {

    @Getter private HeroNode2 head = new HeroNode2(0, "", "");

    //添加节点到单向链表
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(heroNode);
        heroNode.setPre(temp);
    }

    //修改节点的信息， 根据编号来修改， 也就是说编号不能修改
    //1. 根据新节点的编号来修改
    public void update(HeroNode2 node) {
        if(head.getNext() == null) {
            System.out.println("链表为空");
        }

        //找到需要修改的节点
        HeroNode2 temp = head.getNext();
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
        if(head.getNext() == null) {
            System.out.println("empty");
            return;
        }

        HeroNode2 temp = head.getNext();
        boolean isExists = false;

        while(true) {
            if(temp == null) {
                break;
            }

            if(temp.getNo() == no) {
                isExists = true;
                break;
            }
            temp = temp.getNext();
        }

        if(isExists) {
            temp.getPre().setNext(temp.getNext());
            //此处有问题 如果是最后一个节点会出现空指针, 所以要判断是否最后一个节点
            if(temp.getNext() != null)
            temp.getNext().setPre(temp.getPre());
            //temp.setNext(temp.getNext().getNext());
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
        HeroNode2 temp = head.getNext();

        while (temp != null) {
            //判断是否到最后
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}
