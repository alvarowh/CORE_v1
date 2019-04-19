package com.example.core_v1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.core_v1.entities.user;
import com.example.core_v1.utils.AutoLoader;


import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    EditText fieldname,fieldpass;
    //Create HashMap for users.
    HashMap<Integer, user> mapUsers = new HashMap<Integer,user>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create and call autoloader to load users into the hasmap mapUsers.
        AutoLoader my_autoloader = new AutoLoader();
        my_autoloader.autouserload(mapUsers);

        fieldname= (EditText)findViewById(R.id.user_name);
        fieldpass=(EditText)findViewById(R.id.user_pass);

    }

    public void event(View view) {
        switch (view.getId()) {

            case R.id.btn_login:
                loginuser();
                break;

            case R.id.btn_register:
                registeruser();
                break;
        }
    }

    private void loginuser() {
        String log_name= fieldname.getText().toString();
        String log_pass= fieldpass.getText().toString();
        checkuser(log_name,log_pass);

    }

        private void checkuser(String log_name,String log_pass) {
            String result=null;
            for (int i = 1; i <= mapUsers.size(); ++i) {
                if (mapUsers.get(i).getName().equals(log_name)) {
                    if (mapUsers.get(i).getPassword().equals(log_pass)) {
                        correctlogin(log_name);
                        result = "Login succesfull";
                    } else result= "Incorrect password";
                break;
                }else result= "User does not exist";
            }
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();


        }

    private void correctlogin(String log_name) {

        Intent intent = new Intent(getApplicationContext(),mainusermenu.class);
        Bundle myBundle=new Bundle();
        myBundle.putString("name",log_name);
        intent.putExtras(myBundle);
        startActivity(intent);

    }

    private void registeruser() {
        String message;
        String log_name= fieldname.getText().toString();
        String log_pass= fieldpass.getText().toString();

        if ((log_pass.length()>=4) && (log_name.length()>=2))  {
            AutoLoader my_autoloader = new AutoLoader();
            my_autoloader.userload(mapUsers, log_name, log_pass);
                 message = log_name + "registered";
        } else {
            if (log_pass.length()>=4) {
                 message = "Name must have at least 2 characters.";
            }else {
                 message = "Password must have at least 4 characters";
            }
        }
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
