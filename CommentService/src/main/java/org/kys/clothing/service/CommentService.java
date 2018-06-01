package org.kys.clothing.service;

import org.kys.clothing.comment.CommentBean;
import org.kys.clothing.dateQuery.CommentDataQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentDataQuery commentDataQuery;

    public boolean addComment(CommentBean commentBean) {
        commentBean.setAddTime(String.valueOf(new Date().getTime()));
        commentBean.setStatus(1);
        int a = commentDataQuery.addComment(commentBean);
        return a > 0 ? true : false;
    }

    public List<CommentBean> findCommentBysku(String sku) {
        return commentDataQuery.findCommentBysku(sku);
    }
}