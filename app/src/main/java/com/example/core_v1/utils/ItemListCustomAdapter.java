package com.example.core_v1.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.core_v1.R;
import com.example.core_v1.entities.item;

import java.util.ArrayList;

public class ItemListCustomAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<item> list = new ArrayList<item>();

    private Context context;


    public ItemListCustomAdapter(ArrayList<item> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
        //just return 0 if your list items do not have an Id variable.
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_list_layout,null);
        }

        //Handle TextView and display string from your list
        TextView listItemText = (TextView)view.findViewById(R.id.list_item_string);
        listItemText.setText(list.get(position).getName());
        TextView item_amount= (TextView) view.findViewById(R.id.item_amount);
        item_amount.setText(Integer.toString(list.get(position).getCuantity()));



        //Handle buttons and add onClickListeners
        Button deleteBtn = (Button)view.findViewById(R.id.delete_btn);
        Button addBtn = (Button)view.findViewById(R.id.add_btn);
        Button removeBtn= (Button)view.findViewById(R.id.remove_btn);



        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                list.remove(position); //or some other task
                notifyDataSetChanged();
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int c_amount= list.get(position).getCuantity();
                int amount=c_amount+1;
                list.get(position).setCuantity(amount);
                notifyDataSetChanged();
            }
        });

        removeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int c_amount= list.get(position).getCuantity();
                int amount=c_amount-1;
                list.get(position).setCuantity(amount);
                notifyDataSetChanged();

            }
        });

        return view;
    }

}

