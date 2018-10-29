package com.vadelic.lexicon.exampleservice.service;

import com.vadelic.lexicon.exampleservice.data.ExampleModelRepositoryService;
import com.vadelic.lexicon.exampleservice.model.ExampleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by GreenNun on 29/10/2018.
 */
@RestController
public class ExampleRestService {
    private final ExampleModelRepositoryService exampleModelRepositoryService;

    @Autowired
    public ExampleRestService(ExampleModelRepositoryService exampleModelRepositoryService) {
        this.exampleModelRepositoryService = exampleModelRepositoryService;
    }

    @GetMapping("/example-model")
    public ExampleModel getModel(@RequestParam Long id) {
        return exampleModelRepositoryService.findOne(id);
    }

    @GetMapping("/test")
    public Long test(@RequestParam Long id) {
        return id;
    }
}
