package com.example.FirstApi.controller;

import com.example.FirstApi.controller.Interface.IBaseController;
import com.example.FirstApi.model.user.User;
import com.example.FirstApi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Tag(name = "User", description = "Endpoints de usuário")
public class UserController implements IBaseController<User> {

    private final UserService userService;

    @GetMapping
    @Operation(summary = "Listar todos os usuarios")
    @Override
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuarios por ID")
    @Override
    public ResponseEntity<User> getById(@PathVariable Long id) {
        User user = userService.findById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo usuario")
    @Override
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar cliente existente")
    public ResponseEntity<User> update(Long id, @RequestBody User user) {
        User updatedUser = userService.update(id, user);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir usuario")
    @Override
    public String delete(Long id) {
        return userService.delete(id);
    }
}
