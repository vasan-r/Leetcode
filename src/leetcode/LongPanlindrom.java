package leetcode;

public class LongPanlindrom {
    public static void main(String[] args) {
        String s = "babad";

//        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {

        if(isPalindrom(s)){
            return s;
        }return s;
    }

    private static boolean isPalindrom(String s) {
        int f = 0;
        int l = s.length()-1;
        while (f<l){
            if(s.charAt(f) != s.charAt(l)){
                return false;
            }
            f++;
            l--;
        }return true;
    }
//    private static String subString(String p,String  up){
//        if(up.isEmpty()){
//            if(isPalindrom(p)){
//                return p;
//            }
//
//        }
//        char ch = up.charAt(0);
//
//        subString(p+ch,up.substring(1));
//        subString(p,up.substring(1));
//
//
//    }
}
