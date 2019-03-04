package com.sparrowmon.bookbook.adapters;

import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class BannerSliderAdapter extends SliderAdapter {
    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder viewHolder) {

        switch (position) {
            case 0:
                viewHolder.bindImageSlide("https://dtl6rju7yddm5.cloudfront.net/wunzin/assets/comics/slider/cartoon_slider1.jpg");
                break;
            case 1:
                viewHolder.bindImageSlide("https://dtl6rju7yddm5.cloudfront.net/wunzin/assets/comics/slider/cartoon_slider2.jpg");
                break;
            case 2:
                viewHolder.bindImageSlide("http://madagascar.dreamworks.com/images/uploads/properties/mad_3_gallery_07.jpg");
                break;
        }
    }
}
