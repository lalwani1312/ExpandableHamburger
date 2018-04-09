package com.codefather.hammenu;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by hitesh-lalwani on 10/9/17.
 */

class SingleItemViewHolder extends BaseItemViewHolder<Item> implements View.OnClickListener {
    private TextView mLabelView, mCountView;
    private ImageView mIconView;
    private Item mItem;
    private float mDensity;
    private static final int DP_16 = 16;

    SingleItemViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        mLabelView = itemView.findViewById(R.id.tv_label);
        mCountView = itemView.findViewById(R.id.tv_count);
        mIconView = itemView.findViewById(R.id.iv_icon);
        mDensity = itemView.getResources().getDisplayMetrics().density;
    }

    @Override
    public void onBind(Item item) {
        mItem = item;
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mIconView.getLayoutParams();
        params.leftMargin = (int) (mDensity * DP_16 * mItem.getLevel());
        mIconView.setLayoutParams(params);
        mLabelView.setText(mItem.getLabel());
        if (isNotZero(mItem.getCount())) {
            mCountView.setText(mItem.getCount());
        } else {
            mCountView.setText(null);
        }
        if (mItem.getIconResId() != 0) {
            mIconView.setVisibility(View.VISIBLE);
            mIconView.setImageResource(mItem.getIconResId());
        } else {
            mIconView.setVisibility(View.INVISIBLE);
        }
    }

    public boolean isNotZero(String count) {
        return !TextUtils.isEmpty(count) && !"0".equalsIgnoreCase(count);
    }

    @Override
    public void onClick(View v) {
        if (getListener() != null) {
            getListener().onItemClick(mItem);
        }
    }
}
