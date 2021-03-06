package com.example.appsellcake.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.appsellcake.R;
import com.example.appsellcake.entity.CakeEntity;
import com.example.appsellcake.entity.ListCakeEntity;
import com.example.appsellcake.gui.DetailCake;

import java.util.ArrayList;
import java.util.List;

public class ListCakeAdapter extends BaseAdapter {
    Context context;
    int layout;
//    private List<CakeEntity> listCake;
   private List<ListCakeEntity> listCakeEntities;

    public ListCakeAdapter(Context context, int layout, ArrayList<ListCakeEntity> listCakeEntities) {
        this.context = context;
        this.layout = layout;
        this.listCakeEntities = listCakeEntities;
    }

    @Override
    public int getCount() {
        return listCakeEntities.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHolder {
        TextView txtName, txtGia;
        ImageView hinh;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();

            viewHolder.txtName = view.findViewById(R.id.txtName);
            viewHolder.txtGia = view.findViewById(R.id.txtGia);
            viewHolder.hinh = view.findViewById(R.id.img);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.txtName.setText(listCakeEntities.get(i).tenBanh);
        viewHolder.txtGia.setText(listCakeEntities.get(i).donGia);
        Glide.with(context)
                .load(listCakeEntities.get(i).hinhAnh)
                .into(viewHolder.hinh);

        ListCakeEntity cakeEntity = listCakeEntities.get(i);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(context, DetailCake.class);
                Bundle bundle = new Bundle();
                bundle.putString("imgDetail", cakeEntity.hinhAnh);
                bundle.putString("name",cakeEntity.tenBanh);
                bundle.putString("price",cakeEntity.donGia);
                bundle.putString("detail",cakeEntity.chiTiet);

                in.putExtras(bundle);
                context.startActivity(in);
            }
        });

        return view;
    }
}
