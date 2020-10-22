package springfive.cms.domain.models;

import java.util.Set;
import lombok.Data;

@Data
public class News {
    String id;
    String title;
    String content;
    User author;
    Set<User> mandatoryReviewers;
    Set<Review> reviewers;
    Set<Category> categories;
    Set<Tag> tags;
}
