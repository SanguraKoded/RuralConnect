package com.sangura.ruralconnect.userService.repo;

import com.sangura.ruralconnect.productService.entities.Product;
import com.sangura.ruralconnect.userService.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {
    Users findUserById(Long id);
}
