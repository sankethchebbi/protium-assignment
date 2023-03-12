package com.sanketh.protium.repository;

import com.sanketh.protium.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
