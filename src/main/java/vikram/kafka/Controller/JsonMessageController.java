package vikram.kafka.Controller;

import vikram.kafka.kafka.JsonKafkaProducer;
import vikram.kafka.payload.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publishStudent")
    public ResponseEntity<String> publishStudent(@RequestBody Student student) {
        kafkaProducer.sendStudent(student);
        return ResponseEntity.ok("Student Message sent to the Topic");
    }
}

