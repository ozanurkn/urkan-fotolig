package com.ozan.positivemulakat.network.response;

/**
 * Created by ozanurkan on 6.10.2017.
 *
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datas {

    @SerializedName("LeagueStage")
    @Expose
    private List<LeagueStage> leagueStage;

    public List<LeagueStage> getLeagueStage() {
        return leagueStage;
    }

    public void setLeagueStage(List<LeagueStage> leagueStage) {
        this.leagueStage = leagueStage;
    }

    @Override
    public String toString() {
        return "Datas{" +
                "leagueStage=" + leagueStage +
                '}';
    }
}
