package com.cmcm.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * @author Spontaneously
 * @time 2018-09-11 下午4:27
 */
public class CustomizedSwaggerMojo extends AbstractMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("指定了自己指定的Mojo");
    }

}
