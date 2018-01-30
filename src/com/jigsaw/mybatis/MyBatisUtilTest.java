package com.jigsaw.mybatis;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Properties;

import javax.swing.undo.AbstractUndoableEdit;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jigsaw.mybatis.bean.Article;
import com.jigsaw.mybatis.bean.Author;
import com.jigsaw.mybatis.bean.Comment;
import com.jigsaw.mybatis.bean.Person;
import com.jigsaw.mybatis.dao.ArticleDao;
import com.jigsaw.mybatis.dao.CommentDao;
import com.jigsaw.mybatis.dao.PersonDao;
import com.sun.org.apache.xml.internal.security.Init;

import oracle.jrockit.jfr.tools.ConCatRepository;

public class MyBatisUtilTest {
	private static SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;

	@BeforeClass
	public static void init() {
		sqlSessionFactory = MyBatisUtil.getSqlSsessionFactory();
		// Properties pps = System.getProperties();
		// pps.list(System.out);
	}

	@Before
	public void before() {
		sqlSession = sqlSessionFactory.openSession(true);
	}

	@After
	public void After() {
		sqlSession.close();
	}

	@Test
	public void testGetSqlSsessionFactory() {
		assertNotNull(sqlSessionFactory);
	}

	@Test
	public void testInsert() {

		PersonDao dao = sqlSession.getMapper(PersonDao.class);

		Person person = new Person(1111, "青岛address", "青岛city");
		dao.insertPerson(person);

		Person person2 = dao.selectPersonByAddress(person.getAddress());
		assertNotNull(person2);

		dao.deletePerson(person2);

	}

	@Test
	public void testUpdate() {
		sqlSession = sqlSessionFactory.openSession();
		PersonDao dao = sqlSession.getMapper(PersonDao.class);
		Person person = new Person(1, "address1", "city");
		dao.updatePerson(person);
		Person p = dao.selectPersonById(1);

		assertEquals(person.getAddress(), p.getAddress());
	}

	@Test
	public void testArticle() {
		Person article = sqlSession.selectOne("selectPersonById", 1);
		assertNotNull(article);
		ArticleDao dao = sqlSession.getMapper(ArticleDao.class);
		Article a = dao.selectArticle(11);
		assertNotNull(a);
		ThreadLocal<String> local;
		System.out.println(a.toString());
	}

	@Test
	public void testComment() {
		List<Comment> list = sqlSession.getMapper(CommentDao.class).selectCommentByContent("评论");
		// Comment comment = new Comment();
		// comment.setArticle(getArticle());
		// comment.setAuthor(getAuthor());
		// List<Comment> list =
		// sqlSession.getMapper(CommentDao.class).selectComment4TestOverrideWhere(comment);

		System.out.println("test comment :" + list.toString());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " " + list.get(i).getContent());
		}

	}

	@Test
	public void testUpdateComment() {
		System.out.println("test update comment");
		CommentDao dao = sqlSession.getMapper(CommentDao.class);
		Comment comment = new Comment();
		comment.setId(111);
		List<Comment> resultComment = dao.selectComment(comment);
		System.out.println("修改前-->" + resultComment.get(0).getContent());

		comment.setContent("修改后" + resultComment.get(0).getContent().replaceAll("修改后", ""));
		dao.updateComment(comment);
		List<Comment> resultComment2 = dao.selectComment(comment);
		System.out.println("修改后-->" + resultComment2.get(0).getContent());
	}

	public Article getArticle() {
		Article article = new Article();
		article.setId(11);
		return article;
	}

	public Author getAuthor() {
		Author author = new Author();
		author.setId(1);
		return author;
	}
}
