package com.example.demo.repo;

import com.example.demo.entity.Post;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PostRepo extends JpaRepository<Post, Long> {
    @Query("select p from Post p join fetch p.replyList")
    List <Post> findAllFetchJoin();

    @Query("select distinct p from Post p join fetch p.replyList")
    List <Post> findAllDistinctFetchJoin();

    @EntityGraph(attributePaths = {"replyList"})
    @Query("select p from Post p")
    List<Post> findTest();

    @NotNull
    @EntityGraph(attributePaths = {"replyList"})
    @Override
    List<Post> findAll();
}
