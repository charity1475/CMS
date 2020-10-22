package springfive.cms.domain.vo;

import lombok.Data;
import springfive.cms.domain.models.Role;

@Data
public class UserRequest {
    String identity;
    String name;
    Role role;
}
