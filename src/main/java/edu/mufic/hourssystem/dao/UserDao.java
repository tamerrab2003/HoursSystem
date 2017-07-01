package edu.mufic.hourssystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mufic.hourssystem.dao.entity.User;

@Repository("userRepository")
public interface UserDao extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
