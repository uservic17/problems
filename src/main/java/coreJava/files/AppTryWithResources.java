package coreJava.files;


public class AppTryWithResources {
    public static void main(String[] args) {
        try (Temp temp = new Temp()) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Temp implements AutoCloseable {

        @Override
        public void close() throws Exception {
            System.out.println("Closing temp instance...");
        }
    }
}
