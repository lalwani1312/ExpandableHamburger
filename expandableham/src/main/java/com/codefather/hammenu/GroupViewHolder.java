package com.codefather.hammenu;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hitesh-lalwani on 10/9/17.
 */

class GroupViewHolder extends BaseItemViewHolder<Group> implements View.OnClickListener {
    private TextView mLabelView;
    private ImageView mIconView, mAddRemoveView;
    private Group mGroup;
    private OnGroupClickListener mGroupClickListener;

    GroupViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        mLabelView = (TextView) itemView.findViewById(R.id.tv_label);
        mIconView = (ImageView) itemView.findViewById(R.id.iv_icon);
        mAddRemoveView = (ImageView) itemView.findViewById(R.id.iv_add_remove);
    }

    @Override
    public void onBind(Group group) {
        mGroup = group;
        mLabelView.setText(mGroup.getLabel());
        if (mGroup.getIconResId() != 0) {
            mIconView.setVisibility(View.VISIBLE);
            mIconView.setImageResource(mGroup.getIconResId());
        } else {
            mIconView.setVisibility(View.GONE);
        }
        if (mGroup.isExpanded()) {
            mAddRemoveView.setImageResource(mGroup.getExpandedIconId());
        } else {
            mAddRemoveView.setImageResource(mGroup.getCollapsedIconId());
        }
    }

    public void setOnGroupClickListener(OnGroupClickListener groupClickListener) {
        mGroupClickListener = groupClickListener;
    }

    @Override
    public void onClick(View v) {
        if (getAdapterPosition() != RecyclerView.NO_POSITION) {
            if (mGroupClickListener != null) {
                if (mGroupClickListener.onGroupClick(getAdapterPosition())) {
                    expanded();
                } else {
                    collapsed();
                }
            }
            if (getListener() != null) {
                getListener().onGroupItemClick(mGroup);
            }
        }
    }


    private void expanded() {
        mAddRemoveView.setImageResource(mGroup.getExpandedIconId());

    }

    private void collapsed() {
        mAddRemoveView.setImageResource(mGroup.getCollapsedIconId());
    }
}
