package com.sparrowmon.bookbook.adapters;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sparrowmon.bookbook.R;

import java.util.ArrayList;

public class SliderAdapter extends PagerAdapter {


   // private Integer Images = {R.drawable.slider_image1,R.drawable.sliderimage2,R.drawable.sliderimage3};

    private  Context context;
    private ArrayList<Integer> IMAGES;

    public SliderAdapter(ArrayList<Integer>IMAGES)
    {
            this.IMAGES=IMAGES;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater=LayoutInflater.from(container.getContext());
        View itemView= inflater.inflate(R.layout.view_item_slider,container,false);

        ImageView sliderImageView = itemView.findViewById(R.id.iv_slider);


        sliderImageView.setImageResource(IMAGES.get(position));


        /*switch (position){
            case 0:sliderImageView.setImageResource(R.drawable.slider_image1);
            break;
            case 1:sliderImageView.setImageResource(R.drawable.sliderimage2);
            break;
            case 2:sliderImageView.setImageResource(R.drawable.sliderimage3);
            break;
        }*/
        container.addView(itemView);


        return itemView;

    }


}
