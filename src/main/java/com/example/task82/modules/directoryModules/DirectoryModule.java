package com.example.task82.modules.directoryModules;

import com.example.task82.modules.Module;

import java.io.File;

public abstract class DirectoryModule implements Module {
    @Override
    public boolean isSupportedType(String path) {
        return path != null && new File(path).isDirectory();
    }
}
