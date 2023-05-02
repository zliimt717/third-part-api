package com.javapractices.controller;

import com.javapractices.service.ExternalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RequestMapping("/search")
@RestController
public class ExternalRestController {
    private ExternalService externalService;

    public ExternalRestController(ExternalService externalService) {
        this.externalService = externalService;
    }
    @GetMapping("/{name}")
    public ResponseEntity<String> searchResult(@PathVariable("name") String name) throws URISyntaxException, IOException {
        String result=externalService.searchResult(name);
        return ResponseEntity.ok(result);
    }

}
