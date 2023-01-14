package com.fastcampus.projectboard.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @WebMvcTest가 적용되지 않는 이유는 WebMvcTest는 Slice 테스트이다.
 * Controller 이외의 빈들을 로드하지 않는다.
 * @SpringBootTest 는 Integration Test이다.
 * @AutoCOnfigureMockMvc 는 MockMvc의 존재를 알수 없으므로 추가
 * @Transactional 을 넣으면 기본동작은 롤백이다. 따라서 DB에 영향을 안주고 테스트할 수 있다.
 */
@Transactional
@DisplayName("Data Rest 테스트")
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {

    private final MockMvc mvc;

    public DataRestTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }


    @DisplayName("[api] 게시글 리스트 조회")
    @Test
    void givenNothing_whenRequestArticles_thenReturnsArticlesJsonResponse() throws Exception {
        // given

        // when & then
        mvc.perform(get("/api/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
        ;

    }

    @DisplayName("[api] 게시글 단건 조회")
    @Test
    void givenNothing_whenRequestArticle_thenReturnsArticlesJsonResponse() throws Exception {
        // given

        // when & then
        mvc.perform(get("/api/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
        ;

    }


    @DisplayName("[api] 게시글 -> 댓글 리스트 조회")
    @Test
    void givenNothing_whenRequestArticleCommentsFromArticle_thenReturnsArticlesCommentsJsonResponse() throws Exception {
        // given

        // when & then
        mvc.perform(get("/api/articles/1/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
        ;

    }

    @DisplayName("[api] 댓글 리스트 조회")
    @Test
    void givenNothing_whenRequestArticleComments_thenReturnsArticlesCommentsJsonResponse() throws Exception {
        // given

        // when & then
        mvc.perform(get("/api/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
        ;

    }


    @DisplayName("[api] 댓글 단건 조회")
    @Test
    void givenNothing_whenRequestArticleComment_thenReturnsArticlesCommentJsonResponse() throws Exception {
        // given

        // when & then
        mvc.perform(get("/api/articleComments/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
        ;

    }
}
