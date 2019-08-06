public class NumberPalindrome {
    public static boolean isPalindrome(int number){
        String str1 = "";
        String str2 = "" + number;
        System.out.println(str2);
        while(number != 0){
            str1 += number%10;
            number = number/10;

        }
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        if(str2.equals(str1))
            return true;
        return false;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(11));
    }
}
