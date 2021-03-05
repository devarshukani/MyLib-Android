package com.sem6_project.mylib.bean;

public class Book {
    String BookID, BookName, AuthorName, PublicationName, CategoryName, BookPages, BookPrice, BookQuantity, PurchaseDate, RackNumber, Remark;

    public Book(String BookID, String BookName, String AuthorName, String PublicationName, String CategoryName, String BookPages,String BookPrice,String BookQuantity,String PurchaseDate,String RackNumber,String Remark){
        this.BookID = BookID;
        this.BookName = BookName;
        this.AuthorName = AuthorName;
        this.PublicationName = PublicationName;
        this.CategoryName = CategoryName;
        this.BookPages = BookPages;
        this.BookPrice = BookPrice;
        this.BookQuantity = BookQuantity;
        this.PurchaseDate = PurchaseDate;
        this.RackNumber = RackNumber;
        this.Remark = Remark;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public String getPublicationName() {
        return PublicationName;
    }

    public void setPublicationName(String publicationName) {
        PublicationName = publicationName;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getBookPages() {
        return BookPages;
    }

    public void setBookPages(String bookPages) {
        BookPages = bookPages;
    }

    public String getBookPrice() {
        return BookPrice;
    }

    public void setBookPrice(String bookPrice) {
        BookPrice = bookPrice;
    }

    public String getBookQuantity() {
        return BookQuantity;
    }

    public void setBookQuantity(String bookQuantity) {
        BookQuantity = bookQuantity;
    }

    public String getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        PurchaseDate = purchaseDate;
    }

    public String getRackNumber() {
        return RackNumber;
    }

    public void setRackNumber(String rackNumber) {
        RackNumber = rackNumber;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }
}
