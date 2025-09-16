package com.green.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.green.dto.Comments;

// JpaRepository : CrudRepository + PagingAndSortingRepostitory
@Repository
public interface CommentsRepository 
	extends  JpaRepository<Comments, Long>  {

	
	
}
