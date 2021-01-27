package com.huang.solution;

/**
 * @author huangkuanyi huang_kuan_yi@163.com
 * @date 2019/10/15 20:46
 */
public class Solution5 {
    class Node{
        Node next;
        int val;
    }
    public static void main(String[] args) {

    }
    public static Node List(Node node){
        if(node==null) {
            return null;
        }
        if(node.next==null) {
            return node;
        }
        Node head=node;
        Node next=head.next;
        while(next.next!=null){
            while(head.val==next.val){
//                delete(node,);
                head.next=next.next;
                next=next.next;
            }
            next=next.next;
            head=head.next;
        }
        return node;
    }

}
