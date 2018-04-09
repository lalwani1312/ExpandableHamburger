package com.codefather.hammenu;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by hitesh-lalwani on 11/9/17.
 */

public class BaseItemViewHolder<T extends Item> extends RecyclerView.ViewHolder {
    private InteractionListener mListener;

    public BaseItemViewHolder(View itemView) {
        super(itemView);
    }

    public void onBind(T item) {
    }

    public void setInteractionListener(InteractionListener listener) {
        mListener = listener;
    }

    public InteractionListener getListener() {
        return mListener;
    }
}
