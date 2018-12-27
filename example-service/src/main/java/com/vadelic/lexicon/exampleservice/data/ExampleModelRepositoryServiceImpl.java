package com.vadelic.lexicon.exampleservice.data;

import com.vadelic.lexicon.exampleservice.model.ExampleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by GreenNun on 29/10/2018.
 */
@Repository
public class ExampleModelRepositoryServiceImpl implements ExampleModelRepositoryService {
    private final ExampleModelRepository exampleModelRepository;

    @Autowired
    public ExampleModelRepositoryServiceImpl(ExampleModelRepository exampleModelRepository) {
        this.exampleModelRepository = exampleModelRepository;
    }

    @Override
    public ExampleModel findOne(Long id) {
        return exampleModelRepository.getOne(id);
    }
}
