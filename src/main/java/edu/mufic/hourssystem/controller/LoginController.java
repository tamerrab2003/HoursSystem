package edu.mufic.hourssystem.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import edu.mufic.hourssystem.dao.entity.Role;
import edu.mufic.hourssystem.dao.entity.User;
import edu.mufic.hourssystem.service.UserService;

//@Controller
@RestController
public class LoginController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authManager;
    
    @RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

    /**
     * Retrieves the currently logged in user.
     *
     * @return A transfer containing the username and the roles.
     * @throws Exception 
     */
    /*@RequestMapping(value="/user", method = RequestMethod.GET, produces = {"application/json"})
    public UsernamePasswordAuthenticationToken getUser() throws Exception
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (!(principal instanceof UserDetails)) {
        	throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED);
        }
        User userDetails = (User) principal;

        return new UsernamePasswordAuthenticationToken(userDetails.getEmail(), this.createRoleMap(userDetails.getRoles()));
    }*/

    /**
     * UsernamePasswordAuthenticationToken a user and creates an access token.
     *
     * @param username The name of the user.
     * @param password The password of the user.
     * @return The generated access token.
     */
    @RequestMapping(value="/authenticate", method = RequestMethod.POST, produces = {"application/json"})
    public UsernamePasswordAuthenticationToken authenticate(@RequestParam("username") String username, @RequestParam("password") String password)
    {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, bCryptPasswordEncoder.encode(password));
        Authentication authentication = this.authManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        Object principal = authentication.getPrincipal();
        if (!(principal instanceof User)) {
            throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED);
        }

        User userDetails = (User) principal;

        return new UsernamePasswordAuthenticationToken(userDetails.getEmail(), this.createRoleMap(userDetails.getRoles()));
    }

    private Map<String, Boolean> createRoleMap(Set<Role> authorities)
    {
        Map<String, Boolean> roles = new HashMap<String, Boolean>();
        for (Role authority : authorities) {
            roles.put(authority.getRole(), Boolean.TRUE);
        }

        return roles;
    }
	

}
