package com.example.task82.modules.imageModules;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

@Component
public class ImageSizeModule extends ImageModule {
    @Override
    public String getDescription() {
        return "Counting image size";
    }

    @Override
    public void action(String path) {
        try {
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            System.out.println("Size image '" + file.getName() + "' height: " + image.getHeight() + " width: " + image.getWidth());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
