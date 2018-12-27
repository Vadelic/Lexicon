package com.vadelic.lexicon.exampleservice.repository;

import com.vadelic.lexicon.exampleservice.data.ExampleModelRepository;
import com.vadelic.lexicon.exampleservice.model.ExampleModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by GreenNun on 29/10/2018.
 */
@SpringBootTest
@ActiveProfiles(profiles = {"junit"})
@RunWith(SpringRunner.class)
@DataJpaTest
//@ContextConfiguration(classes = ExampleModelRepositoryServiceImplTest.Config.class)
public class ExampleModelRepositoryServiceImplTest {
    //    @Autowired
//    private AnyBean anyBean;
    @Autowired
    ExampleModelRepository exampleModelRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findOne() {
        final Long id = entityManager.persist(new ExampleModel("test")).getId();

        final ExampleModel model = exampleModelRepository.getOne(id);
        assertNotNull("id", model.getId());
    }

//    @TestConfiguration
//    public static class Config {
//        @Autowired
//        ExampleModelRepository exampleModelRepository;
//
//        @Bean
//        public AnyBean getAnyBean() {
//            return new AnyBean();
//        }
//    }
}