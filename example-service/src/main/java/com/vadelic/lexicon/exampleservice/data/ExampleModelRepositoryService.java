package com.vadelic.lexicon.exampleservice.data;

import com.vadelic.lexicon.exampleservice.model.ExampleModel;

/**
 * Created by GreenNun on 29/10/2018.
 */
public interface ExampleModelRepositoryService {

    ExampleModel findOne(Long id);
}
