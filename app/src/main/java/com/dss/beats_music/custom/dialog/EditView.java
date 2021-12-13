package com.dss.beats_music.custom.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dss.beats_music.R;
import com.dss.beats_music.custom.view.CancelEditTextView;

import org.jetbrains.annotations.NotNull;

import fun.inaction.dialog.ViewAdapter;

public class EditView implements ViewAdapter {

    private View view;
    private ViewGroup parent;
    public CancelEditTextView editTextView;
    public TextView cancelButton;
    public TextView confirmButton;

    public EditView(ViewGroup parent) {
        this.parent = parent;
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dialog_edit_view,parent,false);
        editTextView = view.findViewById(R.id.cancelEditTextView);
        cancelButton = view.findViewById(R.id.cancel);
        confirmButton = view.findViewById(R.id.confirm);
    }

    @NotNull
    @Override
    public View getView() {
        return view;
    }



}
