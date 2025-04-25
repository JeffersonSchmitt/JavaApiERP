package com.example.FirstApi.controller;

import com.example.FirstApi.controller.Interface.IBaseController;
import com.example.FirstApi.dataObject.UserDTO;
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
public class UserController implements IBaseController<UserDTO> {

    private final UserService userService;

    @GetMapping
    @Operation(summary = "Listar todos os usuarios")
    @Override
    public List<UserDTO> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuarios por ID")
    @Override
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        UserDTO userDTO = userService.findById(id);
        return userDTO != null ? ResponseEntity.ok(userDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo usuario")
    @Override
    public UserDTO create(UserDTO userDTO) {
        return userService.save(userDTO);
    }

    public ResponseEntity<UserDTO> update(Long id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUserDTO = userService.update(id, userDTO);
        return updatedUserDTO != null ? ResponseEntity.ok(updatedUserDTO) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir usuario")
    @Override
    public String delete(Long id) {
        return userService.delete(id);
    }
}
