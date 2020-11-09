package springfive.cms.domain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Service;
import springfive.cms.domain.models.Category;

@Service
public interface CategoryRepository extends ReactiveMongoRepository<Category,String> {
}
