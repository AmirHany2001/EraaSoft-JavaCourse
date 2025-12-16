
void main() {
    String name = null;
    int number1 = 0;
    int number2 = 0;
    int result = 0;
    Scanner input = new Scanner(System.in);
    try{
        System.out.println("Enter your name: ");
        name = input.nextLine();

        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException();
        }

        System.out.println("lets calculate :) ");
        System.out.println("Enter your first number: ");

        number1 = input.nextInt();
        System.out.println("Enter your second number: ");
        number2 = input.nextInt();
        result = number1 / number2;
        System.out.println("Your name is: " + name + "\n" + "Your result is: " + result);
    }catch(NullPointerException e){
        System.out.println("not valid name");
    }catch (ArithmeticException e){
        System.out.println("not valid operation");
    }
}
