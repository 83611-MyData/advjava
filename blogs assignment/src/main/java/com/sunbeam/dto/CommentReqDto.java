package com.sunbeam.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentReqDto {
	private String commentText;
	private Long commentId;
}
