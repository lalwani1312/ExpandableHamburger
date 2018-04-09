package com.codefather.hammenu;

/**
 * Created by hitesh-lalwani on 11/9/17.
 */

public class Item {

    public static final int VIEWTYPE_ITEM = 0;
    public static final int VIEWTYPE_GROUP = 1;
    private int viewType = VIEWTYPE_ITEM;

    protected int level;
    protected int id;
    protected String label;
    protected String count;
    protected int iconResId;

    protected Item(int viewType) {
        this.viewType = viewType;
        level = 0;
    }


    public int getViewType() {
        return viewType;
    }

    public String getLabel() {
        return this.label;
    }

    public int getIconResId() {
        return this.iconResId;
    }

    public String getCount() {
        return this.count;
    }

    public int getId() {
        return this.id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
