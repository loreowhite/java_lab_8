package com.example.task82;

import com.example.task82.modules.Module;
import com.example.task82.service.ModuleService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication()
public class Application {
    private static final ApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);

    public static void main(String[] args) {
        System.out.println("Spring boot app started!");
//        args = new String[]{new Scanner(System.in).nextLine()};

        String path = args[0];
        List<Module> modules = ctx
                .getBean(ModuleService.class)
                .getSupportedModules(path);

        performAction(modules, path);
    }

    private static void performAction(List<Module> modules, String path) {
        while (true) {
            System.out.println();
            System.out.println("All available modules for '" + new File(path).getName() + "' :");
            for (int i = 0; i < modules.size(); i++) {
                System.out.println((i + 1) + ") " + modules.get(i).getClass().getSimpleName() + " - " + modules.get(i).getDescription());
            }

            System.out.println("Enter the module number for perform or '/q' for exit:");
            String choice = new Scanner(System.in).next();
            if (choice.equals("/q")) {
                break;
            }
            Module module = modules.get(Integer.parseInt(choice) - 1);
            module.action(path);
        }
    }

    public ApplicationContext getContext() {
        return ctx;
    }
}
