package PB02_Library;

import java.util.Iterator;

public class Library implements Iterable<Book>{
    private Book[] books;

    public Library(Book... books) {
        //нова библиотека
        this.books = books;
    }


    @Override
    public Iterator<Book> iterator() {
        return null;
    }

   private class LibIterator implements Iterator<Book>{
       int count = 0;

       @Override
       public boolean hasNext() {

           return count< books.length;
       }

       @Override
       public Book next() {
           return books[count++];
       }
   }
}

