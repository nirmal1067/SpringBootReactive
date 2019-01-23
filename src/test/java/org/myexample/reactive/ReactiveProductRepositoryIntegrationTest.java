
package org.myexample.reactive;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.myexample.reactive.domain.Product;
import org.myexample.reactive.repositories.ReactiveProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.test.context.junit4.SpringRunner;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReactiveProductRepositoryIntegrationTest {

    @Autowired
    ReactiveProductRepository repository;
    @Autowired
    ReactiveMongoOperations operations;

    @Before
    public void setUp() {
//        operations.collectionExists(Product.class)
//                .flatMap(exists -> exists ? operations.dropCollection(Product.class) : Mono.just(exists))
//                .flatMap(o -> operations.createCollection(Product.class, new CollectionOptions(1024 * 1024, 100, true)))
//                .then()
//                .block();

     Mono<Product> mono   = repository
                .save(new Product("T Shirt", "Spring Guru printed T Shirt", new BigDecimal(125), "tshirt1.png"));
     
     System.out.println("Test it " + mono.block().getName());
//        repository
//        .save(new Product("T Shirt", "Spring Guru plain T Shirt", new BigDecimal(115), "tshirt2.png"));
//        repository
//        .save(new Product("Mug", "Spring Guru printed Mug", new BigDecimal(39), "mug1.png"));
//        repository
//        .save( new Product("Cap", "Spring Guru printed Cap", new BigDecimal(66), "cap1.png"));

              //  .then()
               // .block();
    }

    @Test
    public void findByNameAndImageUrlWithStringQueryTest() {

        Product mug = repository.findByNameAndImageUrl("Mug", "mug1.png")
                .block();
        assertThat(mug).isNotNull();
    }

    @Test
    public void findByNameAndImageUrlWithMonoQueryTest() {
        Product cap = repository.findAll().blockLast();
               // .block();
        assertThat(cap).isNotNull();
    }

    @Test
    public void findByNameWithStringQueryTest() {
        List<Product> tShirts = repository.findByName("T Shirt")
                .collectList()
                .block();
        assertThat(tShirts).hasSize(2);
    }

    @Test
    public void findByNameWithMonoQueryTest() {
        List<Product> tShirts = repository.findByName(Mono.just("T Shirt"))
                .collectList()
                .block();
        assertThat(tShirts).hasSize(2);
    }


}
