package com.example.task82.modules.imageModules;

import com.example.task82.modules.Module;

public abstract class ImageModule implements Module {
    @Override
    public boolean isSupportedType(String path) {
        return path != null && (path.endsWith(".png") || path.endsWith(".jpeg") || path.endsWith(".jpg"));
    }
}
