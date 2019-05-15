package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.EntityClass;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired
	Repo repo;

	@GetMapping("/user")
	public List<EntityClass> getAllNotes() {
		return (List<EntityClass>) repo.findAll();
	}

	@PostMapping("/adduser")
	public EntityClass createNote(@Valid @RequestBody EntityClass entityclass) {
		return repo.save(entityclass);
	}

	@GetMapping("/user/{id}")
	public Optional<EntityClass> getById(@PathVariable(value = "id") Long id) {
		return repo.findById(id);
	
	}
	
	 /*  @PutMapping("/user/{id}")
	  public EntityClass update(@RequestBody EntityClass entityClass, @PathVariable long id) {

		Optional<EntityClass> aa = repo.findById(id);
		if(aa!=null) {
		repo.save(entityClass);
		}
		return null;
		}*/
		
		@PutMapping("/user/{id}")
		public ResponseEntity<Object> updateStudent(@RequestBody EntityClass entityClass, @PathVariable long id) {

			Optional<EntityClass> studentOptional = repo.findById(id);

			if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();
			//EntityClass.setId(id);
			repo.save(entityClass);
			return ResponseEntity.noContent().build();
		}
	

	@DeleteMapping("/user/{id}")
		public void deleteStudent(@PathVariable long id) {
		repo.deleteById(id);
	}
	
	
}
