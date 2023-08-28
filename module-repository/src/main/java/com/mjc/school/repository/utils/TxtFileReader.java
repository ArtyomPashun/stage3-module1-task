package com.mjc.school.repository.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TxtFileReader {

    public List<String> read (String filePath) {
        List<String> content = new ArrayList<>();
        try (InputStream stream = this.getClass().getResourceAsStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            while (reader.ready()) {
                content.add(reader.readLine());
            }
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException(e + "There is no such resource with path: " + filePath);
        }
        return content;
    }
}
