package edu.mufic.hourssystem.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.mufic.hourssystem.dao.RoleDao;
import edu.mufic.hourssystem.dao.UserDao;
import edu.mufic.hourssystem.dao.entity.Role;
import edu.mufic.hourssystem.dao.entity.User;
import edu.mufic.hourssystem.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userRepository;
	@Autowired
    private RoleDao roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        Role userRole = roleRepository.findByRole("SUPER_ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
	
	public User findById(Long id) {
        return userRepository.findOne(id);
    }
 
    public void updateUser(User user){
        saveUser(user);
    }
 
    public void deleteUserById(Long id){
        userRepository.delete(id);
    }
 
    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
 
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
 
    public boolean isUserExist(User user) {
        return findUserByEmail(user.getEmail()) != null;
    }
	
}
