package com.ozan.positivemulakat.ui.detailscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ozan.positivemulakat.R;
import com.ozan.positivemulakat.network.response.LeagueTable;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ozanurkan on 7.10.2017.
 *
 */

public class DetailFragment extends Fragment {
    @BindView(R.id.team_name)
    TextView team_name;
    @BindView(R.id.team_logo)
    ImageView team_logo;
    @BindView(R.id.team_rank)
    TextView team_rank;
    @BindView(R.id.team_played)
    TextView team_played;
    @BindView(R.id.team_point)
    TextView team_point;
    @BindView(R.id.team_wins)
    TextView team_wins;
    @BindView(R.id.team_draws)
    TextView team_draws;
    @BindView(R.id.team_defeits)
    TextView team_defeits;
    @BindView(R.id.team_goalsfor)
    TextView team_goalsfor;
    @BindView(R.id.ll_detail)
    LinearLayout ll_detail;
    @BindView(R.id.team_goalsagainst)
    TextView team_goalsagainst;
    @BindView(R.id.team_average)
            TextView team_average;
    List<LeagueTable> list;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container, false);

        ButterKnife.bind(this, view);


        Log.d("asd", "onCreateView: ");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("onActivityCreated", "onActivityCreated: ");


    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(EventMessageModel model) {


        team_rank.setText(model.getRank());
        if (model.getTeamLogo().equals("")) {
            team_logo.setImageResource(R.drawable.ic_placeholder);
        } else {
            Picasso.with(getContext())
                    .load(model.getTeamLogo())
                    .into(team_logo);
        }
        team_name.setText(model.getName());
        team_played.setText(model.getPoints());
        team_wins.setText(model.getPoints());
        team_draws.setText(model.getDraws());
        team_defeits.setText(model.getDefeits());
        team_goalsfor.setText(model.getGoalsfor());
        team_goalsagainst.setText(model.getGoalsagainst());
        team_average.setText(model.getAvarage());

    }

    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
        if(getView() == null){
            return;
        }

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
                    // handle back button's click listener
                    android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                    if (fragmentManager.getBackStackEntryCount() > 0) {
                        //Go back to previous Fragment
                        fragmentManager.popBackStackImmediate();
                    }
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

}
