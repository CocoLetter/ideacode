import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {
    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> hashMap = new ConcurrentHashMap<>();
        String s = "";
        System.out.println(s);
    }

}


class Test {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.printf("%tD%n", date);
    }
}

class test {
    public static void main(String[] args) {

        Deque<Integer> stack = new ArrayDeque<>();
        stack.peek();
        System.out.println(null!=stack.peek());
        int[] sum = new int[]{1, 2, 2, 3};
        int result = Arrays.stream(sum)
                .reduce(0, Integer::sum);
        System.out.println(result);
//        System.out.println(checkValue(8300));
    }


    static boolean checkValue(int num) {
        int d1, d2, d3;
        int checkNum, nRemain, rem;

        checkNum = num % 10;
        nRemain = num / 10;
        d3 = nRemain % 10;
        nRemain /= 10;
        d2 = nRemain % 10;
        nRemain /= 10;
        d1 = nRemain % 10;
        rem = (d1 + d2 + d3) % 7;
        return rem == checkNum;
    }
}


class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int length = input.length();

        if (input.equals("\"") || input.indexOf('"') != 0 || input.lastIndexOf('"') != length - 1 || input.lastIndexOf("\"") == length - 2) {
            System.out.println("false");
            return;
        }


        int from = 1;
        int index = 0;
        while (index < length - 1) {
            index = input.indexOf('"', from);
            if (index > 0 && index < length - 1) {
                if (input.charAt(index - 1) != '\\') {
                    System.out.println("false");
                    return;
                } else if (input.charAt(index - 2) == '\\') {
                    System.out.println("false");
                    return;
                } else {
                    from = index + 1;
                }

            }

        }
        System.out.println("true");


        // System.out.println("true");
        // or
        // System.out.println("false");
    }
}


class Main1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.length() < 2) {
            System.out.println("false");
            return;
        }
        if (input.charAt(0) != '"' || input.charAt(input.length() - 1) != '"') {
            System.out.println("false");
            return;
        }
        int k = 2;
        for (int i = 1; i < input.length() - 1; i++) {
            if (input.charAt(i) == '\\') {
                k--;
            }

            if (input.charAt(i) == '"') {
                k++;
            }
        }
        if (k == 2) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}


class Solution1 {
    public static void main(String[] args) {

        String a = "abba";
        String b = "dog dog dog dog";
        boolean b1 = wordPattern(a, b);
        System.out.println(b1);


    }

    public static boolean wordPattern(String pattern, String str) {
        HashMap map = new HashMap<Character, String>();
        int length = pattern.length();
        String[] strings = str.split(" ");
        if (length != strings.length)
            return false;
        for (int i = 0; i < length; i++) {
            char a = pattern.charAt(i);
            if (map.containsKey(a)) {
                if (!map.get(a).equals(strings[i]))
                    return false;
            } else {
                if (map.containsValue(strings[i]))
                    return false;
                else
                    map.put(a, strings[i]);
            }
        }
        return true;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

}

class Solution2 {

    public static void main(String[] args) {
//        ListNode listNode = new ListNode(0);
//        ListNode head = new ListNode(0);
//        head.next=listNode;
//        System.out.println(isPalindrome(head));

        List<Integer> result = new ArrayList<>();
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;

        ListNode result = new ListNode(0);
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = result.next;
            result.next = slow;
            slow = temp;
        }
        result = result.next;
        while (result != null) {
            if (result.val != head.val)
                return false;
            else {
                result = result.next;
                head = head.next;
            }
        }
        return true;
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution12 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }


    int max = 0;
    int count = 0;
    ArrayList<Integer> result = new ArrayList<>();
    TreeNode temp = new TreeNode(Integer.MAX_VALUE);


    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] result1 = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            result1[i] = result.get(i);
        }
        return result1;
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        if (root.val == temp.val) {
            count++;
        } else {
            temp.val = root.val;
            count = 1;
        }
        if (count == max) {
            result.add(root.val);
        }
        if (count > max) {
            max = count;
            result = new ArrayList();
            result.add(root.val);
        }
        inOrder(root.right);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
//        TreeNode treeNode2 = new TreeNode(2);
        treeNode.right = treeNode1;
//        treeNode1.left=treeNode2;
        Solution12 solution = new Solution12();
        int[] a = solution.findMode(treeNode);
        for (int num : a) {
            System.out.println(num);
        }
//        System.out.println(a);
    }


}

class Solution123 {
    public static void main(String[] args) {
        Solution123 solution123 = new Solution123();
        int[][] input = {{2, 4}, {2, 5}, {1, 2}, {1, 3}, {3, 6}, {3, 7}, {6, 7}};
        solution123.findRedundantConnection(input);
    }

    class UF {
        int[] arr;
        int[] size;

        UF(int n) {
            arr = new int[n + 1];
            size = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                arr[i] = i;
                size[i] = 1;
            }
        }

        public int find(int p) {
            //这样做的目的在于两个集合相连的时候 可能也就是根节点和叶子节点不一致  这时候可以校准
            while (arr[p] != p) {
                arr[p] = arr[arr[p]];
                p = arr[p];
            }
            return p;
//            if(arr[p]!=p)
//            return arr[p];
        }

        public void union(int p, int q) {
            int rootp = find(p);
            int rootq = find(q);
            System.out.println("\n" + "实际连接" + rootp + "<--" + rootq);
            System.out.println();
            if (rootp == rootq)
                return;
            if (size[rootp] < size[rootq]) {
                arr[rootp] = rootq;
                size[rootq] += size[rootp];
            } else {
                arr[rootq] = rootp;
                size[rootp] += size[rootq];
            }
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            for (int num : size) {
                System.out.print(num + " ");
            }
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length);
        for (int[] t : edges) {
            if (uf.connected(t[0], t[1]))
                return t;
            System.out.println("\n连接" + t[0] + "<--" + t[1]);
            System.out.println();
            uf.union(t[0], t[1]);
        }
        return null;


    }

}


class Solution90 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graphic = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graphic[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            graphic[pre[0]].add(pre[1]);
        }
        boolean[] globalMarked = new boolean[numCourses];
        boolean[] localMarked = new boolean[numCourses];
//        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(globalMarked, localMarked, graphic, i, list)) {
                return new int[]{};
            }
        }
        int[] orders = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            orders[i] = list.remove();
        }
        return orders;

        // return true;
    }

    private boolean hasCycle(boolean[] globalMarked, boolean[] localMarked, List<Integer>[] graphic, int curNode, LinkedList<Integer> list) {

        if (localMarked[curNode]) {
            return true;
        }
        if (globalMarked[curNode]) {
            return false;
        }
        globalMarked[curNode] = true;
        localMarked[curNode] = true;
        for (int nextNode : graphic[curNode]) {
            if (hasCycle(globalMarked, localMarked, graphic, nextNode, list)) {
                return true;
            }
        }
        list.push(curNode);
        localMarked[curNode] = false;
        return false;
    }

    public static void main(String[] args) {
        StringBuffer t = new StringBuffer("$#");
        t.charAt(0);
        StringBuilder b = new StringBuilder("23");
        b.charAt(1);
//        b.append


    }

}


class Solution898 {

    public static void main(String[] args) {
        Solution898 solution898 = new Solution898();
        System.out.println(solution898.numOfWays(new int[]{9, 4, 2, 1, 3, 6, 5, 7, 8, 14, 11, 10, 12, 13, 16, 15, 17, 18}));
    }

    public int numOfWays(int[] nums) {
        int len = nums.length;

        ArrayList<Integer> Tree = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            Tree.add(nums[i]);
        }
        return generate(Tree).subtract(BigInteger.valueOf(1)).mod(BigInteger.valueOf(1000000007)).intValue();
    }


    public BigInteger generate(ArrayList<Integer> Tree) {
        if (Tree.size() <= 2) return BigInteger.valueOf(1);
        ArrayList<Integer> leftTree = new ArrayList<>();
        ArrayList<Integer> rightTree = new ArrayList<>();
        for (int i = 1; i < Tree.size(); i++) {
            if (Tree.get(i) < Tree.get(0)) {
                leftTree.add(Tree.get(i));
            } else {
                rightTree.add(Tree.get(i));
            }
        }
        return function(leftTree.size(), rightTree.size()).multiply(generate(leftTree)).multiply(generate(rightTree));
    }

    public BigInteger function(int a, int b) {
        if (a == 0 || b == 0) return BigInteger.valueOf(1);
        BigInteger result = BigInteger.valueOf(1);
        for (int i = a + b; i >= b + 1; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        for (int i = a; i > 1; i--) {
            result = result.divide(BigInteger.valueOf(i));
        }
        return result;
    }
}


class Solution878987 {
    public static void main(String[] args) {
        Solution878987 solution878987 = new Solution878987();
        System.out.println(solution878987.canPartition(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 100}));
    }

    //遍历 回溯
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).reduce(0, Integer::sum);
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        return generate(nums, 0, 0, target);
    }

    public boolean generate(int[] nums, int index, int sum, int target) {
        if (index > nums.length - 1) return false;
        int newSum = sum + nums[index];
        if (newSum == target) return true;
        else if (newSum < target) {
            if (generate(nums, index + 1, newSum, target)) {
                return true;
            }
        }
        return generate(nums, index + 1, sum, target);
    }
}

class Solutio8789n {
    public static void main(String[] args) {
        Solutio8789n solutio8789n = new Solutio8789n();
        int[] array = new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100};
        System.out.println(solutio8789n.canPartition(array));
    }


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
        int target = sum / 2;
        return generate(nums, 0, target);
    }

    public boolean generate(int[] nums, int index, int target) {
        if (target < 0) return false;
        if (index > nums.length - 1) return false;
        if (nums[index] == target) return true;
        if (nums[index] > target) return generate(nums, index + 1, target);

        return generate(nums, index + 1, target) || generate(nums, index + 1, target - nums[index]);
    }

}


class Solution897 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE + " :" + Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.MAX_VALUE + " :" + Integer.toBinaryString(1 << 31));

        System.out.println(Integer.MAX_VALUE + " :" + Integer.toBinaryString(Integer.MAX_VALUE >> 1));
        System.out.println(Integer.MAX_VALUE + " :" + Integer.toBinaryString(Integer.MAX_VALUE << 2));
        System.out.println(Integer.MIN_VALUE + " :" + Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.MIN_VALUE + " :" + Integer.toBinaryString(Integer.MIN_VALUE << 2));
        System.out.println(Integer.MIN_VALUE + " :" + Integer.toBinaryString(Integer.MIN_VALUE >> 4));
        System.out.println(Integer.MIN_VALUE + " :" + Integer.toBinaryString(Integer.MIN_VALUE / 4));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(0));
        System.out.println(2);
        System.out.println(-3 / 2);
        System.out.println(-3 % 2);
        System.out.println(-1 / 2);
        System.out.println(-1 % 2);

        System.out.println(1 << 31 | 1 << 31);
        System.out.println(1 << 31);
    }


}

class Solution987978 {
    public static void main(String[] args) {
//        System.out.println((1<<31) -1);
//
//        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
//        //  1111111111111111111111111111111
//        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE / 2));
//        //   111111111111111111111111111111
//        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE*2));
//        // 11111111111111111111111111111110
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
//        //10000000000000000000000000000000
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE/2));
//        //11000000000000000000000000000000
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE*2));
//        //0
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE >> 2));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE / 4));

        System.out.println();

        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE << 2));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE * 4));

        System.out.println(Integer.toBinaryString(-1313));
        System.out.println(Integer.toBinaryString(-1313 >> 2));
        System.out.println(-1313 >> 2);
        System.out.println(Integer.toBinaryString(-1313 / 4));
        System.out.println((-1313 / 4));

        System.out.println();

        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE >> 2));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE / 4));
    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
            System.out.println(Integer.toBinaryString(n));
        }
        return res;
    }
}

class Solution131 {
    public int[] printNumbers(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i < Math.pow(10, n); i++) {
            list.add(i);
        }
        int[] b = list.stream().mapToInt(Integer::valueOf).toArray();
        return b;
    }
}


class Solution89098 {
    public static void main(String[] args) {
        Solution89098 solution89098 = new Solution89098();
        Arrays.stream(solution89098.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})).forEach(System.out::println);
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;

        int[] res = new int[(r + 1) * (b + 1)];
        int index = 0;
        while (true) {
            for (int y = l; y <= r; y++) {
                res[index++] = matrix[t][y];
            }
            if (++t > b) break;
            for (int x = t; x <= b; x++) {
                res[index++] = matrix[x][r];
            }
            if (--r < l) break;

            for (int y = r; y >= l; y--) {
                res[index++] = matrix[b][y];
            }
            if (--b < t) break;

            for (int x = b; x >= t; x--) {
                res[index++] = matrix[x][l];
            }
            if (++l > r) break;

        }
        return res;
    }
}





class Solution0899 {
    public int[] levelOrder(TreeNode root) {
        //层次遍历
        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        list.add(root);

        levelOrder(list,result);
        int[] res = result.stream().mapToInt(Integer::valueOf).toArray();

        return res;
    }

    public void levelOrder(LinkedList<TreeNode> list,LinkedList<Integer> result){
        while(!list.isEmpty()){
            TreeNode node = list.removeLast();
            result.add(node.val);
            if(node.left!=null){
                list.push(node.left);
            }
            if(node.right!=null){
                list.push(node.right);
            }
        }
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution5756 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> addList = null;
        stack1.push(root);
        while(!stack1.isEmpty()||!stack2.isEmpty()){
            if(!stack1.isEmpty()){
                addList = new LinkedList<>();
                while(!stack1.isEmpty()){
                    TreeNode node = stack1.pop();
                    addList.add(node.val);
                    stack2.push(node.left);
                    stack2.push(node.right);
                }
                result.add(addList);
            }
            if(!stack2.isEmpty()){
                addList=new LinkedList<>();
                while(!stack2.isEmpty()){
                    TreeNode node = stack2.pop();
                    addList.add(node.val);
                    stack1.push(node.right);
                    stack1.push(node.left);

                }
            }


        }
        return result;

    }
}


