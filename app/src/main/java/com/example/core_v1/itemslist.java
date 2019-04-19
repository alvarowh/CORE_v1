package com.example.core_v1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.core_v1.entities.item;
import com.example.core_v1.utils.ItemListCustomAdapter;

import java.util.ArrayList;

public class itemslist extends AppCompatActivity {

    ListView lView;
    EditText etext1;

    //generate list
    ArrayList<item> list = new ArrayList<item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemslist);


        //Sample data.
        item new_item =new item("Banana",1);
        list.add(new_item);

        item new_item2 =new item("Milk",1);
        list.add(new_item2);



        refreshlist();
    }

    public void onclick(View view) {


        addtolist();
        refreshlist();

    }

    private void refreshlist() {

        //instantiate custom adapter
        ItemListCustomAdapter adapter = new ItemListCustomAdapter(list, this);

        //handle listview and assign adapter

        lView = (ListView)findViewById(R.id.my_listview);
        lView.setAdapter(adapter);

    }

    private void addtolist() {

        etext1 = (EditText)findViewById(R.id.item_txt);
        String iname = etext1.getText().toString();
        int iqty =1;
        item item1 = new item(iname,iqty);
        //Toast.makeText(getApplicationContext(),item,Toast.LENGTH_SHORT).show();
        /* TD: check if string is empty. */
        list.add(item1);

    }

}
