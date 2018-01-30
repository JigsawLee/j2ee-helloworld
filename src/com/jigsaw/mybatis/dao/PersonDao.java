package com.jigsaw.mybatis.dao;

import com.jigsaw.mybatis.MyBatisDao;
import com.jigsaw.mybatis.bean.Person;

@MyBatisDao
public interface PersonDao {
	Person selectPersonById(int id);

	Person selectPerson(Person person);

	Person selectPersonByAddress(String address);

	void insertPerson(Person person);

	void updatePerson(Person person);

	void deletePerson(Person person);
}
