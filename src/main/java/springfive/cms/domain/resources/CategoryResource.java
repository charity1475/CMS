package springfive.cms.domain.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfive.cms.domain.models.Category;
import springfive.cms.domain.services.CategoryService;
import springfive.cms.domain.vo.CategoryRequest;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/category")
@Api(tags = "category")
public class CategoryResource {

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping( value = "/{id}")
    @ApiOperation(value = "Find category", notes = "Find the category by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Category found"),
            @ApiResponse(code = 404, message = "Category not found"),
    })
    public ResponseEntity<Mono<Category>> findOne(@PathVariable("id") String id){
        return ResponseEntity.ok(this.categoryService.findOne(id));
    }

    @GetMapping
    @ApiOperation(value = "List categories", notes = "List all categories")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Categories found"),
            @ApiResponse(code = 404, message = "Category not found"),
    })
    public ResponseEntity<Flux<Category>> findAll(){
        return ResponseEntity.ok(this.categoryService.findAll());
    }

    @PostMapping
    @ApiOperation(value = "Create category", notes = "It permits to create a new category")
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = "Category created successfully"),
            @ApiResponse(code = 400, message = "Invalid request"),
    })
    public ResponseEntity<Mono<Category>> newCategory(@RequestBody CategoryRequest category){
        return new ResponseEntity<>(this.categoryService.create(category),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Remove category", notes = "It permits to remove a category")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Category removed successfully"),
            @ApiResponse(code = 404, message = "Category not found"),
    })
    public void removeCategory (@PathVariable("id") String id){
        this.categoryService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Update category", notes = "It permits to update a category")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Category updated successfully"),
            @ApiResponse(code = 404, message = "Category not found"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    public ResponseEntity<Mono<Category>> updateCategory( @PathVariable("id") String id, CategoryRequest category){
        return new
                ResponseEntity<>(this.categoryService.update(id,category),
                HttpStatus.OK);
    }
}
