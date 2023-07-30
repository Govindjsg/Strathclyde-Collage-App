package com.govind.strathclydeuser.ui.about;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.govind.strathclydeuser.R;

import java.util.List;

public class ClassAdapter extends PagerAdapter {
    private Context context;
    private List<ClassesModel>list;

    public ClassAdapter(Context context, List<ClassesModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.class_item_layout, container, false);

        ImageView cls_icon;
        TextView cls_title, cls_desc;

        cls_icon = view.findViewById(R.id.cls_icon);
        cls_title = view.findViewById(R.id.cls_title);
        cls_desc = view.findViewById(R.id.cls_desc);

        cls_icon.setImageResource(list.get(position).getImg());

        cls_title.setText(list.get(position).getTitle());
        cls_desc.setText(list.get(position).getDescription());

        container.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
