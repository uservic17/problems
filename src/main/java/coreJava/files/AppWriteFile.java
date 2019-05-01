package coreJava.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppWriteFile {
    public static void main(String[] args) {
        File file = new File("hello.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("First line");
            bw.newLine();
            bw.write("Second line");
            bw.newLine();
            bw.write("Third line");
        } catch (IOException e) {
            System.out.println("Cannot write file...");
        }
    }
}
