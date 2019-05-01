package coreJava.files;

import java.io.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        File file = new File("test.tkxt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader(file);
             br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Some problem apparently..");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
