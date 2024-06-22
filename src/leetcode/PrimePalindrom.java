package leetcode;

public class PrimePalindrom {
    public static void main(String[] args) {
        System.out.println(primePalindrome(6));
    }
    public static int primePalindrome(int n) {

        int temp = n;
        while (true){
            if(isPrime(temp) && isPalindrom(temp) ) {
                return temp;
            }
            else {
                temp++;
            }
        }
    }
    public static boolean isPalindrom(int n){
        int f = 0;
        String s = n+"";
        int l = s.length()-1;
        while (f<l){
            if(s.charAt(f)==s.charAt(l)){
                f++;
                l--;
            }else {
                return false;
            }
        }return true;
    }
    public static boolean isPrime(int n){
        boolean isPrime = true;
        int squareRoot = (int)Math.sqrt(n);
        for (int i = 2; i < squareRoot; i++) {
            if(n%i==0){
                isPrime=false;
                break;
            }
        }
        return isPrime;
    }
}
