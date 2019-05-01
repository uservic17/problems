package coreJava.files;


import java.io.*;

public class AppTryWithResourcesForFile {
    public static void main(String[] args) {
        File file = new File("test.txt");
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Unable to read file");
        }
    }

}
