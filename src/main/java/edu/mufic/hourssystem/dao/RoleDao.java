package edu.mufic.hourssystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mufic.hourssystem.dao.entity.Role;

@Repository("roleRepository")
public interface RoleDao extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}
