package vikram.kafka.kafka;

import vikram.kafka.Repository.StudentRepository;
import vikram.kafka.payload.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @Autowired
    private StudentRepository studentRepository;

        @KafkaListener(topics = "studentTopics2", groupId = "studentGroups")
        public void consume(Student student) {
            LOGGER.info(String.format("Student message received -> %s", student.toString()));
        }

    }

