package com.mvc.demo.mapper;

import com.mvc.demo.dto.AddressDto;
import com.mvc.demo.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address map(AddressDto addressDto){
        Address address = new Address();
        address.setId(addressDto.getId());
        address.setStreet(addressDto.getStreet());
        address.setStreetNo(addressDto.getStreetNo());
        address.setBuilding(addressDto.getBuilding());
        return address;
    }

    public AddressDto map(Address address){
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setStreet(address.getStreet());
        addressDto.setStreetNo(address.getStreetNo());
        addressDto.setBuilding(address.getBuilding());
        return addressDto;
    }
}
