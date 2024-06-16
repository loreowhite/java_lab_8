package com.example.task82.modules.textModules;

import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class TextRowCountModules extends TextModule {
    @Override
    public String getDescription() {
        return "Counting lines in a txt file";
    }

    @Override
    public void action(String path) {
        try {
            File file = new File(path);
            var lines = Files.readAllLines(Path.of(path));
            System.out.println("In file " + file.getName() + ", " + lines.size() + " rows");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
