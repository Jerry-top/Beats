package com.dss.beats_music.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dss.beats_music.R;
import com.dss.beats_music.entity.MeFunctionItem;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MeFunctionGroupAdapter extends BaseQuickAdapter<MeFunctionItem, BaseViewHolder> {

    public MeFunctionGroupAdapter(@Nullable List<MeFunctionItem> data) {
        super(R.layout.item_me_function_group, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, MeFunctionItem meFunctionItem) {
        baseViewHolder.setImageResource(R.id.icon,meFunctionItem.getImageId());
        baseViewHolder.setText(R.id.icon_text,meFunctionItem.getText());
    }
}
