@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, String>> getUser(@PathVariable String id) {
        Map<String, String> user = new HashMap<>();
        user.put("id", id);
        user.put("name", "John Doe");
        return ResponseEntity.ok(user);
    }
}
