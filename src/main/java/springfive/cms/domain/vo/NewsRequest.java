package springfive.cms.domain.vo;

import lombok.Data;
import springfive.cms.domain.models.Category;
import springfive.cms.domain.models.Tag;

import java.util.Set;

@Data
public class NewsRequest {
    String title;
    String content;
    Set<Category> categories;
    Set<Tag> tags;
}
