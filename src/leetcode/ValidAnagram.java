package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String str = "anaram";
        String t = "agaram";

        System.out.println(isAnagram2(str,t));
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            if(!list.contains(t.charAt(i))){
                return false;
            }list.remove((Character) t.charAt(i));

        }return true;
    }
    public static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1,str2);

    }
}
