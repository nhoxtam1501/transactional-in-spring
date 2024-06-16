package dev.ducku.main;

import dev.ducku.main.config.ProjectConfig;
import dev.ducku.main.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Main {
    public static void main(String[] args) {

        try (GenericApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            ProductService productService = context.getBean("productService", ProductService.class);
            productService.save();

            context.registerShutdownHook();
        }
    }
}
