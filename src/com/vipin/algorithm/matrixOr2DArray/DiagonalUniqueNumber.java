package com.vipin.algorithm.matrixOr2DArray;

import java.util.HashSet;

public class DiagonalUniqueNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{6, 28, 37, 34,12,30, 43,35,6},
						{21,47, 38, 14,31,49, 11,14,49},
						{6, 12, 35, 17,17,2,  45,27,43},
						{34,41, 30, 28,45,24, 50,20,4}};
		System.out.println(differenceOfDistinctValues(grid));
	}
	
	public static int[][] differenceOfDistinctValues(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int ans[][] = new int[N][M];
        for(int j=N-1; j>-1; j--) {
            int n = j;
            int[]input = new int[51];
            int m = 0;
            int count = 0;
            while(n<N && m<M) {
                //map.put(grid[n][m], map.getOrDefault(grid[n][m], 0) + 1);
                input[grid[n][m]]++;
                n++;
                m++;
            }
            for(int i=0; i<51; i++) {
                if(input[i]!=0) {
                    count++; 
                }
            }
            HashSet<Integer> set = new HashSet<>();
            n = j;
            m = 0;
            while(n<N && m<M) {
                if(input[grid[n][m]]==1) {
                    ans[n][m] = Math.abs(--count - set.size());
                }
                else {
                    ans[n][m] = Math.abs(count - set.size());
                    input[grid[n][m]]--;
                    
                }
                set.add(grid[n][m]);
                n++;
                m++;
            }
        }
        for(int i=1; i<M; i++) {
            int n = 0;
            int[]input = new int[51];
            int m = i;
            int count = 0;
            while(n<N && m<M) {
                //map.put(grid[n][m], map.getOrDefault(grid[n][m], 0) + 1);
                input[grid[n][m]]++;
                n++;
                m++;
            }
            for(int j=0; j<51; j++) {
                if(input[j]!=0) {
                    count++; 
                }
            }
            n = 0;
            m = i;
            HashSet<Integer> set = new HashSet<>();
            while(n<N && m<M) {
                if(input[grid[n][m]]==1) {
                    ans[n][m] = Math.abs(--count - set.size());
                }
                else {
                    ans[n][m] = Math.abs(count - set.size());
                    input[grid[n][m]]--;
                    
                }
                set.add(grid[n][m]);
                n++;
                m++;
            }
        }
        return ans;
    }

}



import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVReaderExample {
    public static void main(String[] args) {
        String csvFilePath = "path/to/your/csv/file.csv";
        int batchSize = 1000; // Set the batch size as per your needs

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] headers = reader.readNext(); // Skip headers if needed

            List<String[]> batch;
            int recordCount = 0;
            while ((batch = reader.readAll(batchSize)).size() > 0) {
                // Process the batch of records
                for (String[] record : batch) {
                    // Access individual fields of the record
                    String field1 = record[0];
                    String field2 = record[1];
                    // ... access other fields as needed

                    // Process the record
                    System.out.println("Field 1: " + field1);
                    System.out.println("Field 2: " + field2);
                    // ... process other fields as needed

                    recordCount++;
                }

                System.out.println("Processed " + recordCount + " records.");
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CSVReaderExample {
    public static void main(String[] args) {
        String csvFilePath = "path/to/your/csv/file.csv";
        int batchSize = 1000; // Set the batch size as per your needs
        int numThreads = 4; // Set the number of threads for parallel processing

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] headers = reader.readNext(); // Skip headers if needed

            ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
            List<Callable<Integer>> tasks = new ArrayList<>();

            int recordCount = 0;
            List<String[]> batch;
            while ((batch = reader.readAll(batchSize)).size() > 0) {
                final List<String[]> currentBatch = new ArrayList<>(batch);

                Callable<Integer> task = () -> {
                    int count = 0;
                    for (String[] record : currentBatch) {
                        // Access individual fields of the record
                        String field1 = record[0];
                        String field2 = record[1];
                        // ... access other fields as needed

                        // Process the record
                        System.out.println("Field 1: " + field1);
                        System.out.println("Field 2: " + field2);
                        // ... process other fields as needed

                        count++;
                    }
                    return count;
                };

                tasks.add(task);
            }

            List<Future<Integer>> results = executorService.invokeAll(tasks);
            for (Future<Integer> result : results) {
                recordCount += result.get();
            }

            executorService.shutdown();

            System.out.println("Processed " + recordCount + " records.");
        } catch (IOException | CsvException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    
    import com.opencsv.CSVReader;
    import com.opencsv.exceptions.CsvException;

    import java.io.FileReader;
    import java.io.IOException;
    import java.util.List;
    import java.util.stream.Stream;

    public class CSVReaderExample {
        public static void main(String[] args) {
            String csvFilePath = "path/to/your/csv/file.csv";
            int batchSize = 1000; // Set the batch size as per your needs

            try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
                String[] headers = reader.readNext(); // Skip headers if needed

                Stream<List<String[]>> batches = Stream.iterate(readBatch(reader, batchSize), batch -> readBatch(reader, batchSize))
                        .takeWhile(batch -> !batch.isEmpty());

                batches.flatMap(List::stream)
                        .forEach(record -> {
                            // Access individual fields of the record
                            String field1 = record[0];
                            String field2 = record[1];
                            // ... access other fields as needed

                            // Process the record
                            System.out.println("Field 1: " + field1);
                            System.out.println("Field 2: " + field2);
                            // ... process other fields as needed
                        });

            } catch (IOException | CsvException e) {
                e.printStackTrace();
            }
        }

        private static List<String[]> readBatch(CSVReader reader, int batchSize) {
            try {
                return reader.readAll(Math.min(batchSize, Integer.MAX_VALUE));
            } catch (IOException | CsvException e) {
                e.printStackTrace();
                return List.of();
            }
        }
    }
    
    import java.io.BufferedWriter;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.List;

    public class LargeTextFileWriterExample {
        public static void main(String[] args) {
            String filePath = "path/to/your/text/file.txt";
            int batchSize = 1000; // Set the batch size as per your needs

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                // Generate large records (example)
                List<String> largeRecords = generateLargeRecords();

                int recordCount = 0;
                StringBuilder batchBuilder = new StringBuilder();

                for (String record : largeRecords) {
                    batchBuilder.append(record).append(System.lineSeparator());
                    recordCount++;

                    if (recordCount % batchSize == 0) {
                        writer.write(batchBuilder.toString());
                        batchBuilder.setLength(0); // Reset the StringBuilder

                        System.out.println("Processed " + recordCount + " records.");
                    }
                }

                // Write any remaining records in the batch
                if (batchBuilder.length() > 0) {
                    writer.write(batchBuilder.toString());
                    System.out.println("Processed " + recordCount + " records.");
                }

                System.out.println("Records written to the file successfully.");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static List<String> generateLargeRecords() {
            // Example method to generate large records
            // Replace with your own logic to generate or fetch the records
            // Return a list of records to be written to the file
            return List.of(
                    "Record 1",
                    "Record 2",
                    // ... add more records as needed
            );
        }
    }
    
    import com.opencsv.CSVReader;
    import com.opencsv.exceptions.CsvException;

    import java.io.FileReader;
    import java.io.IOException;

    public class CSVReaderExample {
        public static void main(String[] args) {
            String csvFilePath = "path/to/your/csv/file.csv";
            int batchSize = 1000; // Set the batch size as per your needs

            try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
                String[] headers = reader.readNext(); // Skip headers if needed

                String[] record;
                int recordCount = 0;
                int batchCount = 0;

                while ((record = reader.readNext()) != null) {
                    // Access individual fields of the record
                    String field1 = record[0];
                    String field2 = record[1];
                    // ... access other fields as needed

                    // Process the record
                    System.out.println("Field 1: " + field1);
                    System.out.println("Field 2: " + field2);
                    // ... process other fields as needed

                    recordCount++;

                    // Check if the batch size limit is reached
                    if (recordCount % batchSize == 0) {
                        batchCount++;
                        System.out.println("Processed " + batchCount + " batches.");
                    }
                }

                System.out.println("Processed " + recordCount + " records.");
            } catch (IOException | CsvException e) {
                e.printStackTrace();
            }
        }
    }



}


