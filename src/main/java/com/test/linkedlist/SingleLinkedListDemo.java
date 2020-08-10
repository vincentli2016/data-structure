package com.test.linkedlist;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

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

        singleLinkedList.list();
    }
}

class SingleLinkedList {
    //初始化一个头节点, 头节点不要动
    //不存放具体的数据
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

@Data
@ToString
@RequiredArgsConstructor
class HeroNode {
    @NonNull
    public int no;
    @NonNull
    private String name;
    @NonNull
    private String nickname;

    @ToString.Exclude
    private HeroNode next;


}
