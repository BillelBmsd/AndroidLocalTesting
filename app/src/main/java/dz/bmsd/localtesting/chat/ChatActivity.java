package dz.bmsd.localtesting.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dz.bmsd.localtesting.R;

public class ChatActivity extends AppCompatActivity implements ChatContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void addMessage(String message) {

    }

    @Override
    public void cleanMessageInput() {

    }

    @Override
    public void enableSendButton() {

    }

    @Override
    public void disableSendButton() {

    }
}
