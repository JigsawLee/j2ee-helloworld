package com.jigsaw.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.jigsaw.mybatis.MyBatisDao;
import com.jigsaw.mybatis.bean.Person;

public interface PersonDao {
	Person selectPersonById(int id);

	Person selectPerson(Person person);

	Person selectPersonByAddress(String address);

	void insertPerson(Person person);

	void updatePerson(Person person);

	void deletePerson(Person person);
}
