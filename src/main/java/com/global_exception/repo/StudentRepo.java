package com.global_exception.repo;

import com.global_exception.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

public interface StudentRepo extends MongoRepository<Student, Short> {


}
