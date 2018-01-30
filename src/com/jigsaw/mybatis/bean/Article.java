package com.jigsaw.mybatis.bean;

import java.util.List;

public class Article {
	private int id;
	private String title;
	private String content;
	private Author author;
	private List<Comment> comments;

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	private String createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("title=" + this.title);
		stringBuffer.append("\n");
		stringBuffer.append("author name=" + this.author.getUsername());
		stringBuffer.append("\n");
		if (null != this.comments && this.comments.size() > 0) {
			stringBuffer.append("comments:");
			stringBuffer.append("\n");
			for (int i = 0, count = this.comments.size(); i < count; i++) {
				stringBuffer.append(this.comments.get(i).getContent());
				stringBuffer.append("\n");
			}
		}
		return stringBuffer.toString();
	}
}
