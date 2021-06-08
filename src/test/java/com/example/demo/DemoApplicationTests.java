package com.example.demo;


import com.example.demo.entity.Post;
import com.example.demo.entity.Reply;
import com.example.demo.repo.PostRepo;
import com.example.demo.repo.ReplyRepo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DemoApplicationTests {

    Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

    private final PostRepo postRepo;

    private final ReplyRepo replyRepo;

    @Autowired
    DemoApplicationTests(PostRepo postRepo, ReplyRepo replyRepo) {
        this.postRepo = postRepo;
        this.replyRepo = replyRepo;
    }

    @Test
    @Transactional
    void getIssue() {
        System.out.println("TEST1");
    }

    @Test
    @Transactional
    void getFetchJoin() {
        List<Post> postList = postRepo.findAllFetchJoin();
        List<Post> postDistinctList = postRepo.findAllDistinctFetchJoin();
        List<Post> postEntityGraphList = postRepo.findTest();
        log.info("END");
    }

    @Test
    @Transactional
    @Rollback(false)
    void contextLoads() {

        List <Post> list= postRepo.findAllFetchJoin();

        System.out.println("tes");
        /*for (Post post : postRepo.findAll()) {
            post.getReplyList();
        }*/
    }

}
