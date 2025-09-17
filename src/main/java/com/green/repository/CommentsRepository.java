package com.green.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.green.entity.Article;
import com.green.entity.Comments;

// JpaRepository : CrudRepository + PagingAndSortingRepostitory
@Repository
public interface CommentsRepository 
	extends  JpaRepository<Comments, Long>  {

	// 오류 발생시
	// org.springframework.dao.InvalidDataAccessApiUsageException:
	// For queries with named parameters you need to provide names for 
	// method parameters;
	// -> project ->properties -> java compiler ->
	// 최상단 Check  Enable project specific setttingh
	// 최하단 Check  Store infomation about parameters
	
	// @Query : findByArticleId() 힘술 호출하면 
	//      Jpa 기능이 아닌 @Query 안의 sql ( JPQL )을 실행한다
	//   nativeQuery = true  : oracle용 sql 문을 사용
	//   nativeQuery = false : JPQL 문법의 sql 이 작동된다
		
	@Query(
		value="SELECT * FROM COMMENTS WHERE ARTICLE_ID = :articleId"
		, nativeQuery = true)
	List<Comments> findByArticleId(Long articleId);

	// native query xml 
	// src/main/resources/META-INF/orm.xml  // 폴더와 파일을 생성해야한다
	// orm.xml 에 sql 을 저장해서 findByNickname()함수호출
	List<Comments> findByNickname(String nickname); 
	
	// 기본 findById() 를 직접 JPQL로 재정의
    //@Query("select a from Article a where a.id = :id")
    //Optional<Article> findById(@Param("id") Long id);
}







