package com.example.library5;

public class Book {

    private int ID;
    private String BookName;
    private String Author;
    private int Pages;
    private String Description;
    private boolean isExpanded;
    private String imageURL;

    public Book(int ID, String bookName, String author, int pages, String description, String imageURL) {
        this.ID = ID;
        BookName = bookName;
        Author = author;
        Pages = pages;
        Description = description;
        isExpanded = false;
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getPages() {
        return Pages;
    }

    public void setPages(int pages) {
        Pages = pages;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID=" + ID +
                ", BookName='" + BookName + '\'' +
                ", Author='" + Author + '\'' +
                ", Pages=" + Pages +
                ", Description='" + Description + '\'' +
                '}';
    }
}
