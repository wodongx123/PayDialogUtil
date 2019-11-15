package com.example.paydialogutil;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ButtonAdapter extends BaseAdapter {
    private static final String TAG = "ButtonAdapter";

    private Context mContext;
    private char[] mList;
    private ButtonListener mListener;



    public ButtonAdapter(Context context, char[] list){
        mContext = context;
        mList = list;
    }

    public void setmListener(ButtonListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public int getCount() {
        return mList.length;
    }

    @Override
    public Object getItem(int position) {
        return mList[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Log.i(TAG, "getView: " + position +  "  " + convertView + "   " + parent);
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_button, null);
            viewHolder = new ViewHolder();

            viewHolder.relativeLayout = convertView.findViewById(R.id.rl_item);
            viewHolder.textView = convertView.findViewById(R.id.tv_item);
            viewHolder.imageView = convertView.findViewById(R.id.iv_item);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        switch (mList[position]){
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case '0':
                viewHolder.textView.setText(String.valueOf(mList[position]));
                break;
            case ' ':
                viewHolder.relativeLayout.setEnabled(false);
                break;
            case '/': ;
                viewHolder.relativeLayout.setBackgroundResource(R.drawable.selector_del);
                viewHolder.imageView.setImageResource(R.drawable.ic_paykeyborddelete);
                break;
        }
        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)  mListener.getContent(mList[position]);
            }
        });


        return convertView;
    }

    class ViewHolder{
        RelativeLayout relativeLayout;
        TextView textView;
        ImageView imageView;
    }


    public interface ButtonListener{
        void getContent(char c);
    }

}
