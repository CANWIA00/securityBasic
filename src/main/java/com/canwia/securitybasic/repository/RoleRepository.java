package com.canwia.securitybasic.repository;

import com.canwia.securitybasic.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Long, Role> {
}
