package com.example.testframe.ioc.postprocessor;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

public class PostProcessorTest {
    public static void main(String[] args) {
        //1.
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        MyBeanPostProcessor postProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(postProcessor);

        //2.
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new FileSystemResource("beans.xml"));

        // bring in some property values from a Properties file
        PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();
        cfg.setLocation(new FileSystemResource("jdbc.properties"));

        // now actually do the replacement
        cfg.postProcessBeanFactory(factory);

        //3.

    }
}
