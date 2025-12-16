import javax.swing.*;

void main() {
    Scanner input = new Scanner(System.in);
    String string = null;
    int number = 0 ;
    while (true) {
        try {
            System.out.println("pls enter a number:");
            string = input.nextLine();
            number = Integer.parseInt(string);
            System.out.println("The number is " + number);
        } catch (NumberFormatException e) {
            System.out.println("Not valid");
        }
    }
}
