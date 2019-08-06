public class DecimalComparator{
    public static boolean areEqualByThreeDecimalPlaces(double numOne, double numTwo){
        System.out.println(numOne-numTwo);
        if((int) numOne == (int) numTwo){
            double diffNumbers = numOne - numTwo;
            System.out.println(diffNumbers);
            if(diffNumbers != 0.0){
                if(diffNumbers < 0){
                    diffNumbers = -(diffNumbers);
                }
                if((diffNumbers >= 0.0001) && (diffNumbers <= 0.0009)){
                    return true;
                }

                else
                    return false;
            }

            else
                return true;
        }
        return false;
    }
}
