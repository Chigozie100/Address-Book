package com.example.addressbook.repositories.secondary;

import com.example.addressbook.entities.secondary.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface teacherRepository extends JpaRepository<Teacher, Integer> {

}
