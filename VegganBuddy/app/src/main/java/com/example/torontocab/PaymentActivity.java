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

public class PaymentActivity extends AppCompatActivity {

    EditText txtCard, txtExpirationDate;
    Button btnAdd;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        txtCard = (EditText)findViewById(R.id.txtCard);
        txtExpirationDate = (EditText)findViewById(R.id.txtExpirationDate);
        btnAdd = (Button)findViewById(R.id.btnAdd);

        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
    }


    public  void addUser() {
        String cardNumber = txtCard.getText().toString();
        String expirationDate = txtExpirationDate.getText().toString();

        if(!TextUtils.isEmpty(cardNumber) && !TextUtils.isEmpty(expirationDate)){
            String id =   databaseReference.push().getKey();

            User user = new User(id,cardNumber,expirationDate);

            databaseReference.child(id).setValue(user);
            Log.i(cardNumber,id);


            Toast.makeText(this, "User Payment Added",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"You can not leave the field empty",Toast.LENGTH_LONG).show();
        }



    }

}
