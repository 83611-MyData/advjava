package com.sunbeam.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeleteTagPostDTO {
	private Long tagId;
	private Long postId;
}
