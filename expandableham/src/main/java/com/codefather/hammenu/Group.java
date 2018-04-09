package com.codefather.hammenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hitesh-lalwani on 11/9/17.
 */

public class Group extends Item {

    private boolean expanded;
    private List<Item> items;
    private int expandedIconId;
    private int collapsedIconId;

    private Group() {
        super(Item.VIEWTYPE_GROUP);
    }

    private Group(Builder builder) {
        super(Item.VIEWTYPE_GROUP);
        expanded = builder.expanded;
        items = builder.items;
        expandedIconId = builder.expandedIconId;
        collapsedIconId = builder.collapsedIconId;
        label = builder.label;
        count = builder.count;
        iconResId = builder.iconResId;
        id = builder.id;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getExpandedIconId() {
        return expandedIconId;
    }

    public int getCollapsedIconId() {
        return collapsedIconId;
    }

    public void setExpanded(boolean isExpanded) {
        this.expanded = isExpanded;
    }

    public static final class Builder {
        private int id;
        private int iconResId;
        private String count;
        private String label;
        private int collapsedIconId;
        private int expandedIconId;
        private List<Item> items;
        private boolean expanded;

        public Builder(String label) {
            this.label = label;
        }

        public Builder withIconResId(int val) {
            iconResId = val;
            return this;
        }

        public Builder withCount(String val) {
            count = val;
            return this;
        }

        public Builder withLabel(String val) {
            label = val;
            return this;
        }

        public Builder withCollapsedIconId(int val) {
            collapsedIconId = val;
            return this;
        }

        public Builder withExpandedIconId(int val) {
            expandedIconId = val;
            return this;
        }

        public Builder addItems(List<Item> val) {
            if (items == null) {
                items = new ArrayList<>();
            }
            items.addAll(val);
            return this;
        }

        public Builder addItem(Item val) {
            if (items == null) {
                items = new ArrayList<>();
            }
            items.add(val);
            return this;
        }

        public Builder withExpanded(boolean val) {
            expanded = val;
            return this;
        }

        public Builder withId(int val) {
            id = val;
            return this;
        }

        public Group build() {
            return new Group(this);
        }
    }
}
