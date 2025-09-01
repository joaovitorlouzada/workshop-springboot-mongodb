package com.joaolouzada.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaolouzada.workshopmongo.domain.Post;
import com.joaolouzada.workshopmongo.services.PostService;

@RestController
@RequestMapping(value ="/posts")
public class PostResource {
	
	@Autowired
	PostService postService;
	
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll(){
		List<Post> list = postService.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<Post> findPostById(@PathVariable String id){
		Post obj = postService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
