package com.example.progressservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.progressservice.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

	Role findByName(String user);
}
