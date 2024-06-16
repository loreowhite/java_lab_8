package com.example.task82.modules.textModules;

import com.example.task82.modules.Module;

public abstract class TextModule implements Module {
    @Override
    public boolean isSupportedType(String path) {
        return path != null && path.endsWith(".txt");
    }
}
