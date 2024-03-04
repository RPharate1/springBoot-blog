package com.springboot.blog.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springboot.blog.entity.Post;
import com.springboot.blog.payload.PostDto;


public interface PostService {
	PostDto createPost(PostDto postDto);
	
	List<Post>getAllPost();
	
	PostDto getPostById(long id);;

}
