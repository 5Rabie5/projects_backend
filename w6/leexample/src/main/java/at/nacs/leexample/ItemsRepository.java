package at.nacs.leexample;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ItemsRepository extends MongoRepository<Item, String> {

    Optional<Item> findByName();

    List<Item> findAllByName();

    List<Item> queryAllByName();

}
