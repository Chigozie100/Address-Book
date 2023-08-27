package com.example.addressbook.repositories.primary;

import com.example.addressbook.entities.primary.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<Student, Integer> {


}
