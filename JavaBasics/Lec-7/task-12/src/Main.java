
void main() {
    try {
        try{
            int number1 = 1;
            int number2 = 0;
            int result = number1 / number2;
        }catch( ArrayIndexOutOfBoundsException e){
            System.out.println("Oh nooooo");
        }
    }catch(ArithmeticException ex){
        System.out.println("Division by zero");
    }
}
