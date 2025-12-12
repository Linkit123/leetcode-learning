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

  List<String> items = Arrays.asList("apple", "banana", "apricot", "blueberry", "orange");

  @RestController
  @RequestMapping("/api/v1")
  public class ExController {

    @PostMapping("/filterItems")
    public List<String> filterItems(@RequestBody FilterRequest request) {

      var response = new ArrayList<String>();
      for (String item : items) {
        if (item.contains(request.getFilterCondition())) {
          response.add(item);
        }
      }

      return response;
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