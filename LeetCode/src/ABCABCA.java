import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ABCABCA {
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<>();

        int length = s.length();
        int rk = 0;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rk <= length - 1 && !set.contains(s.charAt(rk))) {
                set.add(s.charAt(rk));
                ++rk;
            }
            ans = Math.max(ans, set.size());

        }
        return ans;

    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }



    public static int lengthOfLongestSubstring3(String s){
        int length=s.length();
        int ans=0;
        Map<Character,Integer> map = new HashMap<>();
        for(int end=0,start=0;end<length;end++){
            char alpha = s.charAt(end);
            if(map.containsKey(alpha)){

                start=Math.max(map.get(alpha)+1,start);
//                start=Math.max(map.get(alpha)+1,start+1);
            }
            ans=Math.max(ans,end-start+1);
            map.put(s.charAt(end),end);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring5(String s) {
        int ans=0;
        int length=s.length();
        HashMap<Character,Integer> set=new HashMap<>();

        for (int end=0 ,start=0;end<length;end++){
            Character alpha = s.charAt(end);
            if(set.containsKey(alpha)){
                start=Math.max(set.get(alpha)+1,start);
                ans=Math.max(ans,end-start+1);//错误没有考虑单个字符的情况
            }

            set.put(alpha,end);
        }
        return ans;

    }


    public static void main(String[] args) throws UnsupportedEncodingException {
//        String test="heioaoaedauankdjghjfaueqk";
//        String test=" ";
//        System.out.println(lengthOfLongestSubstring3(test));
//        System.out.println(lengthOfLongestSubstring2(test));
//        System.out.println(lengthOfLongestSubstring1(test));
//        System.out.println(lengthOfLongestSubstring5(test));

        String yan = "严";
        byte[] bs = yan.getBytes("UTF-8");
        for (byte i : bs) {
            System.out.println(i);
        }
    }
}
//cdefoipboip