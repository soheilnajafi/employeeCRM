package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Registration;
import com.employee.repository.RegistrationRepo;
import com.employee.service.RegistrationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/all")
public class RegistrationController {

	// dependency injection
	@Autowired
	RegistrationService registrationService;
	@Autowired
	RegistrationRepo registrationRepo;

	@PostMapping("/users") //minute 1:20:07 - 1:30:50
	public Registration registerUser(@RequestBody Registration regis) throws Exception {

		String userEmail = regis.getEmail();

		if (userEmail != null && !"".equals(userEmail)) {
			Registration userObject = registrationRepo.findUserByEmail(userEmail);

			if (userObject != null) {
				throw new Exception("User with " + userEmail + " is already exist");
			}
			
			
		}
		
		Registration theuser = null;
		theuser = registrationService.saveUser(regis);
		return regis;

	}

	// get all users from service class ----------------------------- End video
	
	@GetMapping("/users")
	public List<Registration> getAllRegisteredUsers (){
		return registrationService.getAllUsers();
	}
	
	// added this user login API ----- Starting from FD --------- Start video
	
	@PostMapping("/userLogin")
	public Registration userLogin (@RequestBody Registration userLogin) throws Exception {
		
				
		String userEmail = userLogin.getEmail();
		String userPassword = userLogin.getPassword();
		
		Registration userObject = null;
		
		if (userEmail != null & userPassword != null) {
			userObject = registrationService.findUserByEmailAndPasswoord(userEmail, userPassword);
		}
		if (userObject == null ) {
			throw new Exception("Bad Credential");
		}		
		
		
		return userObject; //corrected this 
		
		
	}
	
	// start at 48:06 after testing vClips 4th video --------
	
	@GetMapping("/user/{id}")
	public Optional <Registration> getUserById(@PathVariable long id){
		return registrationService.getUserById(id);
		
			
	}
	
	// update user by id API 1:30:00
	@PutMapping("/user/{id}")
	public void updateUser(@RequestBody Registration reg,  @PathVariable Long id) {
		registrationService.updateUser(reg, id);
	}
	
	//1:11"30'
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Long id) {
		registrationService.deleteUser(id);
	}
		
	//1:16"30'
	
	//patch user by ID API
	@PatchMapping("/user/{id}")
	public void patchUser(@RequestBody Registration reg, @PathVariable Long id) {
		registrationService.patchUser(reg, id);
		
	}
	
			
}
