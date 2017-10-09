package com.ozan.positivemulakat.ui.mainscreen;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;

import com.ozan.positivemulakat.R;
import com.ozan.positivemulakat.network.ApiClient;
import com.ozan.positivemulakat.network.response.Datas;
import com.ozan.positivemulakat.network.response.LeagueStage;
import com.ozan.positivemulakat.ui.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPageActivity extends BaseActivity {

    @BindView(R.id.tab_layout)
    TabLayout tab_layout;
    @BindView(R.id.pager)
    ViewPager pager;

    ArrayList<LeagueStage> tablesListFirst;
    ArrayList<LeagueStage> tablesListSecond;

    interface TabLayoutName {
        String first = "Süper Lig";
        String second = "Premier Lig";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main_page;
    }

    @Override
    protected void initViews() {

        tablesListFirst = new ArrayList<>();
        tablesListSecond = new ArrayList<>();


        getPager();

    }

    public void getPager() {
        tab_layout.addTab(tab_layout.newTab().setText(TabLayoutName.first));
        tab_layout.addTab(tab_layout.newTab().setText(TabLayoutName.second));

        tab_layout.setTabGravity(TabLayout.GRAVITY_CENTER);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tab_layout.getTabCount());
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_layout));
        tab_layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected Context getContext() {
        return MainPageActivity.this;
    }

}
