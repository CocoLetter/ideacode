package list;


import javax.management.Query;
import java.util.*;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static List<List<Integer>> levelOrder(TreeNode root) {
            TreeNode T=root;
        ConcurrentLinkedQueue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(root==null) return list;
        queue.add(T);
        while(!queue.isEmpty()){
            List<Integer> temp=new ArrayList<Integer>();
            int size = queue.size();
            for(int i =0;i<size;i++){
                T=queue.poll();
                temp.add(T.val);

                if(T.left!=null) queue.add(T.left);
                if(T.right!=null) queue.add(T.right);
            }
            list.add(temp);
        }
        return list;

    }

    public static boolean isSymmetric(TreeNode root,List list) {
//        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> S = new Stack<>();
        S.push(root);
        while(!S.isEmpty()){
            while(S.peek()!=null){
                //    S.push(S.peek().left);
                if(S.peek().right!=null&&S.peek().left==null)
                    S.push(new TreeNode(8618-1));
                else
                    S.push(S.peek().left);
            }
            S.pop();
            if(!S.isEmpty()){
                TreeNode T=S.pop();
                list.add(T.val);
                if(T.left!=null&&T.right==null)
                    S.push(new TreeNode(8618-1));
                else
                    S.push(T.right);
            }
        }
        int len= list.size();
        for(int i = 0;i<len/2;i++){
            if(list.get(i).equals(list.get(len-1-i)))
                System.out.println(list.get(i)+"!="+list.get(len-1-i)+(list.get(i)!=list.get(len-1-i)));
                return false;
        }

        return true;

    }

    /**
     *    3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * @param args
     */
    public static void main(String[] args) {
/*        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode3.left=treeNode9;
        treeNode3.right=treeNode20;
        treeNode20.right=treeNode7;
        treeNode20.left=treeNode15;
        List<List<Integer>> lists = levelOrder(treeNode3);
        System.out.println(lists);
        Queue<String> strings = new LinkedList<>();
        char a ='严';
        System.out.println(a+0);
        double sum=a+3.14;

        System.out.println(sum);
        System.out.println(Integer.MIN_VALUE);;*/
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode21 = new TreeNode(2);
        TreeNode treeNode22 = new TreeNode(2);
        TreeNode treeNode31 = new TreeNode(3);
        TreeNode treeNode32 = new TreeNode(3);
        treeNode1.left=treeNode21;
        treeNode1.right=treeNode22;
        treeNode21.right=treeNode31;
        treeNode22.left=treeNode32;

        List<Integer> list=new ArrayList<>();
        Integer l1 = new Integer(90);
        Integer l2 = new Integer(90);
        System.out.println(l1.equals(l2));

        boolean symmetric = isSymmetric(treeNode1,list);
        System.out.println(symmetric);

        int a =Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        System.out.println(a==b);


    }

}