package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entities.Comment;

public interface CommentsDao extends JpaRepository<Comment, Long> {
	@Query("delete from Comment c where c.id = :id ") @Modifying
	Integer deleteCommentsByid(Long id);
}
