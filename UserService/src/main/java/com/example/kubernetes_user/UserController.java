import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.HashMap;
import org.springframework.web.reactive.function.client.WebClient;


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
