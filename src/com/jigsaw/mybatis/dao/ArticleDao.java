package com.jigsaw.mybatis.dao;

import java.util.List;

import com.jigsaw.mybatis.MyBatisDao;
import com.jigsaw.mybatis.bean.Article;
import com.jigsaw.mybatis.bean.Person;
@MyBatisDao
public interface ArticleDao {
	Article selectArticle(int id);
}
