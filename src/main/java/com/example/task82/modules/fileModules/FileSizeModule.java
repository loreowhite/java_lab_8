package com.example.task82.modules.fileModules;

import com.example.task82.modules.Module;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileSizeModule implements Module {
    @Override
    public boolean isSupportedType(String path) {
        return path != null && new File(path).isFile();
    }

    @Override
    public String getDescription() {
        return "Counting file size";
    }

    @Override
    public void action(String path) {
        try {
            File file = new File(path);
            System.out.println(file.getName() + " file size: " + file.length() + " bytes");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
