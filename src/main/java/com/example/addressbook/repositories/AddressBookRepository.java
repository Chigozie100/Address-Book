package com.example.addressbook.repositories;

import com.example.addressbook.models.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {


    Optional<AddressBook> findByEmail(String email);

    Optional<AddressBook> findByFirstNameIgnoreCase(String name);

}
