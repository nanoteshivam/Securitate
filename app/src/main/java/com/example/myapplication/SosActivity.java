package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.myapplication.data.MyDbHandler;
import com.example.myapplication.model.Contact;
import com.example.myapplication.model.ContactAdapter;
import com.example.myapplication.model.ContactSOSAdapter;
import com.example.myapplication.params.Params;

import java.util.ArrayList;

import static android.Manifest.permission.ANSWER_PHONE_CALLS;
import static android.Manifest.permission.READ_CALL_LOG;
import static android.Manifest.permission.READ_PHONE_STATE;

public class SosActivity extends AppCompatActivity {

    private ListView listView;
    private Button addContactBtn;
    private String mInput;
    private MyDbHandler db;
    private ContactSOSAdapter contactAdapter;
    private ArrayList<Contact> contactArrayList;
    private Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);

        db = new MyDbHandler(SosActivity.this);

        addContactBtn = findViewById(R.id.addContactBtn);
        aSwitch = findViewById(R.id.switch_btn);
//
//        if(Params.fun_state == 0) {
//            aSwitch.setChecked(false);
//            addContactBtn.setEnabled(false);
//        }
//        else {
//            aSwitch.setChecked(true);
//            addContactBtn.setEnabled(true);
//        }

        // Creating object of our custom adapter class
        contactAdapter = new ContactSOSAdapter(SosActivity.this, db.readSosContact());

         



        addContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (db.getSosCount() < 5) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SosActivity.this);
                    builder.setTitle("Enter Contact Details");
                    // Setting up input
                    final EditText contactNameET = new EditText(SosActivity.this);
                    final EditText contactNumberET = new EditText(SosActivity.this);

                    contactNameET.setHint("Contact name");  //editbox1 hint
      
                    contactNumberET.setHint("Contact Number");  //editbox2 hint
                    contactNumberET.setInputType(InputType.TYPE_CLASS_PHONE);
                    contactNumberET.setText("+91");

                    //set up in a linear layout
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.setMargins(20, 20, 20, 20); //set margin

                    LinearLayout lp = new LinearLayout(getApplicationContext());
                    lp.setOrientation(LinearLayout.VERTICAL);

                    lp.addView(contactNameET, layoutParams);
                    lp.addView(contactNumberET, layoutParams);

                    builder.setView(lp);

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String Cname = contactNameET.getText().toString();
                        
                            String Cnumber = contactNumberET.getText().toString();

                            
 //Problem: When adding a contact, there’s no validation for an empty name or incorrect phone number.
  Fix: Add basic validation before inserting the contact.//
 if (Cname.isEmpty() || Cnumber.isEmpty()) {
    Toast.makeText(SosActivity.this, "Please enter valid contact details", Toast.LENGTH_SHORT).show();
    return;
}

 
                            // Creating object of contact
                            Contact contact1 = new Contact(Cname, Cnumber);

                            // Inserting contact to db
                            db.addSosContact(contact1);
                            if (listView != null)
                                listView.invalidateViews();

                            refreshActivity();
                        }
                    });

                    builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });

                    builder.show();
                }else {
                    Toast.makeText(SosActivity.this, "Only 5 parental contacts are allowed.", Toast.LENGTH_SHORT).show();
                }
            }
        });



        // Creating object of ListView and assigning the list id to it
        ListView listView = findViewById(R.id.list);

//        // Add adapter to the ListView
        listView.setAdapter(contactAdapter);

    }

    public void takePermissions(){
        if (checkSelfPermission(READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{READ_PHONE_STATE}, 2000);
        }
        if (checkSelfPermission(READ_CALL_LOG)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{READ_CALL_LOG}, 3000);
        }
        if (checkSelfPermission(ANSWER_PHONE_CALLS)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{ANSWER_PHONE_CALLS}, 1000);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 1000:
                if (grantResults.length > 0) {
                    boolean AnswerPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (AnswerPermission) {
                        Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case 2000:
                if (grantResults.length > 0) {
                    boolean AnswerPermission1 = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (AnswerPermission1) {
                        Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case 3000:
                if (grantResults.length > 0) {
                    boolean AnswerPermission2 = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (AnswerPermission2) {
                        Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_LONG).show();
                    }
                }
                break;
                //Rahul shinde

        }
    }

    public void refreshActivity(){
        finish();
        overridePendingTransition( 0, 0);
        startActivity(getIntent());
        overridePendingTransition( 0, 0);
    }

}
