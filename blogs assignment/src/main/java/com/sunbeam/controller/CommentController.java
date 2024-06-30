package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.dto.CommentDto;
import com.sunbeam.dto.CommentReqDto;
import com.sunbeam.service.CommentService;



@RestController
@RequestMapping("/comment")
public class CommentController {
	
	public CommentController() {
		System.out.println("In ctor"+getClass());
	}
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping 
	public ResponseEntity<?> addComment(@RequestBody CommentDto commentDto){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(commentService.addComment(commentDto));
		}catch (RuntimeException e) {
			System.err.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiException(e.getMessage()));
		}
			
	}
	
	@PutMapping
	public ResponseEntity<?> updateComment(@RequestBody CommentReqDto dto){
		try {
			return ResponseEntity.ok(commentService.updateComment(dto));
		} catch (RuntimeException e) {
			System.err.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiException(e.getMessage()));
		}
	}
	
	@DeleteMapping("/{commenterId}")
	public ResponseEntity<?> deleteCommentersComments(@PathVariable Long commenterId){
		try {
			return ResponseEntity.ok(commentService.deleteComments(commenterId));
		} catch (RuntimeException e) {
			System.err.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiException(e.getMessage()));
		}
	}
}
