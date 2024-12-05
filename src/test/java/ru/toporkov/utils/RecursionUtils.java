package ru.toporkov.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class RecursionUtils {

    public static Path createTempDirectory() {
        try {
            return Files.createTempDirectory(
                    Path.of("C:\\Users\\admin\\Desktop\\Learning\\java\\high_school\\algo_base"),
                    "test1"
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Path createTempDirectoryWithSingleFile() {
        try {
            Path test1 = Files.createTempDirectory(
                    Path.of("C:\\Users\\admin\\Desktop\\Learning\\java\\high_school\\algo_base"),
                    "test1"
            );

            Path test2 = Files.createTempDirectory(test1, "test2");

            Path filePath = test2.resolve("test1.txt");
            Files.createFile(filePath);

            return test1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Path createTempDirectoryWithTwoFiles() {
        try {
            Path test1 = Files.createTempDirectory(
                    Path.of("C:\\Users\\admin\\Desktop\\Learning\\java\\high_school\\algo_base"),
                    "test1"
            );

            Path test2 = Files.createTempDirectory(test1, "test2");

            Path filePath = test2.resolve("test1.txt");
            Files.createFile(filePath);

            Path test3 = Files.createTempDirectory(test1, "test2");

            Path filePath2 = test3.resolve("test1.txt");
            Path filePath3 = test3.resolve("test2.txt");
            Files.createFile(filePath2);
            Files.createFile(filePath3);

            return test1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteDirectory(Path directory) {

        if (Files.isDirectory(directory)) {
            try (Stream<Path> files = Files.list(directory)) {
                files.forEach(RecursionUtils::deleteDirectory);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Files.delete(directory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
