package com.govind.strathclydeuser.ui.faculty;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.govind.strathclydeuser.R;

import java.util.ArrayList;
import java.util.List;


public class FacultyFragment extends Fragment {

    private RecyclerView engineeringTeacher,humanitiesTeacher, scienceTeacher, businessTeacher,others;
    private LinearLayout engineeringNoData, humanitiesNoData, scienceNoData, businessNoData,   othersNoData;
    private List<TeacherData> list1, list2, list3, list4, list5;
    private TeacherAdapter adapter;
    private DatabaseReference reference, dbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);
        engineeringTeacher = view.findViewById(R.id.engineeringTeacher);
        humanitiesTeacher = view.findViewById(R.id.humanitiesTeacher);
        scienceTeacher = view.findViewById(R.id.scienceTeacher);
        businessTeacher = view.findViewById(R.id.businessTeacher);
        others = view.findViewById(R.id.others);


        engineeringNoData = view.findViewById(R.id.engineeringNoData);
        humanitiesNoData = view.findViewById(R.id.humanitiesNoData);
        scienceNoData = view.findViewById(R.id.scienceNoData);
        businessNoData = view.findViewById(R.id.businessNoData);
        othersNoData = view.findViewById(R.id.othersNoData);


        reference = FirebaseDatabase.getInstance().getReference().child("teacher");


        engineeringTeacher();
        humanitiesTeacher();
        scienceTeacher();
        businessTeacher();
        others();



        return view;

    }



    private void engineeringTeacher() {
        dbRef = reference.child("Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    engineeringNoData.setVisibility(View.VISIBLE);
                    engineeringTeacher.setVisibility(View.GONE);
                }else {
                    engineeringNoData.setVisibility(View.GONE);
                    engineeringTeacher.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    engineeringTeacher.setHasFixedSize(true);
                    engineeringTeacher.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1, getContext());
                    engineeringTeacher.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void humanitiesTeacher() {
        dbRef = reference.child("Humanities and Social Sciences");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    humanitiesNoData.setVisibility(View.VISIBLE);
                    humanitiesTeacher.setVisibility(View.GONE);
                }else {
                    humanitiesNoData.setVisibility(View.GONE);
                    humanitiesTeacher.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    humanitiesTeacher.setHasFixedSize(true);
                    humanitiesTeacher.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2, getContext());
                    humanitiesTeacher.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void scienceTeacher() {
        dbRef = reference.child("Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    scienceNoData.setVisibility(View.VISIBLE);
                    scienceTeacher.setVisibility(View.GONE);
                }else {
                    scienceNoData.setVisibility(View.GONE);
                    scienceTeacher.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    scienceTeacher.setHasFixedSize(true);
                    scienceTeacher.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3, getContext());
                    scienceTeacher.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void businessTeacher() {
        dbRef = reference.child("Strathclyde Business School");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    businessNoData.setVisibility(View.VISIBLE);
                    businessTeacher.setVisibility(View.GONE);
                }else {
                    businessNoData.setVisibility(View.GONE);
                    businessTeacher.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    businessTeacher.setHasFixedSize(true);
                    businessTeacher.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4, getContext());
                    businessTeacher.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void others() {
        dbRef = reference.child("Others");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    othersNoData.setVisibility(View.VISIBLE);
                    others.setVisibility(View.GONE);
                }else {
                    othersNoData.setVisibility(View.GONE);
                    others.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    others.setHasFixedSize(true);
                    others.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5, getContext());
                    others.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}