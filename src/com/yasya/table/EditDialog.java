package com.yasya.table;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class EditDialog extends DialogFragment implements
        OnEditorActionListener {

    public interface EditDialogListener {
        void onFinishEditDialog(String text1, String text2, String text3,
                                String text4, String text5);

        void onCallEditDialog(String text1, String text2, String text3,
                              String text4, String text5);
    }

    private EditText editID;
    private EditText editLast;
    private EditText editFirst;
    private EditText editAge;
    private EditText editStreet;

    public EditDialog() {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_frag_edit, container);
        editID = (EditText) view.findViewById(R.id.txt_id);
        editLast = (EditText) view.findViewById(R.id.txt_last);
        editFirst = (EditText) view.findViewById(R.id.txt_first);
        editAge = (EditText) view.findViewById(R.id.txt_age);
        editStreet = (EditText) view.findViewById(R.id.txt_street);

        getDialog().setTitle("Enter data:");
        getDialog().getWindow().setSoftInputMode(
                LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        editID.setOnEditorActionListener(this);
        editLast.setOnEditorActionListener(this);
        editFirst.setOnEditorActionListener(this);
        editAge.setOnEditorActionListener(this);
        editStreet.setOnEditorActionListener(this);
        return view;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (EditorInfo.IME_ACTION_DONE == actionId) {
            // Return input text to activity
            EditDialogListener activity = (EditDialogListener) getActivity();
            activity.onFinishEditDialog(editID.getText().toString(), editLast
                    .getText().toString(), editFirst.getText().toString(),
                    editAge.getText().toString(), editStreet.getText()
                    .toString());
            this.dismiss();
            return true;
        }
        return false;
    }
}
