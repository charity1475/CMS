package springfive.cms.domain.services;

import org.springframework.stereotype.Service;
import springfive.cms.domain.repository.NewsRepository;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }
}
