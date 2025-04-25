package com.example.FirstApi.service;

import com.example.FirstApi.dataObject.UserDTO;
import com.example.FirstApi.dataObject.mapper.UserMapper;
import com.example.FirstApi.model.user.User;
import com.example.FirstApi.repository.IUserRepository;
import com.example.FirstApi.service.Interface.IBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements IBaseService<UserDTO> {
    private final RestTemplate restTemplate;
    private final String URL_BASE = "https://fakestoreapi.com/users/";

    @Override
    public List<UserDTO> findAll() {

        try {
            User[] users = restTemplate.getForObject(URL_BASE, User[].class);
            if (users != null) {
                return Arrays.stream(users)
                        .map(UserMapper::toDTO)
                        .collect(Collectors.toList());
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserDTO findById(Long id) {
        String url = URL_BASE + id;

        try {
            User user = restTemplate.getForObject(url, User.class);
            return user != null ? UserMapper.toDTO(user) : null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserDTO save(UserDTO userDT) {
        User user = UserMapper.toEntity(userDT);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<>(user, headers);
        User createdUser = restTemplate.postForObject(URL_BASE, request, User.class);

        return createdUser != null ? UserMapper.toDTO(createdUser) : null;
    }

    @Override
    public UserDTO update(Long id, UserDTO userDTO) {
        UserDTO existingUser = findById(id);
        User updatedUser = UserMapper.toEntity(userDTO);
        restTemplate.put(URL_BASE + id, updatedUser);

        return existingUser != null ? UserMapper.toDTO(updatedUser) : null;
    }

    @Override
    public String delete(Long id) {
        String url = URL_BASE + id;

        try {
            restTemplate.delete(url);
            return "Produto excluído com sucesso!";
        } catch (Exception e) {
            System.err.println("Erro ao deletar produto: " + e.getMessage());
            return "Erro ao tentar excluir o produto.";
        }
    }


}
