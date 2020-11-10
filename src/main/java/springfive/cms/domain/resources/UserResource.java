package springfive.cms.domain.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfive.cms.domain.models.Category;
import springfive.cms.domain.models.User;
import springfive.cms.domain.services.UserService;
import springfive.cms.domain.vo.CategoryRequest;
import springfive.cms.domain.vo.UserRequest;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Mono<User>> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.userService.findOne(id));
    }

    @GetMapping
    public ResponseEntity<Flux<User>> findAll() {
        return ResponseEntity.ok(this.userService.findAll());
    }

    @PostMapping
    public ResponseEntity<Mono<User>> newUser(UserRequest userRequest) {
        return new ResponseEntity<>(this.userService.create(userRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUser(@PathVariable("id") String id) {
        this.userService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<User>> updateUser(@PathVariable("id") String id,
                                                 UserRequest userRequest) {
        return new ResponseEntity<>(this.userService.update(id, userRequest), HttpStatus.OK);
    }
}
