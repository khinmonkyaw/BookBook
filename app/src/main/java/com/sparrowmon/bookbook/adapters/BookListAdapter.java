package com.sparrowmon.bookbook.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sparrowmon.bookbook.R;
import com.sparrowmon.bookbook.network.responses.Book;
import com.sparrowmon.bookbook.network.responses.BookList;
import com.sparrowmon.bookbook.utilities.MyanmarSarUtil;
import com.sparrowmon.bookbook.views.viewholders.BookListViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookListAdapter extends RecyclerView.Adapter<BookListViewHolder> {

    private HashMap<Integer, List<Book>> bookList;
    private List<Book> bookArrayList;

    public BookListAdapter() {
        bookList = new HashMap<>();
        bookArrayList = new ArrayList<>();
    }

    @NonNull
    @Override
    public BookListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.view_holder_book_list, viewGroup, false);
        return new BookListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookListViewHolder bookListViewHolder, int i) {

        TextView tvCategory = bookListViewHolder.itemView.findViewById(R.id.tv_category);
        RecyclerView recyclerView = bookListViewHolder.itemView.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(bookListViewHolder.itemView.getContext()
                , LinearLayoutManager.HORIZONTAL, false));

        BookAdapter bookAdapter = new BookAdapter();
        bookArrayList=bookList.get(i+1);
        recyclerView.setAdapter(bookAdapter);
        bookAdapter.setBookList(bookArrayList);

        tvCategory.setText(MyanmarSarUtil.convertToUserFont(bookArrayList.get(0).getCategoryName(),tvCategory.getContext()));

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }


    public void setBookList(HashMap<Integer, List<Book>> bookList) {
        this.bookList = bookList;
        notifyDataSetChanged();
    }
}
