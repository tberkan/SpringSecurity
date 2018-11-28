package com.endava.SpringSecurity.dao;

import com.endava.SpringSecurity.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDao extends CrudRepository<Role, Long> {
    Optional<Role> findById(Long id);

    Role findByName(String role_user);
}