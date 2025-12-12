package test.assignment.Inspius;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// You have been provided with a partial Java application developed using Spring
// Boot, implementing an MVC architecture.
// Your task is to review this code snippet, identify any violations of MVC
// principles, and suggest improvements to adhere to proper MVC design patterns.
// Focus on separation of concerns, appropriate responsibilities for each
// component (Model, View, Controller), and adherence to best practices in
// Spring Boot application development.
// Sample code snippet of a Java MVC application using Spring Boot

// @Controller
// public class UserController {
// // This service dependency is expected to manage business logic
// private final UserService userService;

// @Autowired
// public UserController(UserService userService) {
// this.userService = userService;
// }

// // This method handles user data fetching and rendering
// @GetMapping("/users")
// public String getAllUsers(Model model) {
// List<User> users = userService.getAllUsers();
// long totalActiveUsers = users.stream().filter(User::isActive).count();
// model.addAttribute("users", users);
// model.addAttribute("totalActiveUsers", totalActiveUsers);

// return "userListView";
// }

// // Method to handle new user creation
// @PostMapping("/users")
// public String createUser(String username, String email) {
// User newUser = new User();
// newUser.setUsername(username);
// newUser.setEmail(email);

// userService.saveUser(newUser);

// return "redirect:/users";
// }
// }

// @Service
// public class UserService {
// private final UserRepository userRepository;

// @Autowired
// public UserService(UserRepository userRepository) {
// this.userRepository = userRepository;
// }

// public List<User> getAllUsers() {
// return userRepository.findAll();
// }

// public void saveUser(User user) {
// userRepository.save(user);
// }
// }
