package leetcode;

public class RotateString {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
//        System.out.println(s.startsWith(goal.substring(3)));
        System.out.println(rotateString(s,goal));
    }
    public static boolean rotateString(String s, String goal) {
        for (int i = 0; i < s.length(); i++) {
            String temp = goal.substring(i);
            if(s.startsWith(temp)){
                if(s.substring(temp.length()).equals(goal.substring(0,goal.length()-temp.length()))){
                    return true;
                }
            }
        }
        return false;
    }
}
