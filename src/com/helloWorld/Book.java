package com.helloWorld;

public class Book {
	int isbn;
	String title;

	public Book(int i, String string){
		super();
	}

	public void setIsbn(int isbn){
		this.isbn = isbn;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public int getIsbn(){
		return this.isbn;
	}

	public String getTitle(){
		return this.title;
	}

}
