package webprojectday09a;

import java.util.ArrayList;
import java.util.List;

public class BookAuthorExample {

	public static void main(String[] args)
	{
	GenericDao dao = new GenericDao();
	
	/*
	Author author = new Author();
	
	author.setName("Sam harris");
	author.setEmail("Sam@gmail.com");
	dao.save(author);
	
	Book book = new Book();
	
	book.setName("Wake UP!");
	book.setCost(2500);
	
	List<Author> authors = new ArrayList<Author>();
	
	authors.add((Author)dao.fetchById(Author.class, 1));
	authors.add((Author)dao.fetchById(Author.class, 2));
	
	book.setAuthors(authors);
	
	dao.save(book);
	*/
	
	
	
	
	Book book = new Book();
	book.setName("GOT");
	book.setCost(3500);
	
	dao.save(book);
	
	
	/*
	Book book = (Book) dao.fetchById(Book.class,2);
	
	List<Author> authors = new ArrayList<Author>();
	authors.add((Author)dao.fetchById(Author.class, 1));
	authors.add((Author)dao.fetchById(Author.class, 2));
	
	book.setAuthors(authors);
	dao.save(book);
	*/
	/*
	
	Book book = new Book();
	book.setName("Groovy 2 Cookbook");
	book.setCost(3000);
	
	Author author1 = new Author();
	author1.setName("Andrey Adamovich");
	author1.setEmail("andrey@gmail.com");
	
	Author author2 = new Author();
	author2.setName("Luciano Flandesio");
	author2.setEmail("luciano@gmail.com");
	
	List<Author> list = new ArrayList<>();
	list.add(author1);
	list.add(author2);
	
	book.setAuthors(list);
	
	dao.save(book);
	*/
	
	
	
	}
}
