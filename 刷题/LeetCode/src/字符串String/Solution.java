package 字符串String;

import java.util.*;


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}


class Codec {
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode deserialize = codec.deserialize("[1,2,3,null,null,4,5,null,null,null,null]");
        String serialize = codec.serialize(deserialize);
        System.out.println(serialize);
        System.out.println();
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "[#]";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node==null){
                builder.append("null,");
            }else{
                builder.append(node.val);
                builder.append(',');
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(']');
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> queue = new LinkedList<>();
        data = data.substring(1,data.length()-1);
        boolean isLeft = true;
        String[] table = data.split(",");
        if(table.length==0||table[0].equals("null")) return null;
        TreeNode head = new TreeNode(Integer.parseInt(table[0]));
        queue.add(head);
        for(int i = 1; i < table.length; i++){
            TreeNode node = null;
            if(!table[i].equals("null")){
                node = new TreeNode(Integer.parseInt(table[i]));
            }
            if(!queue.isEmpty()){
                if(isLeft){
                    queue.peek().left = node;
                    isLeft = false;
                }else{
                    queue.peek().right = node;
                    isLeft = true;
                    queue.poll();
                }
                if(node!=null){
                    queue.add(node);
                }
            }
        }
        return head;
    }
}

class Solution7676868 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(null);
        linkedList.add(null);
        Solution7676868 solution7676868 = new Solution7676868();
        System.out.println(solution7676868.maxInWindows(new int[]{16, 14, 12, 10, 8, 6, 4}, 5));
    }
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(size > num.length) return ans;
        int maxIndex = 0;
        for(int i = 0; i < size-1; i++){
            if(list.isEmpty()){
                list.add(i);
            }else{
                while(!list.isEmpty()&&num[list.getLast()]<=num[i]){
                    list.removeLast();
                }
                list.add(i);
            }
        }
        list.add(maxIndex);
        for(int i = size-1; i < num.length; i++){
            while(!list.isEmpty()&&list.getFirst()<i-size+1){
                list.removeFirst();
            }
            while(!list.isEmpty()&&num[list.getLast()]<=num[i]){
                list.removeLast();
            }
            list.add(i);
            ans.add(num[list.getFirst()]);
        }
        return ans;
    }
}

class Solution78786 {
    public static void main(String[] args) {
        Solution78786 solution78786 = new Solution78786();
        System.out.println(solution78786.solve("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }
    public String solve (String IP) {
        // write code here
        if((!IP.contains(":")&&!IP.contains("."))||(IP.contains(":")&&IP.contains(".")))
            return "Neither";
        if(IP.contains(".")) return isIPv4(IP)?"IPv4":"Neither";
        else return isIPv6(IP)?"IPv6":"Neither";
    }
    public boolean isIPv4(String str){
        String[] table = str.split("\\.");
        if(table.length!=4) return false;
        for(int i = 0; i < 4; i++){
            if(table[i].length()==0) return false;
            else if(table[i].equals("0")) return true;
            else if(table[i].charAt(0)=='0') return false;
            else{
                int num = Integer.parseInt(table[i]);
                if(num>255||num<0) return false;
            }
        }
        return true;
    }
    public boolean isIPv6(String str){
        String[] table = str.split(":");
        if(table.length!=8) return false;
        for(int i = 0; i < 8; i++){
            if(table[i].length()==0) return false;
            else if(parseInt(table[i])==0) return true;
            else if(table[i].charAt(0)=='0') return false;
            else{
                int num = parseInt(table[i]);
                if(num>=1<<16||num<0) return false;
            }
        }
        return true;
    }
    public int parseInt(String num){
        int sum = 0;
        for(int i = 0; i < num.length(); i++){
            if(Character.isDigit(num.charAt(i))){
                sum += sum * 10 + num.charAt(i)-'0';
            }else{
                sum += sum * 10 + Character.toUpperCase(num.charAt(i))-'A'+10;
            }
        }
        return sum;
    }
}







class solution6879{
    /**
     *
     * @param s string字符串
     * @return string字符串ArrayList
     */
    ArrayList<String> ans = new ArrayList<>();
    public ArrayList<String> restoreIpAddresses (String s) {
        trackback(0,new ArrayList<String>(),s);
        return ans;
    }

    public void trackback(int left,ArrayList<String> path,String s){
        if(left>=s.length()&&path.size()==4){
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < 4; i++){
                builder.append(path.get(i));
                builder.append('.');
            }
            builder.deleteCharAt(builder.length()-1);
            ans.add(builder.toString());
            return;
        }
        if(left>=s.length()||path.size()==4) return;

        if(s.charAt(left)=='0'){
            path.add("0");
            trackback(left+1,path,s);
            path.remove(path.size()-1);
        }else{
            for(int i = 1; i < 4&&left+i<=s.length(); i++){
                String sub = s.substring(left,left+i);
                if(isValid(sub)){
                    path.add(sub);
                    trackback(left+i,path,s);
                    path.remove(path.size()-1);
                }
            }
        }

    }

    public boolean isValid(String str){
        int value = Integer.parseInt(str);
        return value >=0 && value <= 255;
    }

    public static void main(String[] args) {
        solution6879 solution6879 = new solution6879();
        solution6879.restoreIpAddresses("010010");
    }

}

public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combinationSum2(new int[]{100,10,20,70,60,10,50},80);
    }
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        trackback(new ArrayList<Integer>(),num,target,0);
        return ans;
    }

    public void trackback(ArrayList<Integer> path,int[] num,int target, int left){
        if(target==0){
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        if(left >= num.length){
            return;
        }
        for(int i = left; i < num.length && num[i]<=target; i++){
            path.add(num[i]);
            trackback(path,num,target-num[i],i+1);
            path.remove(path.size()-1);
        }
    }
}


class Solution235435 {

    public static void main(String[] args) {
        Solution235435 solution235435 = new Solution235435();
        System.out.println(solution235435.LCS("1A2C3D4B56", "B1D23CA45B6A"));
        System.out.println(solution235435.LCS1("1A2C3D4B56", "B1D23CA45B6A"));
    }

    public String LCS(String s01, String s02) {
        int len1 = s01.length();
        int len2 = s02.length();

        StringBuilder stringBuilder = new StringBuilder(s01);
        String s1 = stringBuilder.reverse().toString();
        StringBuilder stringBuilder1 = new StringBuilder(s02);
        String s2 = stringBuilder1.reverse().toString();

        int[][] dp = new int[len1 + 1][len2 + 1];
        int[] maxLen = new int[len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen[j] = dp[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        int max = dp[len1][len2];
        StringBuilder builder = new StringBuilder();
        for (int k = len2; k >= 1 && max >= 1; k--) {
            if (maxLen[k] == max) {
                builder.append(s2.charAt(k - 1));
                max--;
            }
        }
        return builder.toString();
    }


    public String LCS1(String s1, String s2) {
        // write code here
        int m = s1.length();
        int n = s2.length();
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (a[i - 1] == b[j - 1]) {
                sb.append(a[i - 1]);
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        if (sb.length() == 0) return "-1";
        return sb.reverse().toString();
    }

}
//
//
//    public String LCS (String s1, String s2) {
//        int len1 = s1.length();
//        int len2 = s2.length();
//        int[][] dp = new int[len1+1][len2+1];
//        int[] maxLen = new int[len2+1];
//        for(int i = 1; i <= len1; i++){
//            for(int j = 1; j <= len2; j++){
//                if(s1.charAt(i-1)==s2.charAt(j-1)){
//                    dp[i][j] = dp[i-1][j-1]+1;
//                    maxLen[j] = dp[i][j];
//                }else{
//                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
//                }
//            }
//        }
//        int max = dp[len1][len2];
//        StringBuilder builder  = new StringBuilder();
////         int max = 1;
//        for(int k = len2; k >= 1; k--){
//            if(maxLen[k] == max){
//                builder.append(s2.charAt(k-1));
//                max --;
//            }
//        }
//        return builder.reverse().toString();
//    }
//}



/*


public class Solution {
    HashMap<String,Integer> priority = new HashMap<>();

    public int solve (String s) {
        priority.put("+",1);
        priority.put("-",1);
        priority.put("*",2);
        priority.put("(",0);

        ArrayList<String> expression = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); ){
            if(Character.isDigit(s.charAt(i))){
                int left = i;
                while(i<s.length()&&Character.isDigit(s.charAt(i))){
                    i++;
                }
                expression.add(s.substring(left,i));
                if(i>=s.length()) break;
            }
            char ch = s.charAt(i);
            if(ch =='('){
                stack.push("(");
            }else if(ch ==')'){
                while(!"(".equals(stack.peek())){
                    expression.add(stack.pop());
                }
                stack.pop();
            }else{
                while(!stack.isEmpty()&&priority.get(stack.peek()) >= priority.get(String.valueOf(ch)) ){
                    expression.add(stack.pop());
                }
                stack.push(String.valueOf(ch));
            }
            i++;
        }
        while(!stack.isEmpty()){
            expression.add(stack.pop());
        }
        return caculate(expression);
    }

    public int caculate(ArrayList<String> expression){
        Stack<Integer> nums = new Stack<>();
        for(int i = 0; i < expression.size(); i++){
            String str = expression.get(i);
            if(!priority.containsKey(str)){
                nums.push(Integer.parseInt(str));
            }else{
                int num1 = nums.pop();
                int num2 = nums.pop();
                if(str.equals("+")){
                    nums.push(num1 + num2);
                }else if(str.equals("-")){
                    nums.push(num2 - num1);
                }else{
                    nums.push(num2*num1);
                }
            }
        }
        return nums.pop();
    }
}


*/


/*

class Solution713454 {
    public String simplifyPath(String path) {
        //直接去除 / 值得学习
        String[] pathArray = path.split("/");
        //分割后的几种情况 空格说明是多出来的/，.. .与目录
        StringBuilder res =new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        for(int i=0;i<pathArray.length;i++){
            //2种情况，栈为空或者栈不为空
            if(pathArray[i].length()==0||pathArray[i].equals("."))    continue;
            if(!stack.isEmpty()){
                if(pathArray[i].equals("..")){
                    stack.pop();
                }else{
                    stack.push(pathArray[i]);
                }
            }else{
                if(!pathArray[i].equals(".."))  stack.push(pathArray[i]);
            }
        }
        if(stack.isEmpty())    return res.append('/').toString();
        while(!stack.isEmpty()){
            res.append('/');
            res.append(stack.removeLast());            
        }
        return res.toString();
    }
}*/
abstract class Hello{
    public static String  heeloo = "jih";
    public static void sout(){
        System.out.println("68897");
    }
}


class Solution090868 {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.toString()


        HashMap<Short, String> map = new HashMap<>();
        for(short i = 0; i <100; i++) {
            map.put(i, String.valueOf(i));
            map.remove(i-1);
        }
        System.out.println(map.size());



        Solution090868 solution090868 = new Solution090868();
//        String str1 = "ndfhjakfrglwririjgower";
//        String str2 = "skfvjksruhbwrnbrktkmkfjb";
        String str1 = "ndfhjakfr";
        String str2 = "skfvjksr";
        if(!solution090868.LCS(str1,str2).equals(solution090868.LCS2(str1,str2))){
            System.out.println(solution090868.LCS(str1,str2));
            System.out.println(solution090868.LCS2(str1,str2));
        }
//        System.out.println(solution090868.LCS("1A2C3D4B56", "B1D23CA45B6A"));
//        System.out.println(solution090868.LCS2("1A2C3D4B56", "B1D23CA45B6A"));
    }
    public String LCS(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        int[] maxLen = new int[len2 + 1];
        //        String str1 = "ndfhjakfr";
        //        String str2 = "skfvjksr";
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char  ch1 = s1.charAt(i - 1);
                char  ch2 = s2.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen[j] = Math.max(maxLen[j],dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        int max = dp[len1][len2];
        StringBuilder builder = new StringBuilder();
        for (int k = len2; k >= 1 && max >= 1; k--) {
            if (maxLen[k] == max) {
                builder.append(s2.charAt(k - 1));
                max--;
            }
        }
        if(builder.length()==0) return "-1";
        return builder.reverse().toString();
    }

    public String LCS2(String s01, String s02) {
        int len1 = s01.length();
        int len2 = s02.length();

        StringBuilder builder = new StringBuilder();
        String s1 = s01;
        String s2 = s02;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int[] maxLen = new int[len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen[j] = dp[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        int i = len1 , j = len2;
        while(i>0&&j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                builder.append(s1.charAt(i-1));
                i--;
                j--;
            }else {
                if (dp[i - 1][j] >= dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        if (builder.length() == 0) return "-1";
        return builder.reverse().toString();
    }
}