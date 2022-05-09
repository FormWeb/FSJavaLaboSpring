package com.example.projectbackend;

import com.example.projectbackend.mapper.AuthorMapper;
import com.example.projectbackend.model.dto.AuthorDTO;
import com.example.projectbackend.model.entity.Author;
import com.example.projectbackend.model.entity.Post;
import com.example.projectbackend.repository.AuthorRepository;
import com.example.projectbackend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProjectbackendApplication implements CommandLineRunner {

	@Autowired
	public PostRepository postRepository;

	@Autowired
	public AuthorMapper authorMapper;

	@Autowired
	public AuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjectbackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// 1. Manipulation du repository (sera fait dans les services)

		Post newPost = new Post("Hi");
		postRepository.save(newPost);

		System.out.println("\n Find all : ");

		List<Post> posts = postRepository.findAll();

		for (Post post : posts) {
			System.out.println(post.getMessage());
		}

		System.out.println("\n Find by message : ");

//		Post postFoundByMessage = postRepository.findByMessage("Hi");
//		System.out.println(postFoundByMessage.getId());

		System.out.println("\n Find long posts : ");

		List<Post> longPosts = postRepository.findLongPosts();

		for (Post post : longPosts) {
			System.out.println(post.getMessage());
		}

		// 2. Utilisation du mapper (sera fait dans les services)

		// Pour insérer une donnée
		// On récupère un AuthorDTO
		AuthorDTO authorDTO = new AuthorDTO("Pierre", "Bourdieu");

		// On le convertit en Author via le mapper
		Author newAuthor = authorMapper.toEntity(authorDTO);

		// On le sauve via le repository
		authorRepository.save(newAuthor);

		// Pour récupérer une donnée
		Author authorToFind = authorRepository.findById(1).orElse(null);
		AuthorDTO authorToSend = authorMapper.toDto(authorToFind);
		System.out.println(authorToSend);
	}
}
