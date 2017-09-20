package com.example.administrator.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button button_send;
    private RecyclerView msgRecycleView;
    private MsgAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();
        inputText = (EditText) findViewById(R.id.input_text);
        button_send = (Button) findViewById(R.id.send);
        msgRecycleView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        adapter = new MsgAdapter(msgList);
       msgRecycleView.setLayoutManager(new GridLayoutManager(this,1));
        msgRecycleView.setAdapter(adapter);
        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                        if (!"".equals(content)){
                            Msg msg = new Msg(content,Msg.TYPE_SENT);
                            msgList.add(msg);
                            adapter.notifyItemInserted(msgList.size()-1);
                            //当有新消息时刷新LiftView中的显示
                            msgRecycleView.scrollToPosition(msgList.size()-1);
                            //将ListView定位在最后一行
                            inputText.setText("");//清空输入框内容
                        }
                    }
                });

    }

    private void initMsgs() {
        Msg msg1 = new Msg("Hello guy.",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Hello ,who is that?",Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("This is Tom,Nice talking to you",Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}
