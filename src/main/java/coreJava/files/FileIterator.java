package coreJava.files;

import java.io.*;
import java.util.Iterator;

public class FileIterator implements Iterator<String> {

    private BufferedReader br;
    private String line;

    public FileIterator(File file) {
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("File Not found: " + file.toString());
        }
    }

    @Override
    public boolean hasNext() {
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (line == null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return true;
        }
        return false;
    }

    @Override
    public String next() {
        return line;
    }

    public static void main(String[] args) {
        FileIterator fileIterator = new FileIterator(new File("test.txt"));
        while(fileIterator.hasNext()) {
            System.out.println(fileIterator.next());
        }
    }
}
