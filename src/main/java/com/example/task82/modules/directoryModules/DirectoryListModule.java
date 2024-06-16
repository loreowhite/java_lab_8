package com.example.task82.modules.directoryModules;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Objects;

@Component
public class DirectoryListModule extends DirectoryModule {
    @Override
    public String getDescription() {
        return "Show directory files";
    }

    @Override
    public void action(String path) {
        try {
            File directory = new File(path);
            System.out.println("Directory file list:");
            for (File file : Objects.requireNonNull(directory.listFiles())) {
                System.out.println("\t- " + file.getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
