package com.ozan.positivemulakat.ui.mainscreen;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ozan.positivemulakat.R;
import com.ozan.positivemulakat.Utils;
import com.ozan.positivemulakat.network.ApiClient;
import com.ozan.positivemulakat.network.api.Api;
import com.ozan.positivemulakat.network.response.Datas;
import com.ozan.positivemulakat.network.response.LeagueTable;

import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TabFirstFragment extends Fragment {

    @BindView(R.id.frag_first_recyclerview)
    RecyclerView frag_first_recyclerview;
    @BindView(R.id.frame_fragment)
    FrameLayout frameLayout;
    List<LeagueTable> list;
    String tournamentId = "1";
    String includeTable = "1";
    @BindView(R.id.customProgressDialog)
    RelativeLayout progressBar;
    @BindView(R.id.swiper)
    SwipeRefreshLayout swiper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_first, container, false);

        ButterKnife.bind(this, view);


        Log.d("asd", "onCreateView: ");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("onActivityCreated", "onActivityCreated: ");
        progressBar.setVisibility(View.VISIBLE);

        if (Utils.getConInfo(getContext())) {
            getServiceData();
        } else {
            Toast.makeText(getContext(), "Internet Bağlantınızı Kontrol Ediniz.", Toast.LENGTH_SHORT).show();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() { //kullanici hissetmemesi acisindan progressbar entegre edilmedi
                getServiceData();
                Log.i("Handler Activated:", "TRUE");
            }
        }, 120000); // her 2 dakikada bir servisi kendisi refresh eder


        swiper.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Swipe yapdigimda fragment acik ise katapilacak
                android.support.v4.app.FragmentManager fragmentManager = ((FragmentActivity) getContext()).getSupportFragmentManager();
                if (fragmentManager.getBackStackEntryCount() > 0) { //Onceden fragment varmi kontrolu
                    //Go back to previous Fragment
                    fragmentManager.popBackStackImmediate(); //Fragment var ise kapatilir
                }
                refresh();
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void refresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
                getServiceData();
                swiper.setRefreshing(false);
            }
        }, 3000);

    }

    public void getServiceData() {

        Api api = ApiClient.getClient().create(Api.class);
        Call<Datas> call = api.getData(tournamentId, includeTable);

        call.enqueue(new Callback<Datas>() {
            @Override
            public void onResponse(Call<Datas> call, Response<Datas> response) {

                try {
                    if (response.code() == 200) {
                        list = response.body().getLeagueStage().get(0).getLeagueTable();

                        Log.i("dataozan", String.valueOf(list));

                        Drawable dividerDrawable = ContextCompat.getDrawable(getContext(), R.drawable.line_divider);

                        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
                        dividerItemDecoration.setDrawable(dividerDrawable);
                        frag_first_recyclerview.addItemDecoration(dividerItemDecoration);

                        FirstFragAdapter adapter = new FirstFragAdapter(getContext(), list, progressBar);
                        frag_first_recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
                        frag_first_recyclerview.setAdapter(adapter);
                    }


                } catch (NullPointerException ex) {
                    ex.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<Datas> call, Throwable t) {

                t.printStackTrace();
                progressBar.setVisibility(View.GONE);
            }
        });
    }

}
