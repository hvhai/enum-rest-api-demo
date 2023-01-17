package com.codehunter.enumrestapidemo.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Controller
@RequestMapping("/api/documents")
public class DocumentController {

    @GetMapping
    public ResponseEntity<Resource> downLoadDocument() throws FileNotFoundException {

        var file = ResourceUtils.getFile("classpath:document/data.pdf");
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=data.pdf")
                .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.CONTENT_DISPOSITION)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
