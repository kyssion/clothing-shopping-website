package org.kys.clothing.controller;

import org.kys.clothing.comment.CommentBean;
import org.kys.clothing.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;
    @RequestMapping(value = "add_comment",method = RequestMethod.POST)
    public boolean addComment(@RequestBody CommentBean commentBean){
        return commentService.addComment(commentBean);
    }

    @RequestMapping("find_comment")
    public List<CommentBean> getCommentBysku(@RequestParam("sku")String sku){
        return commentService.findCommentBysku(sku);
    }
}
