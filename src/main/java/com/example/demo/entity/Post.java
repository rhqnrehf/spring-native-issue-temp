package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Post {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long postSq;


    @OneToMany(mappedBy = "post")
    List <Reply> replyList;
}
