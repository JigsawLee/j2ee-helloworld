package com.jigsaw.mybatis.dao;

import java.util.List;

import com.jigsaw.mybatis.MyBatisDao;
import com.jigsaw.mybatis.bean.Comment;
import com.jigsaw.mybatis.bean.Person;
@MyBatisDao
public interface CommentDao {
	List<Comment> selectCommentByContent(String key);
	List<Comment> selectComment(Comment comment);
	List<Comment> selectComment4TestWhere(Comment comment);
	List<Comment> selectComment4TestOverrideWhere(Comment comment);
	void updateComment(Comment comment);
}
