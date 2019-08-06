public class NumberToWords {
    public static void numberToWords(int number) {
        if (number < 0)
            System.out.println("Invalid Value");
        String newStr = "";
        int getDigit;
        while (number != 0) {
            getDigit = number % 10;
            switch (getDigit) {
                case 0:
                    newStr = " Zero" + newStr;
                    break;
                case 1:
                    newStr = " One" + newStr;
                    break;
            }
            number = number / 10;
        }
        System.out.println(newStr);
    }

    public static void main(String[] args) {
        numberToWords(100);
    }
}
