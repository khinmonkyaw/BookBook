package com.sparrowmon.bookbook.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BookList {

  @SerializedName("book_list")
  private   ArrayList<Book> bookArrayList;

    public ArrayList<Book> getBookArrayList() {
        return bookArrayList;
    }

    public void setBookArrayList(ArrayList<Book> bookArrayList) {
        this.bookArrayList = bookArrayList;
    }
}
