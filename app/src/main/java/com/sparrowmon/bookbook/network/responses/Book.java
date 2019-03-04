package com.sparrowmon.bookbook.network.responses;

import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("book_name")
    private String bookName;
    @SerializedName("book_price")
    private int bookPrice;
    @SerializedName("cat_id")
    private int category;
    @SerializedName("cover_url")
    private String coverUrl;

    @SerializedName("category_name")
    private String categoryName;


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


}
