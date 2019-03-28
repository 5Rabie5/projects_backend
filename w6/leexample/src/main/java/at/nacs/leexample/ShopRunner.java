package at.nacs.leexample;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ShopRunner {

    @Bean
    ApplicationRunner run(List<Item> items, ItemsRepository repository){
        return args -> {
            System.out.println("----save all---");
            repository.saveAll(items);

            System.out.println("----show all---");
            List<Item> all= repository.findAll();

            System.out.println("----quiery ---");


            all.forEach(e -> System.out.println(e));
        };
    }
}
