package leetcode;

import org.omg.PortableInterceptor.ServerRequestInfo;

import java.rmi.server.RemoteObjectInvocationHandler;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xdcao on 2017/7/31.
 */
public class AddTwoNum {




    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        List<ListNode> listNodes=new ArrayList<>();

        ListNode num1=l1;
        ListNode num2=l2;
        int remain=0;

        while (true){
            if (num1==null&&num2==null){
                if (remain==1){
                    ListNode listNode=new ListNode(1);
                    listNodes.add(listNode);
                    break;
                }else {
                    break;
                }
            }else if(num1==null&&num2!=null){
                int sum=num2.val+remain;
                if (sum>9){
                    remain=1;
                    ListNode listNode=new ListNode(sum-10);
                    listNodes.add(listNode);
                }else {
                    remain=0;
                    ListNode listNode=new ListNode(sum);
                    listNodes.add(listNode);
                }
                num2=num2.next;
            }else if(num1!=null&&num2==null){
                int sum=num1.val+remain;
                if (sum>9){
                    remain=1;
                    ListNode listNode=new ListNode(sum-10);
                    listNodes.add(listNode);
                }else {
                    remain=0;
                    ListNode listNode=new ListNode(sum);
                    listNodes.add(listNode);
                }
                num1=num1.next;
            }else {
                int sum=num1.val+num2.val+remain;
                if (sum>9){
                    remain=1;
                    ListNode listNode=new ListNode(sum-10);
                    listNodes.add(listNode);
                }else {
                    remain=0;
                    ListNode listNode=new ListNode(sum);
                    listNodes.add(listNode);
                }
                num1=num1.next;
                num2=num2.next;
            }

        }

        if (listNodes.size()>1){
            for (int i=0;i<listNodes.size()-1;i++){
                listNodes.get(i).next=listNodes.get(i+1);
            }
            return listNodes.get(0);
        }else {
            return listNodes.get(0);
        }

    }

    public static void main(String[] args){
         ListNode listNode1=new ListNode(2);
         listNode1.next=new ListNode(4);
         listNode1.next.next=new ListNode(3);

        ListNode listNode2=new ListNode(5);
        listNode2.next=new ListNode(6);
        listNode2.next.next=new ListNode(4);

        AddTwoNum addTwoNum=new AddTwoNum();
        ListNode listNode = addTwoNum.addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
    }



}
