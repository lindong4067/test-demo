package com.example.testframe.ioc.messagesource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class I18nServiceConfig {

    @Bean
    public I18nService i18nService() {
        return new I18nService(messageSource());
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        Locale.setDefault(Locale.CHINESE);
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        /*
          basenames = i18n/messages
          即配置文件所在的目录为 i18n，文件前缀为 messages
          messages.properties
            message.key.test=测试!
            message.key.hello=你好！{0}~
          messages_en.properties
            message.key.test=test!
            message.key.hello=hello！{0}~
         */
        source.setBasenames("i18n/messages");
        source.setUseCodeAsDefaultMessage(true);
        source.setDefaultEncoding("UTF-8");
        return source;
    }
}
