package 动态规划;

import org.junit.Test;

import javax.swing.tree.TreeNode;
import java.util.*;

//343. 整数拆分
class Solution343 {
    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max( 2 * dp[i - 2], 3 * dp[i - 3]);
        }
        return dp[n];
    }

}

class Solution {
    public static void main(String[] args) {
        ArrayDeque<Integer> integers = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
        System.out.println('a'-0);
        System.out.println('z'-0);
        System.out.println('A'-0);
        System.out.println('Z'-0);
        String na = "'ehaif";
        System.out.println(integers.peek());
        System.out.println(integers.getLast());
        System.out.println(integers.getFirst());
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len == 0||k==0) return new int[0];
        Deque<int[]> stack = new ArrayDeque<int[]>();
        int max = nums[0];
        int[] ans = new int[len-k+1];
        for(int i = 0; i < k;i++){
            while(!stack.isEmpty()&&stack.getLast()[1] <= nums[i]) stack.removeLast();
            stack.addLast(new int[]{i,nums[i]});
        }
        ans[0] = stack.getFirst()[1];
        for(int i = 1; i <= len-k; i++){
            int right = i + k -1;
            while(!stack.isEmpty()&&stack.getFirst()[0]< i) stack.removeFirst();
            while(!stack.isEmpty()&&stack.getLast()[1] <= nums[right]) stack.removeLast();
            stack.addLast(new int[]{right,nums[right]});
            ans[i] = stack.getFirst()[1];
        }
        return ans;
    }
}

class Solution462346 {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
        int target = sum / 2;
        return generate(nums,0,target);
    }

    private boolean generate(int[] nums,int startindex,int target){
        if(target==0) return true;
        if(target<0||startindex>nums.length-1) return false;
        for(int i = startindex; i < nums.length; i++){
            if(nums[i]>target) break;
            if(i>startindex&&nums[i]==nums[i-1]) continue;
            if(generate(nums,i+1,target-nums[i])) return true;
        }
        return false;
    }


















    public boolean generate1(int[] nums,int index,int target){
        if(target<0) return false;
        if(index>nums.length-1) return false;
        if(nums[index]==target) return true;
        if(nums[index]>target) return generate(nums,index+1,target);

        return generate(nums,index+1,target)||generate(nums,index+1,target-nums[index]);
    }

}


class Solution394 {


    public String decodeString(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayList<Character> help = new ArrayList<>();
        int len = s.length();
        for(int i = 0; i < len; i++){
            // Character.isLetter(s.charAt(i))
            if(s.charAt(i)!=']') stack.push(s.charAt(i));
            else{
                while(stack.peek()!='[') help.add(stack.pop());
                stack.pop();
                int num = stack.pop()-'0';
                int size = help.size();
                for(int j = size*num-1; j >= 0; j--){
                    stack.push(help.get(j%size));
                }
                help.clear();
            }
        }
        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()){
            builder.append(stack.removeLast());
        }
        return builder.toString();
    }
}

class test{
    public static void main(String[] args) {
        test test = new test();
        test.test1();
    }
    @Test
    public void test1(){
        TreeSet<Integer> set = new TreeSet<>();

        //失败：不能添加不同类的对象
        set.add(123);
        set.add(456);
//        set.add("AA");
//        set.add(new User("Tom",12));

        //举例一：
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //举例二：
//        set.add(new User("Tom",12));
//        set.add(new User("Jerry",32));
//        set.add(new User("Jim",2));
//        set.add(new User("Mike",65));
//        set.add(new User("Jack",33));
//        set.add(new User("Jack",56));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
















