
void main() {
    Scanner input = new Scanner(System.in);
    System.out.println("pls enter your age");
    try {
        int age = input.nextInt();
        if (age < 18) {
            throw new AgeCheckingException("too young");
        }
        System.out.println("you are good");
    }catch (AgeCheckingException e){
        System.out.println(e.getMessage());
    }

}
