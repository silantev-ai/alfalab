import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task3 {

//    private final static String RESULT_FILENAME = "result.txt";

    public static void main(String[] args) {

        Random r = new Random();
        Collection<List<Integer>> source = IntStream.rangeClosed(1, 1000000)
                .boxed()
                .collect(Collectors.partitioningBy(n -> r.nextBoolean()))
                .values();

//        initFile(RESULT_FILENAME);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (List<Integer> numbers : source) {
            executorService.execute(new NumberWriter(numbers));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void initFile(String filename) {

        File threadFile = new File(filename);
        threadFile.delete();
        try {
            threadFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class NumberWriter implements Runnable {

        private final List<Integer> numbers;

        public NumberWriter(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public void run() {

            try {
                processNumbers();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private void processNumbers() throws IOException {

            initFile(getFilename());

            FileWriter fw = new FileWriter(getFilename());
            for (Integer number : numbers) {
                fw.write(String.format("%d ", number));
            }
            fw.close();
        }

        private String getFilename() {
            return Thread.currentThread().getName() + ".txt";
        }
    }
}
