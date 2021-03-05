package com.sem6_project.mylib.bean;

public class Category {
    String CategoryID;
    String Category_Name, Remark;

    public Category(String CategoryID, String Category_Name, String Remark) {
        this.Category_Name = Category_Name;
        this.CategoryID = CategoryID;
        this.Remark = Remark;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }

    public String getCategory_Name() {
        return Category_Name;
    }

    public void setCategory_Name(String category_Name) {
        Category_Name = category_Name;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }
}
