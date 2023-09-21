package com.aop.demo.services;

import com.aop.demo.entities.Comment;

public interface CommentsService {
    String publishComment(Comment comment);

    void deleteComment(Comment comment);

    void updateComment(Comment comment);
}
