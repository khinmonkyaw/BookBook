package com.sparrowmon.bookbook.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sparrowmon.bookbook.R;
import com.sparrowmon.bookbook.network.responses.Book;
import com.sparrowmon.bookbook.utilities.MyanmarSarUtil;
import com.sparrowmon.bookbook.views.viewholders.BookViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder> {


    private List<Book> bookList;

    public BookAdapter() {

        bookList = new ArrayList<Book>();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.view_holder_book, viewGroup, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder bookViewHolder, int i) {
        ImageView ivBook = bookViewHolder.itemView.findViewById(R.id.iv_book);
        TextView tvBookName = bookViewHolder.itemView.findViewById(R.id.tv_book_name);
        TextView tvBookPrice = bookViewHolder.itemView.findViewById(R.id.tv_book_price);

        Picasso.with(ivBook.getContext())
                .load(bookList.get(i).getCoverUrl())
                .placeholder(R.drawable.loading)
                .into(ivBook);

        tvBookPrice.setText(bookList.get(i).getBookPrice() + "");

        String bookName = MyanmarSarUtil.convertToUserFont(bookList.get(i).getBookName(), tvBookName.getContext());
        tvBookName.setText(bookName); // change font


    }

    @Override
    public int getItemCount() {
        return (bookList == null ? 0 : bookList.size());
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
        notifyDataSetChanged();
    }
}
