package springfive.cms.domain.services;

import org.springframework.stereotype.Service;
import springfive.cms.domain.models.News;
import springfive.cms.domain.repository.NewsRepository;
import springfive.cms.domain.vo.NewsRequest;

import java.util.UUID;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public Object findOne(String id) {
        return this.newsRepository.findById(id);
    }

    public Object findAll() {
        return this.newsRepository.findAll();
    }

    public Object create(NewsRequest newsRequest) {
        News user = new News();
        user.setId(UUID.randomUUID().toString());
        user.setTitle(newsRequest.getTitle());
        user.setContent(newsRequest.getContent());
        return this.newsRepository.save(user);
    }

    public void delete(String id) {
        this.newsRepository.deleteById(id);
    }

    public Object update(String id, NewsRequest newsRequest) {
        return this.newsRepository.findById(id).flatMap(user -> {
            user.setTitle(newsRequest.getTitle());
            user.setContent(newsRequest.getContent());
            user.setCategories(newsRequest.getCategories());
            return this.newsRepository.save(user);
        });
    }
}
