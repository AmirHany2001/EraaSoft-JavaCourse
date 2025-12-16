import javax.swing.*;

void main() {
    try {
        int number1 = 1;
        int number2 = 0;
        int result = number1 / number2 ;
    } catch(ArithmeticException  e) {
        System.out.println("Division by zero");
        return;
    }finally {
        System.out.println("bye bye");
    }
}
