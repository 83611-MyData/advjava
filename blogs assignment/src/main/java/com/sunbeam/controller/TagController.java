package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.dto.DeleteTagPostDTO;
import com.sunbeam.dto.TagPostDTO;
import com.sunbeam.dto.TagRespDTO;
import com.sunbeam.service.TagService;

@RestController
@RequestMapping("/tag")
public class TagController {
	@Autowired
	private TagService tagService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addTags(@RequestBody TagRespDTO dto){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(tagService.addTags(dto));
		}catch (RuntimeException e) {
			System.err.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiException(e.getMessage()));
		}
	}
	
	@PutMapping("/add_post")
	public ResponseEntity<?> addTagToPost(@RequestBody TagPostDTO dto){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(tagService.addPostTotag(dto));
		}catch (RuntimeException e) {
			System.err.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiException(e.getMessage()));
		}
	}
	
	@PutMapping("/delete_post")
	public ResponseEntity<?> deletePostFromTag(@RequestBody DeleteTagPostDTO dto){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(tagService.deletePostFromTag(dto));
		}catch (RuntimeException e) {
			System.err.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiException(e.getMessage()));
		}
	}
}
