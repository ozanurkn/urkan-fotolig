package com.ozan.positivemulakat.ui.mainscreen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ozan.positivemulakat.R;
import com.ozan.positivemulakat.network.response.LeagueTable;
import com.ozan.positivemulakat.ui.detailscreen.DetailFragment;
import com.ozan.positivemulakat.ui.detailscreen.EventMessageModel;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by ozanurkan on 6.10.2017.
 * kanka sesli iletişimi açalım ı müsait msiin?
 */

public class FirstFragAdapter extends RecyclerView.Adapter<FirstFragAdapter.MyViewHolder> {

    private Context mContext;
    private List<LeagueTable> mList;
    private RelativeLayout progressBar;



    public FirstFragAdapter(Context context, List<LeagueTable> list, RelativeLayout progressBar) {

        this.mContext = context;
        this.mList = list;
        this.progressBar = progressBar;



    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView rank, name, oynama, puan;
        RelativeLayout rl_adapter;
        ImageView teamlogo;

        public MyViewHolder(View itemView) {
            super(itemView);

            rank = (TextView) itemView.findViewById(R.id.rank);
            name = (TextView) itemView.findViewById(R.id.name);
            oynama = (TextView) itemView.findViewById(R.id.oynama);
            puan = (TextView) itemView.findViewById(R.id.puan);
            rl_adapter = (RelativeLayout) itemView.findViewById(R.id.rl_adapter);

            teamlogo = (ImageView) itemView.findViewById(R.id.teamlogo);

        }
    }

    @Override
    public FirstFragAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_frag_adapter, parent, false);
        FirstFragAdapter.MyViewHolder viewHolder = new FirstFragAdapter.MyViewHolder(itemView);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FirstFragAdapter.MyViewHolder holder, final int position) {


        Log.d("fsd", "onBindViewHolder: " + mList.get(position));
        holder.rank.setText(mList.get(position).getRank().toString());
        holder.name.setText(mList.get(position).getName().toString());
        holder.oynama.setText(mList.get(position).getPlayed().toString());
        holder.puan.setText(mList.get(position).getPoints());

        if (mList.get(position).getTeamLogo() != null) {

            Picasso.with(mContext)
                    .load(mList.get(position)
                            .getTeamLogo())
                    .into(holder.teamlogo);
            progressBar.setVisibility(View.GONE);
        } else {
            holder.teamlogo.setImageResource(R.drawable.ic_placeholder);
            progressBar.setVisibility(View.GONE);
        }


        holder.rl_adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventMessageModel eventMessageModel = new EventMessageModel();

                eventMessageModel.setRank(mList.get(position).getRank().toString());
                eventMessageModel.setTeamLogo(mList.get(position).getTeamLogo());
                eventMessageModel.setName(mList.get(position).getName());
                eventMessageModel.setPlayed(mList.get(position).getPlayed());
                eventMessageModel.setPoints(mList.get(position).getPoints());
                eventMessageModel.setWins(mList.get(position).getWins());
                eventMessageModel.setDraws(mList.get(position).getDraws());
                eventMessageModel.setDefeits(mList.get(position).getDefeits());
                eventMessageModel.setGoalsfor(mList.get(position).getGoalsfor());
                eventMessageModel.setGoalsagainst(mList.get(position).getGoalsagainst());
                eventMessageModel.setAvarage(mList.get(position).getAverage().toString());
                EventBus.getDefault().postSticky(eventMessageModel);

                android.support.v4.app.FragmentManager fragmentManager = ((FragmentActivity) mContext).getSupportFragmentManager();
                if (fragmentManager.getBackStackEntryCount() > 0) { //Onceden fragment varmi kontrolu
                    //Go back to previous Fragment
                    fragmentManager.popBackStackImmediate(); //Fragment var ise kapatilir
                }

                Fragment detailFragment = new DetailFragment();
                FragmentTransaction transaction = ((FragmentActivity) mContext).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_fragment, detailFragment); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();

            }
        });


    }



    @Override
    public int getItemCount() {
        return mList.size();
    }
}

