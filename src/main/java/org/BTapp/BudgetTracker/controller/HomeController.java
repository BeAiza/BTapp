package org.BTapp.BudgetTracker.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.file.Files;

@Controller
public class HomeController {

    @RequestMapping(value = "/{path:[^\\.]*}")
    public String redirect() {
        return "forward:/";
    }

    @RequestMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getIndexFile() throws IOException {
        Resource resource = new ClassPathResource("static/index.html");
        return new String(Files.readAllBytes(resource.getFile().toPath()));
    }
}
