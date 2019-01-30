package mg.tmr.khr.bara.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.tmr.khr.bara.main.model.User;
import mg.tmr.khr.bara.main.repository.UserRepository;

@Service("userService")
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User findByConfirmationToken(String confirmationToken) {
		return userRepository.findByConfirmationToken(confirmationToken);
	}
	
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}

}
