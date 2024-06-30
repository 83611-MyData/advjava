package com.sunbeam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.CommentsDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CommentDto;
import com.sunbeam.dto.CommentReqDto;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Comment;
import com.sunbeam.entities.Role;
import com.sunbeam.entities.User;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentsDao commentsDao;
	
	@Autowired
	private BlogPostDao blogPostDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper map;

	@Override
	public CommentDto addComment(CommentDto commentDto) {
			User commenter= userDao.findById(commentDto.getCommenterId()).orElseThrow(()-> new ApiException("Invalid User ID"));
			if(commenter.getRole() != Role.COMMENTER)
				throw new ApiException("Invalid Role");
			BlogPost blogPost = blogPostDao.findById(commentDto.getPostId()).orElseThrow(()-> new ApiException("Invalid Post ID"));
			if(blogPost.getBlogger().getId() == commenter.getId()  )
				throw new ApiException("You can't comment on your own Post");
			Comment comment = map.map(commentDto, Comment.class);
			comment.setCommenter(commenter);
			comment.setPost(blogPost);
			Comment addedComment = commentsDao.save(comment);
			return map.map(addedComment, CommentDto.class);
	}

	@Override
	public CommentDto updateComment(CommentReqDto commentReqDTO) {
		Comment comment = commentsDao.findById(commentReqDTO.getCommentId()).orElseThrow(()->new ApiException("Invalid Comment Id"));
		comment.setCommentText(commentReqDTO.getCommentText());
		return map.map(comment, CommentDto.class);
	}

	@Override
	public ApiResponse deleteComments(Long id) {
		Integer check = commentsDao.deleteCommentsByid(id);
		return new ApiResponse(check+" comments deleted");
	}
	
}
