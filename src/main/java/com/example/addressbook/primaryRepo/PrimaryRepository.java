package com.example.addressbook.primaryRepo;

import com.example.addressbook.primaryEntity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryRepository extends JpaRepository<Student, Integer> {


}
