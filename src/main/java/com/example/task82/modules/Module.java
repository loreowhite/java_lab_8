package com.example.task82.modules;

public interface Module {
    boolean isSupportedType(String path);

    String getDescription();

    void action(String path);
}
