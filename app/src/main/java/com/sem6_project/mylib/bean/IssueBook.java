package com.sem6_project.mylib.bean;

public class IssueBook {
    String UserID, IssueBookID, BookID, IssueBookDate, DueDate, BookName;

    public IssueBook(String UserID, String IssueBookID, String BookID, String IssueBookDate, String DueDate, String BookName){
        this.UserID = UserID;
        this.BookID = BookID;
        this.IssueBookID = IssueBookID;
        this.DueDate = DueDate;
        this.IssueBookDate = IssueBookDate;
        this.BookName = BookName;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getIssueBookID() {
        return IssueBookID;
    }

    public void setIssueBookID(String issueBookID) {
        IssueBookID = issueBookID;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }

    public String getIssueBookDate() {
        return IssueBookDate;
    }

    public void setIssueBookDate(String issueBookDate) {
        IssueBookDate = issueBookDate;
    }

    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String dueDate) {
        DueDate = dueDate;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }
}
