//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner input = new Scanner(System.in);
    String username = null;
    String UpperCaseName = null ;
    while(true) {
        try {
            System.out.println("pls enter your name");
            username = input.nextLine();

            if (username == null || username.trim().isEmpty()) {
                throw new NullPointerException();
            }

            UpperCaseName = UpperCase(username);
            System.out.println("Your name is " + UpperCaseName);
        } catch (NullPointerException e) {
            System.out.println("Not valid");
        }
    }
}

String UpperCase (String name) {
    return name.toUpperCase();
}