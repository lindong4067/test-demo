package com.example.testframe.ioc.messagesource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api")
public class HelloJavaCoderController {
    /*
      请求 http://localhost:8888/api/test 并
      在 header 中设置 Accept-Languate=zh  中国
      在 header 中设置 Accept-Languate=en  英国
     */
    private final I18nService i18nService;

    public HelloJavaCoderController(I18nService i18nService) {
        this.i18nService = i18nService;
    }

    @GetMapping("/hello-coder")
    public ResponseEntity greeting() {
        return ResponseEntity.ok(i18nService.getMessage("message.key.hello", new Object[]{"JavaCoder"}));
    }

    @GetMapping("/test")
    public ResponseEntity test() {
        return ResponseEntity.ok(i18nService.getMessage("message.key.test"));
    }
}
