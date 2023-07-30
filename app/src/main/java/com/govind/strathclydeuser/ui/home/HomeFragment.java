package com.govind.strathclydeuser.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.govind.strathclydeuser.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;


public class HomeFragment extends Fragment {
    private SliderLayout sliderLayout;
    private ImageView map;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(1);



        setSliderView();

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });



        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=16 Richmond St, Glasgow G1 1XQ, United Kingdom");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderView() {
        for (int i = 0; i< 6; i++){
            DefaultSliderView sliderView = new DefaultSliderView(getContext());

            switch (i){
                case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/strathclyde-97a51.appspot.com/o/home%2Fglasgow6.jpeg?alt=media&token=3cd1da3f-c4f4-40e2-8023-8fa906ddf30d");
                    break;
                 case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/strathclyde-97a51.appspot.com/o/home%2Fglasgow5.jpeg?alt=media&token=dcf93627-24eb-414a-a01f-7a96afbb2d4a");
                    break;
                 case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/strathclyde-97a51.appspot.com/o/home%2Fglasgow4.jpeg?alt=media&token=d92fd2bd-1614-4b3a-b1ed-094148e18a6c");
                    break;
                 case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/strathclyde-97a51.appspot.com/o/home%2Fglasgow3.jpeg?alt=media&token=3f62aad9-5cff-4be5-a101-2316116f6177");
                    break;
                 case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/strathclyde-97a51.appspot.com/o/home%2Fglasgow2.jpeg?alt=media&token=0e2d0786-ea3e-4b63-97f3-5ef48edbd9cb");
                    break;
                case 5:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/strathclyde-97a51.appspot.com/o/home%2Fglasgow1.jpeg?alt=media&token=f6920bda-f6f5-42df-877c-254050bf055d");
                    break;


            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView);

        }
    }
}