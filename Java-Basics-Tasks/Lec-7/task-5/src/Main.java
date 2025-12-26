
void main()  {
    String fileName = "C:\\Users\\godsa\\Desktop\\Pers.data\\Amir-Hany-Nassef-CV.pdf"; // Replace with your file path

    try {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();

    } catch (FileNotFoundException e) {
        System.out.println("File missing");
    } catch (IOException e) {
        System.out.println("Other I/O error");
    }

}
