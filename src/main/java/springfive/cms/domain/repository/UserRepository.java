package springfive.cms.domain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Service;
import springfive.cms.domain.models.User;

@Service
public interface UserRepository extends ReactiveMongoRepository<User, String> {

}
