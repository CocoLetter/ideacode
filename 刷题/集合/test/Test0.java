import org.junit.Test;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;

class Main333 {
    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        System.out.println(1000000006L*1000000006L);

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
//        concurrentHashMap.put()
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int a=sc.nextInt();
        int b=sc.nextInt();
        int l=sc.nextInt();
        int r=sc.nextInt();
        //int k=1,a=1,b=1,l=2,r=3;
        long sum=0;
        long cf=0;
        int n=1000000007;
        for(int i=l;i<=r;i++){
            cf=help(i,k,a,b);
            sum=((sum%n)+(cf%n))%n;
        }
        System.out.println(sum);
    }
    //求cfik
    public static long help(int x,int k,int a,int b){
        long sum=0;
        long fi=qiufn(x,a,b);
        long jcf=jiecheng(fi);
        long jck=jiecheng(k);
        long fk=fi-k;
        long jcfik=jiecheng(fk);
        sum=jcf/jck/jcfik;
        return sum;
    }
    //求阶乘
    public static long jiecheng(long p){
        long sum=1;
        for(long i=p;i>0;i++){
            sum=sum*p;
            p-=1;
        }
        return sum;
    }
    //求f
    public static long qiufn(int n,int a,int b){
        int i=3;
        long f1=1,f2=1;
        long fi=0;
        if(n<3) fi=1;

        while(i<=n){
            fi=a*f2+b*f1;
            f2=fi;
            f1=f2;
            i++;
        }
        return fi;
    }
}




public class Test0 {
    /**
     * 10
     * >.wwws..s.
     * .>.wwws.s.
     * >>>>>s.m.m
     * >w.wss..s.
     *
     *
     */

    @Test
    public void test3() {
        long sum = 1;
        long curr= 1 ;
        System.out.println(Long.MAX_VALUE);
        for (int i = 2; i <= 30; i++) {
            long add = cal(curr);
            curr = add;
            sum += add;
            sum = sum % 1000000007;
        }
        System.out.println(sum);//175
        //175
    }

    public long cal(long curr) {
        long sum = 0;
        for(long i = 1 ;i <= curr+5;i++){
            sum += curr;
            sum = sum % 1000000007;
        }
        return sum;
    }



    @Test
    public void test3532() {
        long sum = 1;
        long curr= 1 ;
        for (int i = 2; i <= 30; i++) {
            curr = curr*(curr+5);
            curr = curr%1000000007;
            sum += curr;
            sum = sum % 1000000007;
        }
        System.out.println(sum);
//        System.out.println(sum%1000000007);//455053094
        System.out.println(Long.MAX_VALUE);//37397095
        //937527335
    }

    @Test
    public void test98() {
        // n m
        int n = 100;
        int m = 9;
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<List<Integer>> res = new LinkedList<>();
        cal(1,n,m,res,list);
        System.out.println(res.size());
    }

    public void cal(int left, int right,int target, List<List<Integer>> res, LinkedList<Integer> list) {
        if (target==0) {
            list.stream().forEach(System.out::print);
            System.out.println();
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if (left>right||left > target) return;
        else{
            list.add(left);
            cal(left+1,right,target-left,res,list);
            list.removeLast();
            cal(left+1,right,target,res,list);
        }
    }


    @Test
    public void test98798() {
        System.out.println(Integer.MAX_VALUE);
        int n = 100;
        int m = 9;
        ArrayList[] array = new ArrayList[m + 1];
        for (int i = 0; i <= m; i++) {
            array[i] = new ArrayList<ArrayList<Integer>>();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= i; j--) {
                if (j == i) {
                    ArrayList<Integer> first = new ArrayList<>();
                    first.add(i);
                    array[i].add(first);
                }
                for (int k = 0; k < array[j - i].size(); k++) {
                    ArrayList<Integer> o = (ArrayList<Integer>) array[j - i].get(k);
                    ArrayList<Integer> integers = new ArrayList<>(o);
                    integers.add(i);
                    array[j].add(integers);
                }
            }
        }
        System.out.println(array[m].size());
    }


    public void test8989(int cur, int n, int target) {
        if (cur == target) return;


    }


    public void test67867() {
        String name = "hisdi";
        // 读入数据的代码
        Scanner reader = new Scanner(System.in);
        // 物品的数量为N
        int N = reader.nextInt();
        // 背包的容量为V
        int V = reader.nextInt();
        // 一个长度为N的数组，第i个元素表示第i个物品的体积；
        int[] v = new int[N + 1];
        // 一个长度为N的数组，第i个元素表示第i个物品的价值；
        int[] w = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            // 接下来有 N 行，每行有两个整数:v[i],w[i]，用空格隔开，分别表示第i件物品的体积和价值
            v[i] = reader.nextInt();
            w[i] = reader.nextInt();
        }
        reader.close();

        int[][] dp = new int[N + 1][V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }
        System.out.println(dp[N][V]);
    }

    @Test
    public void testFactors() {
        Condition[] conditions = new Condition[5];

        List<List<Integer>> factors = getFactors(12);
        System.out.println("ok");
    }

    //
    int target = 0;

    public List<List<Integer>> getFactors(int n) {
        this.target = n;
        Queue<LinkedList<Integer>> queue = new LinkedList<>();
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        HashSet<Integer> remainSet = new HashSet<>();
        backtrack(n, path, list);
        System.out.println(list.size());
        for (List l : list) {
            Collections.sort(l);
        }
        HashSet hashSet = new HashSet(list);
        return new ArrayList<>(hashSet);
    }

    public void backtrack(int remain, List<Integer> path, List<List<Integer>> list) {
        if (remain == 1) {
            ArrayList arrayList = new ArrayList(path);
            list.add(arrayList);
        }
        for (int i = 2; i <= remain; i++) {
            if (i == target) return;
            if (remain % i == 0) {
                path.add(i);
                backtrack(remain / i, path, list);
                path.remove(path.size() - 1);
            }
        }
    }


    @Test
    public void testMax() {
//        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
//        int[] ints = {1, 2, 3, 5};
//        int[] ints1 = Arrays.copyOfRange(ints, 4, 6);
//        System.out.println(ints1);
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        LinkedList linkedList1 = new LinkedList();
        linkedList1.add(1);
        linkedList1.add(2);
        linkedList1.add(3);

        System.out.println(linkedList.hashCode());
        System.out.println(linkedList1.hashCode());

    }


    @Test
    public void teset() {
        eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}});
        int[] ints = {1, 8, 2, 3, 4};
        Arrays.sort(ints);
        System.out.println(Integer.compare(-2147483645, 2147483647));
        System.out.println(-2147483645 - 2147483647);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (e1, e2) -> e1[1] - e2[1]);

        return 8;
    }

    @Test
    public void index5() {
        Integer[] scores = {1, 2, 3, 89, 4};
        for (Integer i : scores) {
            System.out.println(i);
        }
    }


    public int[][] dptable;

    public int minDistance(String word1, String word2) {
        dptable = new int[word1.length() + 1][word2.length() + 1];
        for (int[] row : dptable) {
            Arrays.fill(row, -1);
        }
        return dp(word1, word2, word1.length(), word2.length());
    }

    private int dp(String word1, String word2, int index1, int index2) {
        // if(dptable[index1][index2]!=-1) return dptable[index1][index2];
        if (index1 == 0) {
            dptable[0][index2] = index2;
            return dptable[0][index2];
        }
        if (index2 == 0) {
            dptable[index1][0] = index1;
            return dptable[index1][0];
        }
        if (word1.charAt(index1 - 1) == word2.charAt(index2 - 1)) {
            if (dptable[index1 - 1][index2 - 1] == -1) {
                dptable[index1 - 1][index2 - 1] = dp(word1, word2, index1 - 1, index2 - 1);
            }
            dptable[index1][index2] = dptable[index1 - 1][index2 - 1];
            return dptable[index1][index2];
        } else {
            if (dptable[index1][index2] == -1) {
                //insert
                System.out.println("insert" + index1 + ":" + (index2 - 1));
                int insert = dp(word1, word2, index1, index2 - 1);
                //delete
                System.out.println("delete" + (index1 - 1) + ":" + (index2));
                int delete = dp(word1, word2, index1 - 1, index2);
                //replace
                System.out.println("replace" + (index1 - 1) + ":" + (index2 - 1));
                int replace = dp(word1, word2, index1 - 1, index2 - 1);

                dptable[index1][index2] = Math.min(Math.min(insert, delete), replace) + 1;
            }
            return dptable[index1][index2];
        }
    }

    @Test
    public void testString() {
        String path = "";
        path = path + String.valueOf(2);
        System.out.println(path);
//        String s = "adafg";
//        String s1 = "adafg";
//        String s2 = new String("adafg");
//
//
//        int i = s.hashCode();
//        System.out.println(i);
//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());
    }

    @Test
    public void testLong() {
//        lastRemaining(5,2);

        int[][] ints = new int[4][3];
        System.out.println(Arrays.stream(ints).mapToInt(e -> (int) Arrays.stream(e).count()).sum());
    }

    public int lastRemaining(int n, int m) {
        List<Integer> circle = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            circle.add(i);
        }
        return lastRemaining(circle, m, 0);
    }

    public int lastRemaining(List<Integer> circle, int m, int start) {
        if (circle.size() == 1) return circle.get(0);
        System.out.println(circle.get((start + m - 1) % circle.size()));
        circle.remove((start + m - 1) % circle.size());
        start = (start + m - 1) % circle.size();
        return lastRemaining(circle, m, start);

    }

    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) continue;
            if (!map.containsKey(nums[i])) {
                if (!map.containsKey(nums[i] - 1) && !map.containsKey(nums[i] + 1)) {
                    map.put(nums[i], nums[i]);
                }
                if (map.containsKey(nums[i] - 1) && map.containsKey(nums[i] + 1)) {
                    int tmp = map.get(nums[i] - 1);
                    int tmp1 = map.get(nums[i] + 1);
                    map.put(map.get(nums[i] - 1), map.get(nums[i] + 1));
                    map.put(map.get(nums[i] + 1), tmp);
                    maxLen = Math.max(tmp1 - tmp + 1, maxLen);
                } else {
                    if (map.containsKey(nums[i] - 1)) {
                        if (map.get(nums[i] - 1) < nums[i]) {
                            int tmp = map.get(nums[i] - 1);
                            map.put(nums[i], map.get(nums[i] - 1));
                            map.put(map.get(nums[i] - 1), nums[i]);
                            maxLen = Math.max(maxLen, nums[i] - tmp + 1);

                        }
                    }
                    if (map.containsKey(nums[i] + 1)) {
                        if (map.get(nums[i] + 1) > nums[i]) {
                            int tmp = map.get(nums[i] + 1);
                            map.put(nums[i], map.get(nums[i] + 1));
                            map.put(map.get(nums[i] + 1), nums[i]);
                            maxLen = Math.max(tmp - nums[i] + 1, maxLen);
                        }
                    }
                }

            }
        }
        return maxLen;
    }

    @Test
    public void testarr() {
        int[] ints = new int[2];
        ints[0]++;
        System.out.println(ints[0]);
    }


    @Test
    public void testminNumber() {
//        minNumber(new int[]{1,2,3,1});

        String s = "io";
        System.out.println(s.substring(2));
        System.out.println(s.substring(1));

//        PriorityQueue<Integer> queue = new PriorityQueue<>((x,y)->y-x);
//        queue.offer(1);
//        queue.offer(2);
//        queue.offer(3);
//        queue.offer(1);

    }


    @Test
    public void test124324() {
        System.out.println(Math.pow(10, 76438));
        System.out.println(findNthDigit(1000000000));
        System.out.println(findNthDigit(298906448));

    }

    public int findNthDigit(int n) {
        n++;
        //找到n对应数字是几位数
        int nums = 1;
        int max = 10;
        int min = 1;
        while (n > max) {
            nums++;
            min = max + 1;
            if (n - min < 9 * Math.pow(10, nums - 1)) break;
            max = (int) (Math.pow(10, nums) - Math.pow(10, nums - 1)) * nums + max;
            System.out.println(min);
            System.out.println(max);
            System.out.println(nums);
        }

        int k = (n - min) / nums;
        int mode = (n - min) % nums;

        String result = String.valueOf((nums == 1 ? 0 : (int) Math.pow(10, nums - 1)) + k);
        System.out.println(result);
        System.out.println(mode);
        System.out.println(result.charAt(mode));
        return result.charAt(mode) - '0';

    }


    @Test
    public void testLinkedList() {

        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(90);
        integers.addLast(99);
        integers.addFirst(33);
        integers.add(0);
        integers.stream().forEach(System.out::print);

        LinkedList<Integer> integers1 = new LinkedList<>(integers);
        integers.stream().forEach(System.out::println);
        integers.set(0, 5);
        integers.stream().forEach(System.out::println);
        integers1.stream().forEach(System.out::println);


    }


    @Test
    public void deserialize() {
        String data = "[1,null,2,3]";
        int[] array = Arrays.stream(data.substring(1, data.length() - 1)
                .split(","))
                .mapToInt(e -> {
                    if (e.equals("null"))
                        return Integer.MIN_VALUE;
                    else
                        return Integer.valueOf(e);
                }).toArray();


        Arrays.stream(array).forEach(System.out::println);
        return;

    }

    @Test
    public void test() {
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        System.out.println(queue.peek());
//        LinkedList<Object> objects = new LinkedList<>();
        System.out.println(String.valueOf(90));

    }

    @Test
    public void testgetLeastNumbers() {
        int[] arr = new int[]{0, 1, 2, 1};
        int k = 1;
        Arrays.stream(getLeastNumbers(arr, k)).forEach(System.out::println);

    }


    public int[] getLeastNumbers(int[] arr, int k) {
        return findK(arr, 0, arr.length - 1, k - 1);
    }

    public int[] findK(int[] arr, int head, int tail, int target) {
        int res = partition(arr, head, tail);
        if (res == target) return Arrays.copyOfRange(arr, 0, target + 1);
        else if (res > target) {
            return findK(arr, head, res - 1, target);
        } else {
            return findK(arr, res + 1, tail, target);
        }
    }

    public int partition(int[] arr, int head, int tail) {
        if (head == tail) return head;
        int record = arr[head];
        int i = head;
        int j = tail + 1;
        while (true) {
            while (++i < tail && arr[i] <= record) ;//左边的都是比中间点小的
            while (--j > head && arr[j] >= record) ;//这样保证相等的在右边
            if (i >= j) break;
            int tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
        }
        arr[head] = arr[j];
        arr[j] = record;
        return j;
    }


    // Decodes your encoded data to tree.

}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 * //尝试每条路径
 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution878 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> path = new LinkedList<>();
        LinkedList<List<Integer>> result = new LinkedList<>();
        pathSum(root, sum, path, result);
        return result;
    }

    public void pathSum(TreeNode root, int sum, LinkedList<Integer> path, List<List<Integer>> result) {
        if (root == null) return;
        if (root.val == sum) {
            if (path.size() == 0) return;
            path.add(root.val);
            result.add(new LinkedList(path));
            path.removeLast();
        }
        if (sum > root.val) {
            path.add(root.val);
            pathSum(root.left, sum - root.val, path, result);
            pathSum(root.right, sum - root.val, path, result);
            path.removeLast();
        }
    }

}


class Codec876867 {
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {
            {add(root);}
        };
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else res.append("null,");
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
//        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if (!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }


}


class MedianFinder {

    int count;
    PriorityQueue<Integer> minQueue = null;
    PriorityQueue<Integer> maxQueue = null;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        count = 0;
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>((x, y) -> y - x);
    }

    public void addNum(int num) {
        //奇数的时候中位数在max
        if (count == 0) maxQueue.add(num);
        if (count % 2 == 0) {
            if (num > minQueue.peek()) {
                maxQueue.add(num);
            } else {
                maxQueue.add(minQueue.poll());
                minQueue.add(num);
            }
        } else {
            if (num > maxQueue.peek()) {
                minQueue.add(maxQueue.poll());
                maxQueue.add(num);
            } else {
                minQueue.add(num);
            }
        }
    }

    public double findMedian() {
        if (count % 2 == 0) return ((double) (minQueue.peek() + maxQueue.peek())) / 2;
        else return maxQueue.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


class Solution12 {

}

class Solution5346 {
    public String minNumber(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<Integer>(this::myCompare);
        Arrays.stream(nums).forEach(queue::offer);
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            builder.append(queue.poll());
        }
        return builder.toString();
    }

    public int myCompare(Integer x, Integer y) {
        int powX = String.valueOf(x).length();
        int powY = String.valueOf(y).length();
        return (int) ((x * Math.pow(10, powY) + y) - (y * Math.pow(10, powX) + x));
    }
}

class Solution3543 {
//    public String minNumber(int[] nums) {
//        String[] strs = new String[nums.length];
//        for(int i = 0; i < nums.length; i++)
//            strs[i] = String.valueOf(nums[i]);
//        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
//        StringBuilder res = new StringBuilder();
//        String s="c";
//        String s1 = Character.toString(s.charAt(0));
//        for(String s : strs)
//            res.append(s);
//        return res.toString();
//    }
}


class Solution342354 {


    public boolean isLegal(int i, int j, int len) {
        return i < len && i >= 0 && j < len && j >= 0;
    }
}


class Solution12423 {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) continue;
            if (!map.containsKey(nums[i])) {
                if (!map.containsKey(nums[i] - 1) && !map.containsKey(nums[i] + 1)) {
                    map.put(nums[i], nums[i]);
                }
                if (map.containsKey(nums[i] - 1) && map.containsKey(nums[i] + 1)) {
                    map.put(map.get(nums[i] - 1), map.get(nums[i] + 1));
                    map.put(map.get(nums[i] + 1), map.get(nums[i] - 1));
                    maxLen = Math.max(map.get(nums[i] + 1) - map.get(nums[i] - 1) + 1, maxLen);
                } else {
                    if (map.containsKey(nums[i] - 1)) {
                        if (map.get(nums[i] - 1) < nums[i]) {
                            map.put(nums[i], map.get(nums[i] - 1));
                            map.put(map.get(nums[i] - 1), nums[i]);
                            maxLen = Math.max(maxLen, nums[i] - map.get(nums[i] - 1) + 1);

                        }
                    }
                    if (map.containsKey(nums[i] + 1)) {
                        if (map.get(nums[i] + 1) > nums[i]) {
                            map.put(nums[i], map.get(nums[i] + 1));
                            map.put(map.get(nums[i] + 1), nums[i]);
                            maxLen = Math.max(map.get(nums[i] + 1) - nums[i] + 1, maxLen);
                        }
                    }
                }

            }
        }
        return maxLen;
    }
}
//
//class Solution54346 {
//
//    public int longestConsecutive(int[] nums) {
//        LinkedList<Object> objects = new LinkedList<>();
//        Object remove = objects.remove();
//        if(nums==null||nums.length==0) return 0;
//        HashMap<Integer,Boolean> map = new HashMap<>();
//        Arrays.stream(nums).forEach(e->map.put(e,true));
//        int maxLen = 0;
//        for(int num : nums){
//            if(map.get(num)){
//                int right = num+1;
//                int left = num;
//                int count = 0;
//                while(map.containsKey(right)){
//                    count++;
//                    map.put(right,false);
//                    right++;
//                }
//                while(map.containsKey(left)){
//                    count++;
//                    map.put(left,false);
//                    left--;
//                }
//                maxLen=Math.max(maxLen,count);
//            }
//        }
//        return maxLen;
//    }
//}
//class Solution {
//    public int sumNums(int n) {
//
//        int ans = 0, A = n, B = n + 1;
//        boolean flag;
//
//        flag = ((B & 1) > 0) && (ans += A) > 0;
//        A <<= 1;
//        B >>= 1;
//
//        flag = ((B & 1) > 0) && (ans += A) > 0;
//        A <<= 1;
//        B >>= 1;
//
//        flag = ((B & 1) > 0) && (ans += A) > 0;
//        A <<= 1;
//        B >>= 1;
//
//        flag = ((B & 1) > 0) && (ans += A) > 0;
//        A <<= 1;
//        B >>= 1;
//
//        flag = ((B & 1) > 0) && (ans += A) > 0;
//        A <<= 1;
//        B >>= 1;
//
//        flag = ((B & 1) > 0) && (ans += A) > 0;
//        A <<= 1;
//        B >>= 1;
//
//        flag = ((B & 1) > 0) && (ans += A) > 0;
//        A <<= 1;
//        B >>= 1;
//
//        flag = ((B & 1) > 0) && (ans += A) > 0;
//        A <<= 1;
//        B >>= 1;
//
//        flag = ((B & 1) > 0) && (ans += A) > 0;
//        A <<= 1;
//        B >>= 1;
//
//        flag = ((B & 1) > 0) && (ans += A) > 0;
//        A <<= 1;
//        B >>= 1;
//
//        flag = ((B & 1) > 0) && (ans += A) > 0;
//        A <<= 1;
//        B >>= 1;
//
//        flag = ((B & 1) > 0) && (ans += A) > 0;
//        A <<= 1;
//        B >>= 1;
//
//        flag = ((B & 1) > 0) && (ans += A) > 0;
//        A <<= 1;
//        B >>= 1;
//
//        flag = ((B & 1) > 0) && (ans += A) > 0;
//        A <<= 1;
//        B >>= 1;
//
//        return ans >> 1;
//    }
//}
//
//class Solution {
//    public int sumNums(int n) {
//        int[][] ints = new int[n][n+1];
//        return Arrays.stream(ints).mapToInt(e-> (int) Arrays.stream(e).count()).sum()>>1;
//    }
//}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
//class Solution {
//    private int mergeSortAndCount(int[] nums,int left, int mid ,int right,int[] tmp){
//        System.arraycopy(nums,left,tmp,left,right-left+1);
//
//
//
//    }
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (isAncestor(root.left, p) && isAncestor(root.left, q)) {
//            return lowestCommonAncestor(root, p, q);
//        } else if (isAncestor(root.right, p) && isAncestor(root.right, q)) {
//            return lowestCommonAncestor(root, p, q);
//        } else return root;
//    }
//
//    public boolean isAncestor(TreeNode root, TreeNode p) {
//        if (root == p) {
//            return true;
//        } else return isAncestor(root.left, p) || isAncestor(root.right, p);
//    }
//}
//


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 * //
 */
//class Solution {
//    public boolean isEvenOddTree(TreeNode root) {
//
//
//        Queue<TreeNode> list = new LinkedList<>();
//        list.add(root);
//        boolean flag= true;
//        while(!list.isEmpty()){
//            int size = list.size();
//            TreeNode node0 = list.poll();
//            add(list,node0);
//            int start = node0.val;
//            size--;
//            while(size-->0){
//                TreeNode node = list.poll();
//                if(((!flag)&&start<=node.val)||(flag&&start>=node.val)) return false;
//                add(list,node);
//                start= node.val;
//            }
//            flag  = !flag;
//        }
//        return true;
//    }
//    public void add(Queue<TreeNode> queue,TreeNode node){
//        if(node.left != null) queue.add(node.left);
//        if(node.right != null) queue.add(node.right);
//    }
//}


class Solution {
    public int[][] dptable;

    public int minDistance(String word1, String word2) {
        dptable = new int[word1.length() + 1][word2.length() + 1];
        for (int[] row : dptable) {
            Arrays.fill(row, -1);
        }
        return dp(word1, word2, word1.length(), word2.length());
    }

    private int dp(String word1, String word2, int index1, int index2) {
        if (dptable[index1][index2] != -1) return dptable[index1][index2];
        if (index1 == 0) {
            dptable[0][index2] = index2;
            return dptable[0][index2];
        }
        if (index2 == 0) {
            dptable[index1][0] = index1;
            return dptable[index1][0];
        }
        if (word1.charAt(index1 - 1) == word2.charAt(index2 - 1)) {
            if (dptable[index1 - 1][index2 - 1] == -1) {
                dptable[index1 - 1][index2 - 1] = dp(word1, word2, index1 - 1, index2 - 1);
            }
            dptable[index1][index2] = dptable[index1 - 1][index2 - 1];
            return dptable[index1][index2];
        } else {
            //insert
            int insert = dp(word1, word2, index1, index2 - 1);
            //delete
            int delete = dp(word1, word2, index1 - 1, index2);
            //replace
            int replace = dp(word1, word2, index1 - 1, index2 - 1);

            dptable[index1][index2] = Math.min(Math.min(insert, delete), replace) + 1;
            return dptable[index1][index2];
        }
    }
}


class Solution235 {

    HashSet set = new HashSet();

//    public void test(){
//        for(int i = 2 ;i <= (int)Math.sqrt((double)n) ;i++){
//            if(n%i==0){
//                LinkedList<Integer> addList = new LinkedList<>();
//                addList.add(i);
//                addList.add(n/i);
//                list.add(addList);
//                queue.add(addList);
//            }
//        }
//        while(!queue.isEmpty()){
//            LinkedList<Integer> poll = queue.poll();
//            int len = poll.size();
//            for(int i = 0 ; i < len ;i ++){
//                Integer m = poll.poll();
//                for(int j = 2 ;i <= (int)Math.sqrt((double)m) ;i++){
//                    if(m%i==0){
//                        LinkedList<Integer> addList = new LinkedList<>();
//                        addList.add(j);
//                        addList.add(m/j);
//                        list.add(addList);
//                        queue.add(addList);
//                    }
//                }
//            }
//        }
//    }


}
