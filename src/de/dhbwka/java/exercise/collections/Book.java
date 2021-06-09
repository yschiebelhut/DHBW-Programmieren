package de.dhbwka.java.exercise.collections;

import java.util.Objects;

/**
 * @author Yannik Schiebelhut
 */
public class Book {
	private String title;
	private String author;
	private int year;
	private String publisher;

	public Book(String title, String author, int year, String publisher) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.publisher = publisher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return title + ';' + author + ';' + year + ';' + publisher;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(publisher, book.publisher);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, author, year, publisher);
	}
}
