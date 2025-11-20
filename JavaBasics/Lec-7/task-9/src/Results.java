public class Results {

    public int CalculateResults(int number1 , int number2) {
        if(number2 == 0){
            throw new ArithmeticException("Error... Division by zero");
        }

        return ( number1 / number2 );
    }
}
