package com.example.task82.service;

import com.example.task82.Application;
import com.example.task82.modules.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModuleService {
    private final Application app;

    @Autowired
    public ModuleService(Application app) {
        this.app = app;
    }

    public List<Module> getSupportedModules(String path) {
        ApplicationContext ctx = app.getContext();
        List<Module> result = new ArrayList<>();
        for (String name : ctx.getBeanDefinitionNames()) {
            var bean = ctx.getBean(name);
            Module module;
            try {
                module = (Module) bean;
            } catch (Exception e) {
                continue;
            }

            if (module.isSupportedType(path)) {
                result.add(module);
            }
        }

        return result;
    }
}
