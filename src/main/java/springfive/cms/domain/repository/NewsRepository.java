package springfive.cms.domain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import springfive.cms.domain.models.News;

public interface NewsRepository extends ReactiveMongoRepository<News, String> {
}
