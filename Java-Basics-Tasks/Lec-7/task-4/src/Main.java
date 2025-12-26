
void main() {
    Scanner input = new Scanner(System.in);
    int index = 0;

    int [] array = new int[5];
    for(int i=0;i<5;i++) {
        array[i]=i;
    }

    while (true) {
        try {
            System.out.println("pls enter an index");
            index = input.nextInt();
            System.out.println("The array number is " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not valid index");
        }
    }
}
