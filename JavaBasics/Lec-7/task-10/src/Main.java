
void main() {
    try{
        readFile();
    }catch (FileNotFoundException e){
        System.out.println("File not found");
    }catch(IOException e){
        System.out.println("Error reading file");
    }
}

void readFile() throws IOException {
    String filename = "C:\\Users\\godsa\\Desktop\\Pers.data\\Amir-Hany-Nassef-CV.pdf";
    String line ;

    BufferedReader reader = new BufferedReader(new FileReader(filename));

    while((line = reader.readLine()) != null){
        System.out.println(line);
    }
    reader.close();
}