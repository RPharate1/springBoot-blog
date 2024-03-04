package com.springboot.blog.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.blog.Service.PostService;
import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.payload.PostDto;
import com.springboot.blog.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public PostDto createPost(PostDto postDto) {

		// convert DTO to entity
		Post post = DtoToPost(postDto);
		
//		post.setTitle(postDto.getTitle());
//		post.setDescription(postDto.getDescription());
//		post.setContent(postDto.getContent());
//		
		

		// Save Entity by using repository
		Post newPost = postRepository.save(post);

		return mapToDto(newPost);

//		// Convert Entity to DTO
//		PostDto postResponse = new PostDto();
//		postResponse.setContent(newPost.getContent());
//		postResponse.setDescription(newPost.getDescription());
//		postResponse.setTitle(newPost.getTitle());
//		postResponse.setId(newPost.getId());
//
//		return postResponse;
	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return postRepository.findAll();
	}

	
	
	@Override
	public PostDto getPostById(long id) {
	 Post post=	postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "id", id));
		return mapToDto(post);
			
	}

	private PostDto mapToDto(Post newPost) {
		// Convert Entity to DTO
		PostDto postResponse = new PostDto();
		postResponse.setContent(newPost.getContent());
		postResponse.setDescription(newPost.getDescription());
		postResponse.setTitle(newPost.getTitle());
		postResponse.setId(newPost.getId());

		return postResponse;
	}
	
	private Post DtoToPost(PostDto postDto) {
		Post post = new Post();
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		
		return post;
		
	}

}
