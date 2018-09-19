package com.example.huypham.mybaseproject.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.huypham.mybaseproject.R;

public class BookingDiaglog extends android.support.v4.app.DialogFragment  {
    public interface DialogListener{
        void sendInput(String input);
        void DialogEnalbe(boolean flag);
    }
    public DialogListener dialogListener;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialogListener = (DialogListener) getTargetFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_booking,null,false);
        // find element of view
        Button button = view.findViewById(R.id.bookConfirm);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogListener.DialogEnalbe(true);
                dialogListener.sendInput("HAHA");

            }
        });
        builder.setView(view);
//        builder.setView(view)
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                String input = "haha";
//                dialogListener.sendInput(input);
//            }
//        });

        return builder.create();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            dialogListener = (DialogListener) getParentFragment();
        }catch (ClassCastException e){
            Log.e("MES",e.getMessage());
        }
    }
}
