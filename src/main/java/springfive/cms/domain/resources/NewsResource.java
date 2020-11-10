package springfive.cms.domain.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import springfive.cms.domain.models.News;
import springfive.cms.domain.models.Review;
import springfive.cms.domain.services.NewsService;
import springfive.cms.domain.vo.NewsRequest;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsResource {

    private final NewsService newsService;

    public NewsResource(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id){
        return ResponseEntity.ok(this.newsService.findOne(id));
    }
    @GetMapping
    public ResponseEntity<Object> findAll(){
        return ResponseEntity.ok(this.newsService.findAll());
    }
    @PostMapping
    public ResponseEntity<News> newNews(NewsRequest news){
        return new ResponseEntity<>((MultiValueMap<String, String>) this.newsService.create(news),
                HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeNews (@PathVariable("id") String id){
        this.newsService.delete(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews( @PathVariable("id") String id, NewsRequest news){
        return new
                ResponseEntity<>((MultiValueMap<String, String>) this.newsService.update(id,news),
                HttpStatus.OK);
    }
    @GetMapping(value = "/{id}/review/{userId}")
    public ResponseEntity<Review> review(@PathVariable("id") String id, @PathVariable("userId") String userId){
        return ResponseEntity.ok(new Review());
    }
    @GetMapping(value = "/revised")
    public ResponseEntity<List<News>> revisedNews(){
        return ResponseEntity.ok(Arrays.asList(new News()));
    }
}
