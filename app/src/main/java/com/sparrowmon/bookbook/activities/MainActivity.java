package com.sparrowmon.bookbook.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.sparrowmon.bookbook.R;
import com.sparrowmon.bookbook.adapters.BannerSliderAdapter;
import com.sparrowmon.bookbook.adapters.BookListAdapter;
import com.sparrowmon.bookbook.adapters.SliderAdapter;
import com.sparrowmon.bookbook.network.responses.Book;
import com.sparrowmon.bookbook.network.responses.BookList;
import com.sparrowmon.bookbook.utilities.JsonReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ss.com.bannerslider.Slider;

public class MainActivity extends AppCompatActivity {
    private Slider slider;
    private BannerSliderAdapter sliderApater;
    private  Integer[] IMAGES = {R.drawable.slider_image1,R.drawable.sliderimage2,R.drawable.sliderimage3};
    private ArrayList<Integer> ImagesArray = new ArrayList<>();
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private  BookListAdapter bookListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        slider = findViewById(R.id.banner_slider);
        //setSliderImage();
        slider.setAdapter(new BannerSliderAdapter());

        recyclerView = findViewById(R.id.rv);
        bookListAdapter = new BookListAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(bookListAdapter);


        BookList bookList=JsonReader.readJson(getApplicationContext());

        HashMap<Integer, List<Book>> hashMap = new HashMap<>();
        for(Book book : bookList.getBookArrayList())
        {
            int categoryId = book.getCategory();
            if(hashMap.containsKey(categoryId))
            {
                hashMap.get(categoryId).add(book);
            }
            else
            {
                List<Book> bookList1 = new ArrayList<>();
                bookList1.add(book);
                hashMap.put(categoryId,bookList1);


            }
        }
        Log.e("Mainacgtivity","Main");
        bookListAdapter.setBookList(hashMap);



    }


   /* private void setSliderImage() {

        for(int i=0;i<IMAGES.length;i++)
        {
            ImagesArray.add(IMAGES[i]);


        }
       // sliderApater = new SliderAdapter(ImagesArray);
        slider.setAdapter(sliderApater);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
