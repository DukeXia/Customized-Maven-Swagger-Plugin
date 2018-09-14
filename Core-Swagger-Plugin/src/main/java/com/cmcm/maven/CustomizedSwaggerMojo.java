package com.cmcm.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Spontaneously
 * @goal generate-doc
 * @phase compile
 */
public class CustomizedSwaggerMojo extends AbstractMojo {

    /**
     * @parameter expression="${classPath}"
     */
    private String classPath;

    /**
     * @parameter expression="${libDir}"
     */
    private String libDir;

    /**
     * @parameter expression="${basePackage}"
     */
    private String basePackage;

    /**
     * @parameter expression="${targetFile}"
     */
    private String targetFile;

    /**
     * @parameter expression="${host}"
     */
    private String host;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        this.getLog().info("自定义的Swagger插件开始工作");

//        1.要接收到用户设置的参数列表
        this.getLog().info("classPath = " + this.classPath);
        this.getLog().info("libDir = " + this.libDir);
        this.getLog().info("basePackage = " + this.basePackage);
        this.getLog().info("targetFile = " + this.targetFile);
        this.getLog().info("host = " + this.host);
//        2.从class路径下扫描所有符合条件的类
        List<Class<?>> classes = new ArrayList<>();
        scannerClass(classes, new File(this.classPath));
        if (classes.isEmpty()) {
            this.getLog().info("没有扫描到任何类");
        } else {
            this.getLog().info("扫描到" + classes.size() + "个类");
        }
//        3.分析写在代码中的注解，通过分析提取到关键信息
        try {
//            String basePath = (new URL("file", null, new File(this.classPath).getCanonicalFile()) + File.separator).toString();
            String basePath = new File(this.classPath).getCanonicalFile() + File.separator;
            this.getLog().info("地址是: " + basePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        4.根据预定义好的模板文件生成新的HTML文件,并且要保存到指定的目录中
//        5.自动化后,只需要告诉调用者一个固定的URL即可
    }

    /**
     * 扫描basePackage包下面的文件，找到所有的类
     *
     * @param classes 存放找到的类
     * @param dir     表示扫描的路径
     */
    private void scannerClass(List<Class<?>> classes, File dir) {
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
                        .replaceAll(classPath.replaceAll("\\\\", "/"), "")
                        .replaceAll("/", ".")
                        .replaceAll("\\.class", "");
                className = className.substring(1);
                this.getLog().info("扫描到的class的名字是：" + className);
                if (className.startsWith(this.basePackage)) {
                    try {
                        classes.add(Class.forName(className));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                        this.getLog().error("反射出现了异常{}", e.getCause());
                        continue;
                    }
                }
                System.out.println(className);
            }
        }
    }

}
