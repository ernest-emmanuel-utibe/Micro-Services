import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.HashMap;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final WebClient webClient;

    public OrderController(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://userservice:8080").build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getOrder(@PathVariable String id) {
        Map<String, Object> order = new HashMap<>();
        order.put("orderId", id);
        order.put("item", "Laptop");

        Map user = webClient.get()
                .uri("/users/" + id)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        order.put("user", user);
        return ResponseEntity.ok(order);
    }
}
