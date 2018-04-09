package com.codefather.hamburgerlib;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.codefather.hammenu.DefaultHamburgerRvAdapter;
import com.codefather.hammenu.Group;
import com.codefather.hammenu.Hierarchy;
import com.codefather.hammenu.InteractionListener;
import com.codefather.hammenu.Item;
import com.codefather.hammenu.SingleItem;

public class MainActivity extends AppCompatActivity {

    public static final int ID_HOME = 0;
    public static final int ID_SEARCH = 10;
    public static final int ID_OTHERS = 50;
    public static final int ID_ABOUT_US = 60;
    public static final int ID_PRIVACY_POLICY = 70;
    public static final int ID_SETTINGS = 80;
    public static final int ID_LOG_OUT = 90;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        setupToolbar();
        RecyclerView rv = findViewById(R.id.rv_nav);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new DefaultHamburgerRvAdapter(getHierarchy(), new InteractionListener() {
            @Override
            public void onItemClick(Item item) {
                showToast(item.getLabel() + " clicked");
            }

            @Override
            public void onGroupItemClick(Group group) {

            }
        }));
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white);
        }
    }

    private Hierarchy getHierarchy() {
        Hierarchy.Builder builder = new Hierarchy.Builder();
        builder.addItem(new SingleItem.Builder("Home").withId(ID_HOME).withIconResId(R.drawable.ic_home).build())
                .addItem(new SingleItem.Builder("Search").withId(ID_SEARCH).withIconResId(R.drawable.ic_search).build());
        Group.Builder groupBuilder = new Group.Builder("Others").withId(ID_OTHERS)
                .withIconResId(R.drawable.ic_info)
                .withExpandedIconId(R.drawable.ic_ham_expand)
                .withCollapsedIconId(R.drawable.ic_ham_collapse);
        groupBuilder.addItem(new SingleItem.Builder("About Us").withId(ID_ABOUT_US).build())
                .addItem(new SingleItem.Builder("Privacy Policy").withId(ID_PRIVACY_POLICY).build());
        builder.addGroup(groupBuilder.build());
        builder.addItem(new SingleItem.Builder("Settings").withId(ID_SETTINGS).withIconResId(R.drawable.ic_settings).build());
        builder.addItem(new SingleItem.Builder("Log out").withId(ID_LOG_OUT).withIconResId(R.drawable.ic_log_out).build());
        return builder.build();
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
