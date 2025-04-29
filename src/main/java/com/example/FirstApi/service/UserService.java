package com.example.FirstApi.service;

import com.example.FirstApi.model.user.User;
import com.example.FirstApi.service.Interface.IBaseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements IBaseService<User> {
    private final RestTemplate restTemplate;
    private final String URL_BASE = "https://fakestoreapi.com/users/";

    @Override
    public List<User> findAll() {

        try {
            User[] users = restTemplate.getForObject(URL_BASE, User[].class);
            if (users != null) {
                return Arrays.asList(users);
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findById(Long id) {
        String url = URL_BASE + id;
        try {
            User user = restTemplate.getForObject(url, User.class);
            return Objects.requireNonNull(user).getId() != null ? user : null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User save(User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<>(user, headers);

        User createdUser = restTemplate.postForObject(URL_BASE, request, User.class);
        User completeUser = findById(createdUser.getId());

        return completeUser;
    }

    @Override
    public User update(Long id, User userDTO) {
        User existingUser = findById(id);
        restTemplate.put(URL_BASE + id, existingUser);
        return Objects.requireNonNull(existingUser).getName() != null ? existingUser : null;
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
