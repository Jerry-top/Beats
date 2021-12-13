package com.dss.beats_music.custom.dialog;

import android.content.Context;

import com.chad.library.adapter.base.listener.OnItemClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import fun.inaction.dialog.CenterDialog;
import kotlin.Pair;

public class ListDialog extends CenterDialog {

    private LeftTextHeader header = new LeftTextHeader(getHeaderContainer());
    private ListContent content = new ListContent(getContentContainer());

    public ListDialog(@NotNull Context context) {
        super(context);
        setHeader(header);
        setContent(content);

    }

    public ListDialog setTitle(String title){
        header.setTitle(title);
        return this;
    }

    public ListDialog setData(List<Pair<String,String>> data){
        content.setData(data);
        return this;
    }

    public ListDialog setOnItemClickListener(OnItemClickListener listener){
        content.setOnItemClickListener(listener);
        return this;
    }



}
