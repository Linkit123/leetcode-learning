package test.assignment.MyExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class _1_RestfulExample {
  public static void main(String[] args) {
    SpringApplication.run(_1_RestfulExample.class, args);
  }

  List<String> items = Arrays.asList("apple", "banana", "apricot", "blueberry", "orange");

  @RestController
  @RequestMapping("/api/v1")
  public class ExController {

    @PostMapping("/filterItems")
    public List<String> filterItems(@RequestBody FilterRequest request) {
      return items.stream().filter(item -> item.contains(request.getFilterCondition())).toList();
    }
  }
}

class FilterRequest {
  private String filterCondition;

  // Getters and Setters
  public String getFilterCondition() {
    return filterCondition;
  }

  public void setFilterConditions(String filterCondition) {
    this.filterCondition = filterCondition;
  }

}