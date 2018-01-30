package com.jigsaw.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jigsaw.mybatis.bean.Person;
import com.jigsaw.mybatis.dao.PersonDao;

@Service
@Transactional
public class PersonService {
	@Autowired
	public PersonDao personDao;

	public Person selectPersonById(int id) {
		return personDao.selectPersonById(id);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
