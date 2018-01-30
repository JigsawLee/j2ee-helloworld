package com.jigsaw.mybatis.dao;

import java.util.List;

public interface BaseDao<T> {

	void insert(T t);

	void delete(T t);

	void update(T t);

	List<T> list(int page, int pageCount);

	T get(T t);

}
