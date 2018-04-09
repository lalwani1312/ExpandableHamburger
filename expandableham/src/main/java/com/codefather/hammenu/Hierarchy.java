package com.codefather.hammenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hitesh-lalwani on 12/9/17.
 */

public final class Hierarchy {

    private List<Item> items;

    private Hierarchy(Builder builder) {
        items = builder.items;
        updateLevelUsingDfs(items, 0);
    }

    public List<Item> getItems() {
        return items;
    }

    private void updateLevelUsingDfs(List<Item> itemList, int currLevel) {
        int size = itemList.size();
        Item item;
        for (int i = 0; i < size; ++i) {
            item = itemList.get(i);
            item.setLevel(currLevel);
            if (item instanceof Group) {
                updateLevelUsingDfs(((Group) item).getItems(), currLevel + 1);
            }
        }
    }

    public static final class Builder {

        private List<Item> items;

        public Builder() {
        }

        public Builder addItems(List<Item> val) {
            if (items == null) {
                items = new ArrayList<>();
            }
            items.addAll(val);
            return this;
        }

        public Builder addItem(Item item) {
            if (items == null) {
                items = new ArrayList<>();
            }
            items.add(item);
            return this;
        }

        public Builder addGroup(Item item) {
            return addItem(item);
        }

        public Hierarchy build() {
            return new Hierarchy(this);
        }
    }
}
