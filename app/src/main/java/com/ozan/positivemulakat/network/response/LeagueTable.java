package com.ozan.positivemulakat.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by ozanurkan on 6.10.2017.
 *
 */

public class LeagueTable {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("TeamID")
    @Expose
    private Long teamID;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("points")
    @Expose
    private String points;
    @SerializedName("played")
    @Expose
    private String played;
    @SerializedName("wins")
    @Expose
    private String wins;
    @SerializedName("draws")
    @Expose
    private String draws;
    @SerializedName("defeits")
    @Expose
    private String defeits;
    @SerializedName("goalsfor")
    @Expose
    private String goalsfor;
    @SerializedName("goalsagainst")
    @Expose
    private String goalsagainst;
    @SerializedName("average")
    @Expose
    private Long average;
    @SerializedName("rank")
    @Expose
    private Long rank;
    @SerializedName("TeamLogo")
    @Expose
    private String teamLogo;
    @SerializedName("HasTeamLogo")
    @Expose
    private Boolean hasTeamLogo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamID() {
        return teamID;
    }

    public void setTeamID(Long teamID) {
        this.teamID = teamID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getPlayed() {
        return played;
    }

    public void setPlayed(String played) {
        this.played = played;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getDraws() {
        return draws;
    }

    public void setDraws(String draws) {
        this.draws = draws;
    }

    public String getDefeits() {
        return defeits;
    }

    public void setDefeits(String defeits) {
        this.defeits = defeits;
    }

    public String getGoalsfor() {
        return goalsfor;
    }

    public void setGoalsfor(String goalsfor) {
        this.goalsfor = goalsfor;
    }

    public String getGoalsagainst() {
        return goalsagainst;
    }

    public void setGoalsagainst(String goalsagainst) {
        this.goalsagainst = goalsagainst;
    }

    public Long getAverage() {
        return average;
    }

    public void setAverage(Long average) {
        this.average = average;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public String getTeamLogo() {
        return teamLogo;
    }

    public void setTeamLogo(String teamLogo) {
        this.teamLogo = teamLogo;
    }

    public Boolean getHasTeamLogo() {
        return hasTeamLogo;
    }

    public void setHasTeamLogo(Boolean hasTeamLogo) {
        this.hasTeamLogo = hasTeamLogo;
    }

    @Override
    public String toString() {
        return "LeagueTable{" +
                "id=" + id +
                ", teamID=" + teamID +
                ", name='" + name + '\'' +
                ", points='" + points + '\'' +
                ", played='" + played + '\'' +
                ", wins='" + wins + '\'' +
                ", draws='" + draws + '\'' +
                ", defeits='" + defeits + '\'' +
                ", goalsfor='" + goalsfor + '\'' +
                ", goalsagainst='" + goalsagainst + '\'' +
                ", average=" + average +
                ", rank=" + rank +
                ", teamLogo='" + teamLogo + '\'' +
                ", hasTeamLogo=" + hasTeamLogo +
                '}';
    }
}