package com.example.addressbook.secondaryRepo;

import com.example.addressbook.secondaryEntity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondaryRepository extends JpaRepository<Teacher, Integer> {

}
