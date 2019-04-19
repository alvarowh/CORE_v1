package com.example.core_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class mainusermenu extends AppCompatActivity {

    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainusermenu);

        msg= findViewById(R.id.welcome);

        Bundle myBundle=this.getIntent().getExtras();

        if (myBundle!=null) {
            String name=myBundle.getString("name");
            msg.setText(name);
        }
    }

    public void event(View view) {
        switch (view.getId()) {
            case R.id.item_list_btn:
                Intent intent = new Intent(this,itemslist.class);
                startActivity(intent);
                break;
        }

    }
}