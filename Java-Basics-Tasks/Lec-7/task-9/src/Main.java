
void main() {
    try{
        Scanner input = new Scanner(System.in);
        System.out.println("pls enter first number");
        int firstNumber = input.nextInt();
        System.out.println("pls enter second number");
        int secondNumber = input.nextInt();

        Results result = new Results();
        System.out.println("the result: " + result.CalculateResults(firstNumber,secondNumber));

    }catch (ArithmeticException e){
        System.out.println(e.getMessage());
    }
}
