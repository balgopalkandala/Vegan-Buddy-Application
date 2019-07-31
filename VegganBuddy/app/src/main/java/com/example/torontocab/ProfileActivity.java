package com.example.torontocab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {

    EditText txtFirst,txtLast;
    Button btnSave;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtFirst = (EditText)findViewById(R.id.txtFirst);
        txtLast = (EditText)findViewById(R.id.txtLast);
        btnSave = (Button)findViewById(R.id.btnSave);

        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
    }

    public  void addUser() {
        String firstName = txtFirst.getText().toString();
        String lastName = txtLast.getText().toString();

        if(!TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(lastName)){
          String id =   databaseReference.push().getKey();

          User user = new User(id,firstName,lastName);

          databaseReference.child(id).setValue(user);
            Log.i(firstName,id);


          Toast.makeText(this, "User added",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"You can not leave the field empty",Toast.LENGTH_LONG).show();
        }



    }
}
