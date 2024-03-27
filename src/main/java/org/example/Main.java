package org.example;

import java.io.EOFException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import com.google.gson.Gson;
import java.util.Arrays;
import java.util.Base64;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) throws IOException {
        base64();
        average();
    }

    private static void average() throws EOFException {
        Gson gson = new Gson();
        try (FileReader fileReader = new FileReader("students.json")) {
            Student[] students = gson.fromJson(fileReader, Student[].class);
            for (Student student : students) {
                System.out.println(student);
            }

            OptionalDouble average = Arrays.stream(students).map(Student::getAge).mapToInt(Integer::intValue).average();
            if (average.isPresent()){
                System.out.println(average.getAsDouble());
            }

        } catch (Exception e) {
            throw new EOFException(e.getMessage());
        }
    }

    private static void base64() throws IOException {
        Base64.Encoder mimeEncoder = Base64.getMimeEncoder();
        Path path = Path.of("file.txt");
        String s = Files.readString(path);
        byte[] encode = mimeEncoder.encode(s.getBytes());
        Path path1 = Path.of("encodeData.txt");
        Path write = Files.write(path1, encode);
        System.out.println(write);
    }
}