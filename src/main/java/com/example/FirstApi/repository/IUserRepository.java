package com.example.FirstApi.repository;

import com.example.FirstApi.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
