package com.example.library5;

import java.util.ArrayList;

public class DataBase {

    private static DataBase instance;
    public static DataBase getInstance(){
        if(instance == null){
            instance = new DataBase();
            return instance;
        }
        else {
            return instance;
        }
    }
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> readBooks;
    private static ArrayList<Book> notReadBooks;

    private DataBase(){
        if(allBooks == null){
            allBooks = new ArrayList<>();
            allBooks.add(new Book(1,"7734","Sabaton",750,"Hell!","https://www.rockreport.be/files/albums/2021/a28c63a8-5026-4791-b2a6-3b755ea4bbc6.jpg"));
            allBooks.add(new Book(2,"Live tour","HammerFall",120,"Live tour!","https://m.media-amazon.com/images/I/81WZjGfH0SL._SL1500_.jpg"));
            allBooks.add(new Book(3,"Glory to the brave","HammerFall_new album",500,"HammerFall!!!","https://cdns-images.dzcdn.net/images/cover/a0eb6c14a8c75395c1c08c338c33d853/264x264.jpg"));
        }
        if(readBooks == null){
            readBooks = new ArrayList<>();
        }
        if (notReadBooks == null){
            notReadBooks = new ArrayList<>();
        }
    }


    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getReadBooks() {
        return readBooks;
    }

    public static ArrayList<Book> getNotReadBooks() {
        return notReadBooks;
    }

    public Book getBookByID(int ID){
        for(Book b:allBooks){
            if(b.getID() == ID){
                return b;
            }
        }
        return null;
    }
    public boolean AddToRead(Book book){
        return readBooks.add(book);
    }
    public boolean AddToNotRead(Book book){
        return notReadBooks.add(book);
    }
    public boolean removeFromRead(Book book){
        return readBooks.remove(book);
    }
    public boolean removeFromNotRead(Book book){
        return notReadBooks.remove(book);
    }
}
