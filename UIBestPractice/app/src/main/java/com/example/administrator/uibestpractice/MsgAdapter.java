package com.example.administrator.uibestpractice;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18 0018.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Msg> mMsgList;
static class ViewHolder extends RecyclerView.ViewHolder{
    LinearLayout liftLayout;
    LinearLayout rightLayout;
    TextView liftMsg;
    TextView rightMsg;

    public ViewHolder(View view) {
        super(view);
        liftLayout = view.findViewById(R.id.left_layout);
        rightLayout = view.findViewById(R.id.right_layout);
        liftMsg = view.findViewById(R.id.left_msg);
        rightMsg = view.findViewById(R.id.right_msg);

    }
}
public MsgAdapter(List<Msg> msgList){
    mMsgList = msgList;
}

    @Override
    public MsgAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       // View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,parent,true);
        View view = View.inflate(parent.getContext(), R.layout.msg_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MsgAdapter.ViewHolder holder, int position) {
        Msg msg = mMsgList.get(position);
        if (msg.getType()==Msg.TYPE_RECEIVED){
            holder.liftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.liftMsg.setText(msg.getContent());
        }else if (msg.getType()==Msg.TYPE_SENT){
            holder.liftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightMsg.setText(msg.getContent());
        }

    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }
}

