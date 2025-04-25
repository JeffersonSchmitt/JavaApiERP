package com.example.FirstApi.dataObject.mapper;

import com.example.FirstApi.dataObject.UserDTO;
import com.example.FirstApi.model.user.Address;
import com.example.FirstApi.model.user.GeoLocation;
import com.example.FirstApi.model.user.Name;
import com.example.FirstApi.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        if (user == null) return null;

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setPhone(user.getPhone());
        dto.setPassword(user.getPassword());

        Name name = user.getName();
        if (name != null) {
            dto.setFirstname(name.getFirstname());
            dto.setLastname(name.getLastname());
        }

        Address address = user.getAddress();
        if (address != null) {
            dto.setCity(address.getCity());
            dto.setStreet(address.getStreet());
            dto.setNumber(address.getNumber());
            dto.setZipcode(address.getZipcode());

            if (address.getGeolocation() != null) {
                dto.setLatitude(address.getGeolocation().getLat());
                dto.setLongitude(address.getGeolocation().getLon());
            }
        }

        return dto;
    }

    public static List<UserDTO> toDTOList(List<User> users) {
        return users == null ? new ArrayList<>() :
                users.stream()
                        .map(UserMapper::toDTO)
                        .collect(Collectors.toList());
    }


    public static User toEntity(UserDTO userDTO) {
        if (userDTO == null) return null;

        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setPhone(userDTO.getPhone());
        user.setPassword(userDTO.getPassword());

        // Mapeando o nome
        Name name = new Name();
        name.setFirstname(userDTO.getFirstname());
        name.setLastname(userDTO.getLastname());
        user.setName(name);

        // Mapeando o endereço
        Address address = new Address();
        address.setCity(userDTO.getCity());
        address.setStreet(userDTO.getStreet());
        address.setNumber(userDTO.getNumber());
        address.setZipcode(userDTO.getZipcode());

        // Mapeando a geolocalização
        GeoLocation geoLocation = new GeoLocation();
        geoLocation.setLat(userDTO.getLatitude());
        geoLocation.setLon(userDTO.getLongitude());
        address.setGeolocation(geoLocation);

        user.setAddress(address);

        return user;
    }
}
