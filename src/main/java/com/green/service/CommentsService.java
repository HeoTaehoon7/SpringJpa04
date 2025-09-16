package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.dto.Comments;
import com.green.repository.CommentsRepository;

@Service
public class CommentsService {

	@Autowired
	private  CommentsRepository  commentsRepository;
	
	public List<Comments> getComments(Long id) {
		// List<Comments>  comments = commentsRepository.find
		return null;
	}
	
}









