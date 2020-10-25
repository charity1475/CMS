package springfive.cms.domain.vo;

import lombok.Data;
import springfive.cms.domain.models.Role;

@Data
public class UserRequest {
    String identity;
    String name;
    Role role;

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public String getIdentity() {
        return identity;
    }
}
