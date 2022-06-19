package list;

import java.util.*;

public class LinkedList {
/*
        public static ListNode reverseKGroup(ListNode head, int k) {
            if(k==1){
                return head;
            }
            ListNode result=new ListNode(0);
            result.next=head;
            ListNode first=new ListNode(0);
            ListNode second = new ListNode(0);
            ListNode temp = new ListNode(0);
            ListNode temp2 = new ListNode(0);
            first=result;
            second=result;
            for(int i = 0;i<k;i++){
                first=first==null?null:first.next;
            }
            while(first!=null){
                temp2=first;
                for(int i = 0;i<k;i++){
                    first=first==null?null:first.next;
                }
                temp=second.next;
                second.next=reverseList(second.next,k);

                temp.next=temp2;
                second=temp;

            }
            return result.next;
        }
        public static ListNode reverseList(ListNode head, int k) {
            ListNode head0 = new ListNode();
            ListNode temp = new ListNode();
            head0.next=head;
            int i =1;
            while(i<k){
                i++;
//                if(head==head0.next){
//                    temp = head;
//                    head=head.next;
//                    temp.next=null;
//                    head0.next=temp;
//                    continue;
//                }
                temp = head;
                head=head.next;
                temp.next=head0.next;
                head0.next=temp;
            }
            return head0.next;
        }*/
//
//    public static ListNode reverseKGroup(ListNode head, int k) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//
//        ListNode pre = dummy;
//        ListNode end = dummy;
//
//        while (end.next != null) {
//            for (int i = 0; i < k && end != null; i++) end = end.next;
//            if (end == null) break;
//            ListNode start = pre.next;
//            ListNode next = end.next;
//            end.next = null;
//            pre.next = reverse(start);
//            start.next = next;
//            pre = start;
//
//            end = pre;
//        }
//        return dummy.next;
//    }
//
//    private static ListNode reverse(ListNode head) {
//        ListNode pre = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode next = curr.next;
//            curr.next = pre;
//            pre = curr;
//            curr = next;
//        }
//        return pre;
//    }

/*
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0 );
        dummy.next=head;
        ListNode lNode =dummy;
        ListNode rNode =head.next;
        while(rNode!=null){
            while(rNode!=null&&lNode.next.val!=rNode.val){
                rNode=rNode.next;
                lNode=lNode.next;
            }
            while(rNode!=null&&lNode.next.val==rNode.val){
                rNode=rNode.next;
            }

            lNode.next=rNode;

            rNode=rNode==null?null:rNode.next;
        }
        return dummy.next;



    }*/

public static boolean match(String a, String b){
    if(("[".equals(a)&&"]".equals(b))
            ||("{".equals(a)&&"}".equals(b))
            ||("(".equals(a)&&")".equals(b)))
        return true;
    else
        return false;
}
    public static void main(String[] args) {
/*        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(3);
//        ListNode listNode6 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;*/
//        listNode5.next=listNode6;

//        ListNode listNode = deleteDuplicates(listNode1);
//        ListNode listNode = reverseKGroup(listNode1, 2);
//        while(listNode!=null){
//            System.out.println(listNode.val);
//            listNode=listNode.next;
//        }


/*        String s = null;
        Stack stack = new Stack<String>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            String s2 = String.valueOf(s.charAt(i));
            String s1 = (String) stack.peek();

            if (match(s1, s2)) {
                stack.pop();
            }else{
                stack.push(s2)
            }
        }
        */
        String string="hello";
        String h="h";
        Character ch=string.charAt(0);

        System.out.println(string.charAt(0));
        System.out.println(h==ch.toString());
        System.out.println(String.valueOf(0)+String.valueOf(0).getClass());
        System.out.println(String.valueOf(new ListNode(0)));
//        String.valueOf()

/*
       Integer a=1;
       Integer b=2;
        System.out.println(a<b);

        Stack<String> strings = new Stack<>();
        strings.push("hello");
        strings.push("hei");
        System.out.println(strings.pop());
        System.out.println(strings.pop());
        System.out.println(strings.pop());
        char[] test;
//        StringBuilder stringBuilder = new StringBuilder();*/
//String s="abcdef";
//        System.out.println(s.charAt(-2));
        System.out.println(
                Integer.valueOf("2")
        );;

        String.valueOf(9);

        Integer.valueOf("8798");
        int[] height={1,1,2};
        int length = height.length;



//        String[] path= new String[5];
//        boolean[] boo=new boolean[5];





    }


}
