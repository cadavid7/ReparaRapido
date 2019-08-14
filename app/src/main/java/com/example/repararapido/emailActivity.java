package com.example.repararapido;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.repararapido.Model.Personal;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class emailActivity extends AppCompatActivity {

    TextView personalEmail2;
    EditText etSubject,etMessage;
    Button btSend;

    String menuId2="";
    FirebaseDatabase database2;
    DatabaseReference personal2;

    Personal currentPersonal2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

       /* database2 = FirebaseDatabase.getInstance();
        personal2  = database2.getReference("Personal");
*/

        final EditText personalEmail2 = findViewById(R.id.PersonalEmail2);
        final EditText etSubject = findViewById(R.id.et_subject);
        final EditText  etMessage = findViewById(R.id.et_message);
        btSend = findViewById(R.id.bt_send);

      /*  if(getIntent() != null)
            menuId2 = getIntent().getStringExtra("MenuId");
        if(!menuId2.isEmpty()){

        }*/


        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("mailto:"+personalEmail2.getText().toString()));
                intent.putExtra(Intent.EXTRA_SUBJECT,etSubject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,etMessage.getText().toString());
                startActivity(intent);
            }
        });
    }

   /* private void getDetailPersonal2(String menuId2) {
        personal2.child(menuId2).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                currentPersonal2 = dataSnapshot.getValue(Personal.class);
                personalEmail2.setText(currentPersonal2.getEmail());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }*/
}
