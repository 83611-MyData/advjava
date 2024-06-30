package com.sunbeam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.TagDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.DeleteTagPostDTO;
import com.sunbeam.dto.TagPostDTO;
import com.sunbeam.dto.TagRespDTO;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Tag;

@Service
@Transactional
public class TagServiceImpl implements TagService{
	@Autowired
	private TagDao tagDao;
	@Autowired
	private BlogPostDao blogPostDao;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ApiResponse addTags(TagRespDTO tag) {
		Tag t=mapper.map(tag, Tag.class);
		tagDao.save(t);	
		return new ApiResponse("Successful");
	}

	@Override
	public ApiResponse addPostTotag(TagPostDTO dto) {
		Tag tag = tagDao.findByName(dto.getName()).orElseThrow(()-> new ApiException("Invalid Tag Id"));
		if(tag == null)
			throw new ApiException("No Such tag Present");
		BlogPost post = blogPostDao.findById(dto.getPostId()).orElseThrow(()-> new ApiException("Invalid Post Id"));
		if(post == null)
			throw new ApiException("No Such Post Present");
		tag.getPosts().add(post);
		return new ApiResponse("Post Added to tag");
	}

	@Override
	public ApiResponse deletePostFromTag(DeleteTagPostDTO dto) {
		Tag tag = tagDao.findById(dto.getTagId()).orElseThrow(()-> new ApiException("Invalid Tag Id"));
		BlogPost post = blogPostDao.findById(dto.getPostId()).orElseThrow(()-> new ApiException("Invalid Post Id"));
		tag.getPosts().remove(post);
		return new ApiResponse("Post Deleted from Tag");
	}
}
