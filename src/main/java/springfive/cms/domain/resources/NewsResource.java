package springfive.cms.domain.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfive.cms.domain.models.News;
import springfive.cms.domain.models.User;
import springfive.cms.domain.vo.CategoryRequest;
import springfive.cms.domain.vo.NewsRequest;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsResource {
    @GetMapping(value = "/{id}")
    public ResponseEntity<News> findOne(@PathVariable("id") String id){
        return ResponseEntity.ok( new News());
    }
    @GetMapping
    public ResponseEntity<List<News>> findAll(){
        return ResponseEntity.ok(Arrays.asList(new News(), new News()));
    }
    @PostMapping
    public ResponseEntity<News> newNews(NewsResource news){
        return new ResponseEntity<>( new News(), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeNews (@PathVariable("id") String id){

    }
    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews( @PathVariable("id") String id, NewsRequest news){
        return new ResponseEntity<>(new News(), HttpStatus.OK);
    }
}
