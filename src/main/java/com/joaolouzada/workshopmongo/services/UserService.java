package com.joaolouzada.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaolouzada.workshopmongo.domain.Post;
import com.joaolouzada.workshopmongo.domain.User;
import com.joaolouzada.workshopmongo.dto.UserDTO;
import com.joaolouzada.workshopmongo.repositories.UserRepository;
import com.joaolouzada.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
	    return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
	    User newObj = repo.findById(obj.getId())
	                      .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	    updateData(newObj, obj);
	    return repo.save(newObj);
	}

	private void updateData(User newObj, User obj) {
	    newObj.setName(obj.getName());
	    newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
	

}
