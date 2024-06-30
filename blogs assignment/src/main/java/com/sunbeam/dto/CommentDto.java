package com.sunbeam.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto extends BaseDTO {
	private String commentText;
	private int rating;
	private Long postId;
	private Long commenterId;
}
