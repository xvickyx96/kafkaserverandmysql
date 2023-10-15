package vikram.kafka.kafka;

import vikram.kafka.Repository.StudentRepository;
import vikram.kafka.payload.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumerDb {

    @Autowired
    private StudentRepository studentRepository;

    @KafkaListener(topics = "studentTopics2", groupId = "studentGroups2")
    public void writeToDB(Student student) {

        // Skicka data till DB
        studentRepository.save(student);
    }


}
