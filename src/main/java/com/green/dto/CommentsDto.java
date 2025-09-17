package com.green.dto;

import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.green.entity.Comments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentsDto {
	private  Long     id;            // 댓글 id
	
	// json 속성명 article_id 명시적으로 지정 
	@JsonProperty("article_id")      // json(article_id) -> articleId
	private  Long     articleId;     // article 의 부모글 id 
	
	private  String   nickname;      // 닉네임
	private  String   body;          // 댓글 본문
	
	// CommentsDto <- Comments (db 조회한 )
	public   static   CommentsDto
	    createCommentDto(  Comments  comments ) {
		return  new CommentsDto (
			comments.getId(),
			comments.getArticle().getId(),
			comments.getNickname(),
			comments.getBody()
		);
	}		
}
