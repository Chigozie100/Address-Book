package com.example.addressbook.repositories.address;

import com.example.addressbook.models.address.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {


    Optional<AddressBook> findByEmail(String email);

    Optional<AddressBook> findByFirstNameIgnoreCase(String name);

}
