package com.zuicoding.platform.comment.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zuicoding.platform.comment.dao.CommentMapper;
import com.zuicoding.platform.comment.dict.BusinessCode;
import com.zuicoding.platform.comment.exception.BusinessException;
import com.zuicoding.platform.comment.module.Comment;
import com.zuicoding.platform.comment.service.ICommentService;

/**
 * Created by <a href="mailto:stephen_linicoding@163.com">Stepen.lin</a> on 2018/1/8.
 * <p>
 * <p>
 * </p>
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    public List<Comment> list(int endId,int pageSize,Comment comment){
        if (endId < 0 || pageSize <= 0){
            throw new IllegalArgumentException("endId or pageSize is bad params");
        }

        return null;

    }



    /**
     * 添加或修改
     * @param comment
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdate(Comment comment){
        if (comment == null) throw new IllegalArgumentException("comment == null");
        if (StringUtils.isBlank(comment.getNikeName())){
            throw new BusinessException(BusinessCode.NIKENAME_ISEMPTY);
        }
        if (StringUtils.isBlank(comment.getEmail())){
            throw new BusinessException(BusinessCode.EMAIL_ISEMPTY);
        }
        if (StringUtils.isBlank(comment.getContent())){
            throw new BusinessException(BusinessCode.CONTEXT_ISEMPTY);
        }
        if (comment.getId() == null || comment.getId() <= 0){
            comment.setModifyTime(new Date());
            return commentMapper.insertSelective(comment) > 0 ;
        }

        comment.setCreateTime(new Date());
        return commentMapper.updateByPrimaryKeySelective(comment) > 0 ;
    }

}
