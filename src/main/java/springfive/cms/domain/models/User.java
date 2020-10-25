package springfive.cms.domain.models;

import lombok.Data;

@Data
public class User {
    String id;
    String identity;
    String name;
    Role role;

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
