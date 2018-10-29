package com.vadelic.lexicon.exampleservice.data;

import com.vadelic.lexicon.exampleservice.model.ExampleModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by GreenNun on 29/10/2018.
 */
public interface ExampleModelRepository extends JpaRepository<ExampleModel, Long> {
}
