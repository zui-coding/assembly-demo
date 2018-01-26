package com.zuicoding.platform.comment.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zuicoding.platform.comment.exception.BusinessException;
import com.zuicoding.platform.comment.module.Comment;
import com.zuicoding.platform.comment.module.Response;
import com.zuicoding.platform.comment.service.ICommentService;


/**
 * Created by <a href="mailto:stephen_linicoding@163.com">Stephen.lin</a> on 2018/1/8.
 * <p>
 * <p>
 * </p>
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    private Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private ICommentService commentService;



    @RequestMapping("/list.json")
    @ResponseBody
    public Response<List<Comment>> list(Integer endId,int pageSize) {
        Response<List<Comment>> response = null;
        try {
            response = Response.success();
            if (endId == null || endId < 0){
                endId = 0;
            }
            List list = commentService.list(endId,pageSize,null);
            response = Response.success(list);
        }catch (BusinessException be) {
            logger.warn("",be.getErrorMsg());
            response = Response.fail(be);
        }catch (Exception e) {
            logger.error("查询评论失败",e);
            response = Response.fail("系统错误");
        }

        return response;

    }

    @RequestMapping("/add.json")
    @ResponseBody
    public Response comment(String nikeName,
                            String email,
                            String content) {
        Response response = null;
        try {
            Comment comment = new Comment();
            comment.setContent(content);
            comment.setEmail(email);
            comment.setNikeName(nikeName);
            boolean r = commentService.saveOrUpdate(comment);
            if (r){
                response  = Response.success(r);
                response.setResult("评论成功!");
                return response;
            }
            response  = Response.fail(r);
            response.setResult("评论失败!");
        }catch (BusinessException be){
            response = Response.fail(be.getErrorMsg());
            logger.warn("",be.getMessage());
        }catch (Exception e){
            logger.error("添加评论失败",e);
            response = Response.fail("系统错误");
        }

        return response;
    }

}
