package com.example.pawtner;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pawtner.adapter.MessageAdapter;
import com.example.pawtner.model.Message;

import java.util.ArrayList;
import java.util.List;

public class ChatDetailActivity extends AppCompatActivity {

    private RecyclerView recyclerViewChat;
    private EditText editTextMessage;
    private ImageView btnSend;

    private MessageAdapter adapter;
    private List<Message> messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_detail);

        recyclerViewChat = findViewById(R.id.recyclerViewChat);
        editTextMessage = findViewById(R.id.editTextMessage);
        btnSend = findViewById(R.id.btnSend);

        messageList = new ArrayList<>();
        messageList.add(new Message("Lorem ipsum dolor sit amet...", "10.00 am", Message.TYPE_RECEIVED));
        messageList.add(new Message("Ok!\nSee u tomorrow", "10.00 am", Message.TYPE_SENT));
        messageList.add(new Message("See ya! 🎉", "10.05 am", Message.TYPE_RECEIVED));

        adapter = new MessageAdapter(this, messageList);
        recyclerViewChat.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewChat.setAdapter(adapter);

        btnSend.setOnClickListener(v -> {
            String text = editTextMessage.getText().toString().trim();
            if (!text.isEmpty()) {
                messageList.add(new Message(text, "10.10 am", Message.TYPE_SENT));
                adapter.notifyItemInserted(messageList.size() - 1);
                recyclerViewChat.scrollToPosition(messageList.size() - 1);
                editTextMessage.setText("");
            }
        });
    }
}
