package com.sunbeam.service;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.DeleteTagPostDTO;
import com.sunbeam.dto.TagPostDTO;
import com.sunbeam.dto.TagRespDTO;

public interface TagService {
	ApiResponse addTags(TagRespDTO tag);
	ApiResponse addPostTotag(TagPostDTO dto);
	ApiResponse deletePostFromTag(DeleteTagPostDTO dto);
}
