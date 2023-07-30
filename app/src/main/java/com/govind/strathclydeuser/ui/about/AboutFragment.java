package com.govind.strathclydeuser.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.govind.strathclydeuser.R;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {
    private ViewPager viewPager;
    private ClassAdapter adapter;
    private List<ClassesModel> list;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new ClassesModel(R.drawable.logo,"Engineering", "Our Engineering submission, which included the research of seven departments from the Faculty, has the joint highest impact quality profile in Scotland and joint highest environment quality profile in Scotland, based on GPA as calculated by THE. Our Architecture, Built Environment and Planning submission was rated 100% ‘outstanding’ for impact and was the only submission in the unit to achieve this."));
        list.add(new ClassesModel(R.drawable.logo,"Humanities & Social Sciences", "Flexible learning options and dynamic, practice-led courses from across the humanities and social sciences."));
        list.add(new ClassesModel(R.drawable.logo,"Science", "Read about the amazing Strathclyde Women in Science who are all working towards different goals and achievements across the sector."));
        list.add(new ClassesModel(R.drawable.logo,"Strathclyde Business School", "Find out what we offer, how to apply, international exchange, and our innovative Management Development Programme."));


        adapter = new ClassAdapter(getContext(), list);

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);


           Glide.with(getContext())
                   .load("https://firebasestorage.googleapis.com/v0/b/strathclyde-97a51.appspot.com/o/home%2Fglasgow6.jpeg?alt=media&token=3cd1da3f-c4f4-40e2-8023-8fa906ddf30d")
                   .into(imageView);



        return view;
    }
}
