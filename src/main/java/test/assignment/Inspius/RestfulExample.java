package test.assignment.Inspius;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class RestfulExample {

  public static void main(String[] args) {
    SpringApplication.run(RestfulExample.class, args);
  }
}

@RestController
@RequestMapping("/api/v1")
class FilterController {

  private final List<String> items = Arrays.asList("apple", "banana", "apricot", "blueberry", "orange");

  @PostMapping("/filterItems")
  public List<String> filterItems(@RequestBody FilterRequest request) {
    List<String> result = new ArrayList<>();
    String filterCondition = request.getFilterCondition();

    for (String item : items) {
      if (item.contains(filterCondition)) {
        result.add(item);
      }
    }
    return result;
  }
}

class FilterRequest {

  private String filterCondition;

  public FilterRequest() {
  }

  public FilterRequest(String filterCondition) {
    this.filterCondition = filterCondition;
  }

  public String getFilterCondition() {
    return filterCondition;
  }

  public void setFilterCondition(String filterCondition) {
    this.filterCondition = filterCondition;
  }
}