package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xdcao on 2017/8/2.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1==null&&l2==null){
            return null;
        }else if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }


        ListNode listNode=null;

        List<ListNode> listNodes=new ArrayList<>();

        if (l1.val<l2.val){
            listNode=l1;

            ListNode temp1=l1.next;
            ListNode temp2=l2;

            return getListNode(listNode, listNodes, temp1, temp2);


        }else {
            listNode=l2;

            ListNode temp1=l1;
            ListNode temp2=l2.next;

            return getListNode(listNode, listNodes, temp1, temp2);

        }

    }

    private ListNode getListNode(ListNode listNode, List<ListNode> listNodes, ListNode temp1, ListNode temp2) {
        while (true){

            if (temp1!=null&&temp2!=null){
                if (temp1.val<temp2.val){
                    listNodes.add(temp1);
                    temp1=temp1.next;
                }else {
                    listNodes.add(temp2);
                    temp2=temp2.next;
                }
            }else {
                if (temp1==null&&temp2!=null){
                    listNodes.add(temp2);
                    temp2=temp2.next;
                }else if(temp1!=null&&temp2==null){
                    listNodes.add(temp1);
                    temp1=temp1.next;
                }else {
                    for (int i=0;i<listNodes.size()-1;i++){
                        listNodes.get(i).next=listNodes.get(i+1);
                    }
                    listNode.next=listNodes.get(0);
                    return listNode;
                }
            }
        }
    }


    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(3);
        listNode.next.next=new ListNode(4);

        ListNode listNode1=new ListNode(0);

        MergeTwoSortedLists mergeTwoSortedLists=new MergeTwoSortedLists();
        ListNode listNode2 = mergeTwoSortedLists.mergeTwoLists(listNode, listNode1);
        while (listNode2!=null){
            System.out.println(listNode2.val);
            listNode2=listNode2.next;
        }

    }

}
