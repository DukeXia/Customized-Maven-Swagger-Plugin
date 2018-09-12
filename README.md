# Customized-Maven-Swagger-Plugin
通过自己开发一个类似Swagger的插件来掌握Maven插件开发

### Maven的运行机制
> 1.编译,对应maven-compiler-plugin插件  
2.测试,对应maven-surefire-plugin插件    
3.打包,对应maven-jar/war/source-plugin插件    
4.部署,对应maven-deploy-plugin插件

### Maven插件的工作机制
> 1.所有Maven插件类都通过继承org.apache.maven.plugin.AbstractMojo类,实现execute方法    
2.通过pom.xml配置文件传参,实现相应的逻辑   
3.用户输入mvn命令时获取参数,并执行相应的逻辑

### 编写Maven插件需要注意的两个地方
> 1.必须引入以下两个jar包,这两个包是Apache提供用来开发maven插件的包
```
<dependency>
    <groupId>org.apache.maven</groupId>
    <artifactId>maven-plugin-api</artifactId>
    <version>3.3.9</version>
</dependency>
<dependency>
    <groupId>org.apache.maven</groupId>
    <artifactId>maven-model</artifactId>
    <version>3.3.9</version>
</dependency>
```
> 2.需要在maven工程中指定pom.xml文件的package格式为maven-plugin   
3.需要在插件项目中使用一个把项目打包成maven插件项目的插件
```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-plugin-plugin</artifactId>
    <version>2.5.1</version>
    <configuration>
        <goalPrefix>doc</goalPrefix>
    </configuration>
    <executions>
        <execution>
            <id>generated-helpmojo</id>
            <goals>
                <goal>helpmojo</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```