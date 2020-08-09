package com.stafftracking.project.chatblo;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import android.text.format.DateFormat;

import androidx.appcompat.app.AppCompatActivity;

public class Discuss extends AppCompatActivity {

    private static int SIGN_IN_REQUEST_CODE = 1;
    private FirebaseListAdapter<ChatMessage> adapter;
    RelativeLayout activity_discuss;
    FloatingActionButton fab;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SIGN_IN_REQUEST_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                displayChatMessage();
            }
            else{
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discuss);

activity_discuss = (RelativeLayout)findViewById(R.id.discuss_main);
fab = (FloatingActionButton)findViewById(R.id.fab);
fab.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        EditText input = (EditText) findViewById(R.id.input);
        if (input.length()== 0)
        {
            Snackbar.make(activity_discuss, "please type message first!!", Snackbar.LENGTH_SHORT).show();
        }
        else {
            Snackbar.make(activity_discuss, "Dear" + FirebaseAuth.getInstance().getCurrentUser().getEmail() + "your message send Sucessful!!", Snackbar.LENGTH_SHORT).show();

            //store message with unique user id created by google
            FirebaseDatabase.getInstance().getReference("Discuss").push().setValue(new ChatMessage(input.getText().toString(),
                    FirebaseAuth.getInstance().getCurrentUser().getEmail()));
            input.setText("");
        }
    }
});

        //check user not sign in
        if (FirebaseAuth.getInstance().getCurrentUser()==null)
        {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
        else
        {
            Snackbar.make(activity_discuss,"welcome " + FirebaseAuth.getInstance().getCurrentUser().getEmail(),Snackbar.LENGTH_SHORT).show();
        }
//load message
        displayChatMessage();


    }

    private void displayChatMessage() {
        ListView listofmessage = (ListView) findViewById(R.id.list_of_message);
        adapter = new FirebaseListAdapter<ChatMessage>(this,ChatMessage.class,R.layout.list_item,FirebaseDatabase.getInstance().getReference("Discuss"))
        {
            @Override
            protected void populateView(View v, ChatMessage model, int position) {
                //get refrence for message
                TextView messageText,messageUser,messageTime;
                messageText = (TextView) v.findViewById(R.id.message_text);
                messageUser = (TextView) v.findViewById(R.id.message_user);
                messageTime = (TextView) v.findViewById(R.id.message_time);

                messageText.setText(model.getMessageText());
                messageUser.setText(model.getMessageUser());
                messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)", model.getMessageTime()));
            }
        };
        listofmessage.setAdapter(adapter);


    }
}
