package com.sunbeam.service;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CommentDto;
import com.sunbeam.dto.CommentReqDto;

public interface CommentService {
	
	CommentDto addComment(CommentDto commentDto);
	CommentDto updateComment(CommentReqDto commentReqDTO);
	ApiResponse deleteComments(Long id);

}
