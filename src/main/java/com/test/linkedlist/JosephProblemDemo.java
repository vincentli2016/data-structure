package com.test.linkedlist;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class JosephProblemDemo {

    public static void main(String[] args) {
        //测试构建环形链表和遍历是否正确
        SingleCircleLinkedList singleCircleLinkedList = new SingleCircleLinkedList();
        singleCircleLinkedList.addBoy(5);//加入5个小孩节点

        singleCircleLinkedList.showBoys();

        //测试出圈是否正确
        singleCircleLinkedList.countBoy(1, 2, 5);
    }

}

class SingleCircleLinkedList {
    //创建一个first节点
    private Boy first = new Boy(-1);
    //添加一个小孩节点, 构建成一个环形链表
    public void addBoy(int nums) {
        //nums 数据校验
        if(nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }

        Boy cur = null; //辅助指针, 帮助构建环形链表
        //使用一个for循环来创建我们的环形链表
        for(int i = 1 ; i <= nums; i++) {
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if(i == 1) {
                first = boy;
                first.setNext(first);
                cur = first;
            } else {
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }
        }
    }

    //遍历当前的环形链表
    public void showBoys() {
        //判断是否为空
        if(first == null) {
            System.out.println("empty");
            return;
        }
        //因为first不能动,因此仍然使用辅助指针完成遍历
        Boy cur = first;
        while(true) {
            System.out.printf("小孩的编号 %d \n", cur.getNo());
            if(cur.getNext() == first) {//说明遍历完毕
                break;
            }
            cur = cur.getNext();//往后移
        }
    }

    /**
     *
     * @param startNo 表示从第几个 孩子开始数数
     * @param countNum 表示数几下
     * @param nums 表示最初有多少个小孩在圈中
     */
    //根据用户的输入,计算出小孩出圈的顺序
    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if(first == null || startNo < 1 || startNo > nums) {
            System.out.println("parameter error, please reenter");
            return;
        }
        //创建一个辅助指针,帮助完成小孩出圈
        Boy helper = first;
        //先让helper指向最后一个节点
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }

       //小孩报数前, 先让first和helper移动 k - 1 次
        for(int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //当小孩报数时, 让fisrt和helper指针同时移动, m - 1 次, 然后出圈
        //这里时一个循环操作, 知道圈中只有一个节点
        while(true) {
            if(helper == first) {
                break;
            }
            //让first和helper指针同时移动 countNum - 1 次
            for(int j = 0; j< countNum -1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这是fist指向的节点, 就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //这时将first指向的小孩出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d\n", first.getNo());
    }
}


//创建一个Boy类, 表示一个节点
@RequiredArgsConstructor
@Data
class Boy {
    @NonNull
    private int no;//编号
    private Boy next;//指向下一个节点,默认null


}
