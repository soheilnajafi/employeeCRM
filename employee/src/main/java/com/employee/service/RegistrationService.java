package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.employee.model.Registration;
import com.employee.repository.RegistrationRepo;
//https://www.youtube.com/watch?v=42mnSswS_Nw&list=PLIbBXqA5GMVYIJjoK-LhGXCprWkFqFJeu&index=47
//minute 26:36

//chk this codes 

//

@Service
public class RegistrationService {

	// dependency injection minute 1:15

	@Autowired
	RegistrationRepo registrationRepo;
	// registrationRepo its reference variable and
	// its reference of RegistrationRepo
	// RegistrationRepo its interface that has a method of findById(id)

	// save user registration API
	// register in here is username , pw , email

	public Registration saveUser(Registration register) {

		return registrationRepo.save(register);

	}

	// get all Users API
	// getting data from database ----------------------- End video

	public List<Registration> getAllUsers() {
		return registrationRepo.findAll();
	}

	// user login API ----------------------- Start video

	public Registration findUserByEmailAndPasswoord(String emailId, String password) {
		return registrationRepo.findUserByEmailAndPassword(emailId, password);

	}
	// get User By ID API -------------------

	public Optional<Registration> getUserById(Long id) {
		return registrationRepo.findById(id);
	}

	// update user by ID API ---- 55:25--------------

	public void updateUser(Registration r, Long id) {
		if (id == r.getId()) {
			registrationRepo.save(r);
		}

	}

	// delete user by ID API -------------
	public void deleteUser(Long id) {
		registrationRepo.deleteById(id);

	}

	// patch user by ID API when sending data from FrontEnd
	public void patchUser(Registration reg, Long id) {
		if (id == reg.getId()) {
			registrationRepo.save(reg);

		}
	}

}
