package com.zuicoding.platform.comment.service;

import java.util.List;

import com.zuicoding.platform.comment.module.Comment;

/**
 * Created by <a href="mailto:stephen_linicoding@163.com">Stephen.lin</a> on 2018/1/8.
 * <p>
 * <p>
 * </p>
 */
public interface ICommentService {
    List<Comment> list(int endId, int pageSize, Comment comment);
    boolean saveOrUpdate(Comment comment);
}
