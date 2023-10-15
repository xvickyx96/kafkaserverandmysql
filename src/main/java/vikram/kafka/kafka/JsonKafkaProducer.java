package vikram.kafka.kafka;

import vikram.kafka.payload.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class  JsonKafkaProducer {

    private KafkaTemplate<String, Object>kafkaTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger((JsonKafkaProducer.class));

    public JsonKafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendStudent(Student student) {
        LOGGER.info(String.format("Student message sent -> %s", student.toString()));
        Message<Student> message = MessageBuilder.withPayload(student).setHeader(KafkaHeaders.TOPIC, "studentTopics2").build();
        kafkaTemplate.send(message);
    }
}
