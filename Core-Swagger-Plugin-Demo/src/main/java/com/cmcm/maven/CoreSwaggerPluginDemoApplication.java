package com.cmcm.maven;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication
public class CoreSwaggerPluginDemoApplication {

    private static final String BASE_PACKAGE = "com.cmcm";
    private static final String CLASS_PATH = "D:\\WorkSpace\\IdeaProjects\\Customized-Maven-Swagger-Plugin\\Core-Swagger-Plugin-Demo/target/classes";

    public static void main(String[] args) {
//		SpringApplication.run(CoreSwaggerPluginDemoApplication.class, args);
        List<Class<?>> classes = new ArrayList<>();
        scannerClass(classes, new File(CLASS_PATH));
    }

    private static void scannerClass(List<Class<?>> classes, File dir) {
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                scannerClass(classes, file);
            } else {
                if (!file.getName().endsWith(".class")) {
                    continue;
                }
                String className = file.getPath().replaceAll("\\\\", "/")
                        .replaceAll(CLASS_PATH.replaceAll("\\\\", "/"), "")
                        .replaceAll("/", ".")
                        .replaceAll("\\.class", "");
                className = className.substring(1);
                if (className.startsWith(BASE_PACKAGE)) {
                    try {
                        classes.add(Class.forName(className));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
//                        this.getLog().error("反射出现了异常{}", e.getCause());
                        continue;
                    }
                }
                System.out.println(className);
            }
        }
    }
}
