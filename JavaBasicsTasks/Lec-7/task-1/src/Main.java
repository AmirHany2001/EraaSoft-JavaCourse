import javax.swing.plaf.synth.SynthOptionPaneUI;

void main() {
    Scanner input = new Scanner(System.in);
    int number1 = 0;
    int number2 = 0;
    int result = 0;
    while (true) {
        try {
            System.out.println("pls enter first number");
            number1 = input.nextInt();
            System.out.println("pls enter second number");
            number2 = input.nextInt();
            result = number1 / number2;
            System.out.println("The result is: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Not Valid Operation");

        }
    }
}
