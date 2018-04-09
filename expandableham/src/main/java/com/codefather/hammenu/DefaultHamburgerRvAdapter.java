package com.codefather.hammenu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by hitesh-lalwani on 10/9/17.
 */

public class DefaultHamburgerRvAdapter extends RecyclerView.Adapter<BaseItemViewHolder> implements OnGroupClickListener {
    private List<Item> mData;
    private InteractionListener mListener;

    public DefaultHamburgerRvAdapter(Hierarchy hierarchy, InteractionListener listener) {
        mData = hierarchy.getItems();
        mListener = listener;
    }

    @Override
    public BaseItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        switch (viewType) {
            case Item.VIEWTYPE_GROUP:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_item_view, parent, false);
                GroupViewHolder groupViewHolder = new GroupViewHolder(v);
                groupViewHolder.setOnGroupClickListener(this);
                groupViewHolder.setInteractionListener(mListener);
                return groupViewHolder;

            case Item.VIEWTYPE_ITEM:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_view, parent, false);
                SingleItemViewHolder childViewHolder = new SingleItemViewHolder(v);
                childViewHolder.setInteractionListener(mListener);
                return childViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseItemViewHolder holder, int position) {
        holder.onBind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getViewType();
    }

    @Override
    public boolean onGroupClick(int position) {
        if (mData.get(position) instanceof Group) {
            Group group = (Group) mData.get(position);
            if (group.getItems() != null) {
                if (group.isExpanded()) {
                    mData.removeAll(group.getItems());
                    notifyItemRangeRemoved(position + 1, group.getItems().size());
                    group.setExpanded(false);
                    return false;
                } else {
                    mData.addAll(position + 1, group.getItems());
                    notifyItemRangeInserted(position + 1, group.getItems().size());
                    group.setExpanded(true);
                    return true;
                }
            }

        }
        return false;
    }

    public void updateAdapterData(Hierarchy hierarchy) {
        mData = hierarchy.getItems();
        notifyDataSetChanged();
    }
}
