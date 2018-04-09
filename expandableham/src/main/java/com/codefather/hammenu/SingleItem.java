package com.codefather.hammenu;

/**
 * Created by hitesh-lalwani on 12/9/17.
 */

public class SingleItem extends Item {

    private SingleItem(Builder builder) {
        super(Item.VIEWTYPE_ITEM);
        id = builder.id;
        label = builder.label;
        count = builder.count;
        iconResId = builder.iconResId;
        level = 0;
    }

    public static final class Builder {

        private int iconResId = 0;
        private String count;
        private String label;
        private int id = -1;

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

        public Builder withId(int val) {
            id = val;
            return this;
        }

        public SingleItem build() {
            return new SingleItem(this);
        }
    }
}
