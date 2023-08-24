package com.example.addressbook.services.impl;

import com.example.addressbook.dtos.AddressBookRequestDto;
import com.example.addressbook.dtos.AddressBookResponseDto;
import com.example.addressbook.exceptions.ResourceNotFoundException;
import com.example.addressbook.models.address.AddressBook;
import com.example.addressbook.repositories.address.AddressBookRepository;
import com.example.addressbook.services.AddressBookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressBookServiceImpl implements AddressBookService {
    private final AddressBookRepository repository;
    private final ModelMapper modelMapper;


    @Override
    public AddressBookResponseDto createAddressBook(AddressBookRequestDto requestDto) {
        repository.findByEmail(requestDto.getEmail()).ifPresent(address -> {
                            throw  new ResourceNotFoundException(" Address book already exist");
                });
        AddressBook addressBook=modelMapper.map(requestDto, AddressBook.class);
        return modelMapper.map(repository.save(addressBook), AddressBookResponseDto.class);
    }

    @Override
    public AddressBookResponseDto getAddressBook(String name) {
        AddressBook addressBook=repository.findByFirstNameIgnoreCase(name).orElseThrow(()-> new ResourceNotFoundException(" Address book not found"));
        return modelMapper.map(addressBook, AddressBookResponseDto.class);
    }

    @Override
    public Page<AddressBook> getAllAddressaBooks(int pageNo, int pageSize, String sortBy) {
        PageRequest paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return repository.findAll(paging);
    }

    @Override
    public AddressBookResponseDto updateAddressBook(Long id, AddressBookRequestDto requestDto) {
        AddressBook addressBook=repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(" Address book not foud"));
        addressBook.setFirstName(requestDto.getFirstName());
        addressBook.setPhoneNumber(requestDto.getPhoneNumber());
        addressBook.setEmail(requestDto.getEmail());
        addressBook.setCompanyName(requestDto.getCompanyName());
        addressBook.setFaxNumber(requestDto.getFaxNumber());
        return modelMapper.map(repository.save(addressBook), AddressBookResponseDto.class);
    }

    @Override
    public void deleteAddressBook(Long id) {
        repository.deleteById(id);
    }
}
