package com.aop.demo.services.impl;

import com.aop.demo.annotations.ToLog;
import com.aop.demo.entities.Comment;
import com.aop.demo.services.CommentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CommentsServiceImpl implements CommentsService {

    private final static Logger LOGGER =
            LoggerFactory.getLogger(CommentsServiceImpl.class);

    @Override
    public String publishComment(Comment comment) {
        LOGGER.info("Publishing comment '" + comment.content() + "' inside the target method.");

        return "SUCCESS";
    }

    @ToLog
    @Override
    public void deleteComment(Comment comment) {
        LOGGER.info("Delete Comment : "+comment.content());
    }

    @Override
    public void updateComment(Comment comment) {
        LOGGER.info("Update Comment : "+comment.content());
    }
}
