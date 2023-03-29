package com.example.addressbook.services;

import com.example.addressbook.dtos.AddressBookRequestDto;
import com.example.addressbook.dtos.AddressBookResponseDto;
import com.example.addressbook.models.AddressBook;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AddressBookService {

    AddressBookResponseDto createAddressBook(AddressBookRequestDto requestDto);

    AddressBookResponseDto getAddressBook(String name);

    Page<AddressBook> getAllAddressaBooks(int pageNo, int pageSize, String sortBy);

    AddressBookResponseDto updateAddressBook(Long id, AddressBookRequestDto requestDto);
    void deleteAddressBook(Long id);



}


