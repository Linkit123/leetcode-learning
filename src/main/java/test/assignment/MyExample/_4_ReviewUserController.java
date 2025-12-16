package test.assignment.MyExample;

/**
 * MVC Code Review - Question 4.1
 * Time: 20 minutes | Type: Code Review | Score: 8/20
 * 
 * TASK: Review the provided Spring Boot MVC code snippet, identify violations of MVC principles,
 * and suggest improvements to adhere to proper MVC design patterns.
 */

public class _4_ReviewUserController {

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
    
    /*
     * ============================================================================
     * 1. IDENTIFIED VIOLATIONS (At least 2 violations)
     * ============================================================================
     * 
     * VIOLATION #1: Business Logic in Controller Layer
     * Location: UserController.getAllUsers() method
     * Code: long totalActiveUsers = users.stream().filter(User::isActive).count();
     * 
     * VIOLATION #2: Direct Entity Manipulation with Primitive Parameters
     * Location: UserController.createUser() method
     * Code: User newUser = new User(); newUser.setUsername(username); newUser.setEmail(email);
     * 
     * VIOLATION #3: Missing Input Validation and Error Handling
     * Location: Both controller methods
     * Issue: No validation annotations or error handling mechanisms
     * 
     * ============================================================================
     * 2. EXPLANATION OF VIOLATIONS
     * ============================================================================
     * 
     * VIOLATION #1 - Business Logic in Controller:
     * -----------------------------------------------
     * WHY THIS IS A PROBLEM:
     * - Violates Separation of Concerns principle
     * - Controllers should ONLY handle HTTP request/response coordination
     * - Business logic (filtering, counting, calculations) belongs in Service layer
     * - Reduces code reusability - cannot use this logic elsewhere
     * - Makes unit testing more complex - controller tests now test business logic
     * - Harder to maintain - business rule changes require controller modifications
     * 
     * MVC PRINCIPLE VIOLATED: 
     * Controller should be thin and delegate business operations to Service layer
     * 
     * 
     * VIOLATION #2 - Direct Entity Manipulation:
     * -------------------------------------------
     * WHY THIS IS A PROBLEM:
     * - Using primitive parameters (String username, String email) instead of DTO
     * - Controller directly creates and populates domain entity (User)
     * - Tight coupling between controller and entity structure
     * - No abstraction between API contract and domain model
     * - Security risk: Mass assignment vulnerability
     * - Missing validation layer between external input and domain object
     * 
     * MVC PRINCIPLE VIOLATED:
     * Controller should work with DTOs/Form objects, not domain entities directly
     * 
     * 
     * VIOLATION #3 - Missing Input Validation:
     * -----------------------------------------
     * WHY THIS IS A PROBLEM:
     * - No validation for email format, username constraints
     * - No error handling for database failures or constraint violations
     * - Poor user experience - no feedback for invalid inputs
     * - Security vulnerabilities - unvalidated input can cause injection attacks
     * - Application can crash or enter invalid state
     * 
     * MVC PRINCIPLE VIOLATED:
     * Controller should validate inputs and handle errors gracefully
     * 
     * ============================================================================
     * 3. SUGGESTED IMPROVEMENTS
     * ============================================================================
     */
    
    // // IMPROVEMENT 1: Create a DTO for user creation
    // public static class UserCreationDTO {
    //     @NotBlank(message = "Username is required")
    //     @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    //     private String username;
        
    //     @NotBlank(message = "Email is required")
    //     @Email(message = "Email must be valid")
    //     private String email;
        
    //     // Getters and setters
    //     public String getUsername() { return username; }
    //     public void setUsername(String username) { this.username = username; }
    //     public String getEmail() { return email; }
    //     public void setEmail(String email) { this.email = email; }
    // }
    
    // // IMPROVEMENT 2: Enhanced UserService with business logic
    // public static class ImprovedUserService {
    //     private final UserRepository userRepository;
        
    //     public ImprovedUserService(UserRepository userRepository) {
    //         this.userRepository = userRepository;
    //     }
        
    //     // Business logic moved to service layer
    //     public List<User> getAllUsers() {
    //         return userRepository.findAll();
    //     }
        
    //     // Business logic for counting active users
    //     public long getTotalActiveUsers() {
    //         return userRepository.findAll()
    //             .stream()
    //             .filter(User::isActive)
    //             .count();
    //     }
        
    //     // Alternative: Query-based approach (more efficient)
    //     public long countActiveUsers() {
    //         return userRepository.countByActiveTrue();
    //     }
        
    //     // Business logic for user creation with validation
    //     public User createUser(UserCreationDTO dto) {
    //         // Business validation
    //         if (userRepository.existsByUsername(dto.getUsername())) {
    //             throw new IllegalArgumentException("Username already exists");
    //         }
    //         if (userRepository.existsByEmail(dto.getEmail())) {
    //             throw new IllegalArgumentException("Email already registered");
    //         }
            
    //         // Create entity from DTO
    //         User user = new User();
    //         user.setUsername(dto.getUsername());
    //         user.setEmail(dto.getEmail());
    //         user.setActive(true); // Business rule: new users are active
            
    //         return userRepository.save(user);
    //     }
    // }
    
    // // IMPROVEMENT 3: Refactored Controller with proper MVC separation
    // // @Controller
    // // @RequestMapping("/users")
    // public static class ImprovedUserController {
    //     private final ImprovedUserService userService;
        
    //     // @Autowired
    //     public ImprovedUserController(ImprovedUserService userService) {
    //         this.userService = userService;
    //     }
        
    //     /**
    //      * IMPROVED: Business logic moved to service layer
    //      * Controller only coordinates between service and view
    //      */
    //     // @GetMapping
    //     public String getAllUsers(Model model) {
    //         try {
    //             List<User> users = userService.getAllUsers();
    //             long totalActiveUsers = userService.getTotalActiveUsers(); // Delegated to service
                
    //             model.addAttribute("users", users);
    //             model.addAttribute("totalActiveUsers", totalActiveUsers);
                
    //             return "userListView";
    //         } catch (Exception e) {
    //             model.addAttribute("error", "Failed to load users: " + e.getMessage());
    //             return "errorView";
    //         }
    //     }
        
    //     /**
    //      * IMPROVED: Uses DTO with validation, proper error handling
    //      * Controller validates input and delegates to service
    //      */
    //     // @PostMapping
    //     public String createUser(@Valid UserCreationDTO userDTO, 
    //                             BindingResult result,
    //                             RedirectAttributes redirectAttributes) {
    //         // Check validation errors
    //         if (result.hasErrors()) {
    //             redirectAttributes.addFlashAttribute("errors", result.getAllErrors());
    //             return "redirect:/users/new";
    //         }
            
    //         try {
    //             userService.createUser(userDTO); // Delegate to service
    //             redirectAttributes.addFlashAttribute("success", "User created successfully");
    //             return "redirect:/users";
    //         } catch (IllegalArgumentException e) {
    //             redirectAttributes.addFlashAttribute("error", e.getMessage());
    //             return "redirect:/users/new";
    //         } catch (Exception e) {
    //             redirectAttributes.addFlashAttribute("error", "Failed to create user");
    //             return "redirect:/users/new";
    //         }
    //     }
    // }
    
    /*
     * ============================================================================
     * SUMMARY OF IMPROVEMENTS
     * ============================================================================
     * 
     * 1. SEPARATION OF CONCERNS:
     *    - Controller: Handles HTTP, validation, error handling
     *    - Service: Contains business logic (counting, creation rules)
     *    - Repository: Data access only
     * 
     * 2. PROPER ABSTRACTION:
     *    - DTO (UserCreationDTO) for external API contract
     *    - Entity (User) for internal domain model
     *    - Clear boundary between layers
     * 
     * 3. VALIDATION & ERROR HANDLING:
     *    - Input validation using @Valid and Bean Validation
     *    - Business validation in service layer
     *    - Proper exception handling with user feedback
     * 
     * 4. MAINTAINABILITY:
     *    - Business rules centralized in service
     *    - Easy to test each layer independently
     *    - Changes to business logic don't affect controller
     * 
     * 5. BEST PRACTICES APPLIED:
     *    - Constructor injection
     *    - DTO pattern for API contracts
     *    - Service layer for business logic
     *    - Repository for data access
     *    - Proper error handling and user feedback
     * 
     * ============================================================================
     * HOW THESE IMPROVEMENTS ADHERE TO MVC PATTERN
     * ============================================================================
     * 
     * MODEL:
     * - UserCreationDTO: Represents form/API input
     * - User entity: Represents domain data
     * - Clear separation between external and internal models
     * 
     * VIEW:
     * - Controller returns view names ("userListView", "errorView")
     * - Model attributes properly populated
     * - Error/success messages passed via RedirectAttributes
     * 
     * CONTROLLER:
     * - Thin controller - only HTTP coordination
     * - Input validation delegated to framework (@Valid)
     * - Business logic delegated to service
     * - Proper error handling and user feedback
     * 
     * SERVICE:
     * - Business logic encapsulated (counting, validation rules)
     * - Reusable across different controllers
     * - Easy to test independently
     * - Single responsibility
     * 
     * ============================================================================
     */
}
