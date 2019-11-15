package com.example.paydialogutil;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;


public class PayDialog extends Dialog {

    private Context mContext;  //环境
    private View mView;   //视图
    PayLayout mLayout;   // 布局
    private Window mWindow;

    private DialogListener mListener;

    public PayDialog(@NonNull Context context) {
        super(context, R.style.dialog_pay_theme);
        initDialog(context);
    }


    private void initDialog(Context context) {
        mContext = context;
        mView = LayoutInflater.from(mContext).inflate(R.layout.dialog_pay, null);//设置好view
        mLayout = mView.findViewById(R.id.layout_pay);

        mLayout.setmListener(new PayLayout.Layoutlistener() {
            @Override
            public void closeBtn() {
                dismiss();
            }

            @Override
            public void fillContent(String content) {
                if (mListener != null) mListener.fillContent(content);
            }

            @Override
            public void leftBtn() {
                if (mListener != null) mListener.leftBtn();
            }

            @Override
            public void centerBtn() {
                if (mListener != null) mListener.centerBtn();

            }

            @Override
            public void rightBtn() {
                if (mListener != null) mListener.rightBtn();
            }
        });

        mWindow = getWindow();
        mWindow.setContentView(mView);//将view投到window（也就是Dialog上）
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM;
        mWindow.setAttributes(lp);

        mWindow.setWindowAnimations(R.style.dialog_anim);
    }

    public PayDialog setText(String title, String content, String left, String center, String right){
        mLayout.setText(title, content, left, center, right);
        return this;
    }


    public PayDialog setListener(DialogListener d){
        mListener = d;
        return this;
    }


    public interface DialogListener{
        void fillContent(String content);

        void leftBtn();

        void centerBtn();

        void rightBtn();
    }

}
