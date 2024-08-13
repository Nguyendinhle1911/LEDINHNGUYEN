package org.example.school_system_analysis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getTopStudents() {
        return studentRepository.findAll().stream()
                .filter(Student::isTopStudent)
                .collect(Collectors.toList());
    }
}
