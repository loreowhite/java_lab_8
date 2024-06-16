package com.example.task82.modules.directoryModules;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Objects;

@Component
public class DirectoryFileSizeCountModule extends DirectoryModule{
    @Override
    public String getDescription() {
        return "Calculating size directory file list";
    }

    @Override
    public void action(String path) {
        try {
            File directory = new File(path);
            long size = 0L;
            for (File file : Objects.requireNonNull(directory.listFiles())) {
                size += file.length();
            }
            System.out.println("Size of all files in the directory: " + size + " bytes");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
