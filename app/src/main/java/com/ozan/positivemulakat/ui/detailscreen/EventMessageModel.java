package com.ozan.positivemulakat.ui.detailscreen;

/**
 * Created by ozanurkan on 7.10.2017.
 *
 */

public class EventMessageModel {

    private String rank;
    private String teamLogo;
    private String name;
    private String played;
    private String points;
    private String wins;
    private String draws;
    private String defeits;
    private String goalsfor;
    private String goalsagainst;
    private String avarage;

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setTeamLogo(String teamLogo) {
        this.teamLogo = teamLogo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayed(String played) {
        this.played = played;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public void setDraws(String draws) {
        this.draws = draws;
    }

    public void setDefeits(String defeits) {
        this.defeits = defeits;
    }

    public void setGoalsfor(String goalsfor) {
        this.goalsfor = goalsfor;
    }

    public void setGoalsagainst(String goalsagainst) {
        this.goalsagainst = goalsagainst;
    }

    public void setAvarage(String avarage) {
        this.avarage = avarage;
    }



    /*public EventMessageModel(String rank, String teamLogo, String name, String played,
                             String point, String wins, String draws, String defeits, String goalsfor, String goalsagainst, String avarage) {
        this.rank = rank;
        this.teamLogo = teamLogo;
        this.name = name;
        this.played = played;
        this.points = point;
        this.wins = wins;
        this.draws = draws;
        this.defeits = defeits;
        this.goalsfor = goalsfor;
        this.goalsagainst = goalsagainst;
        this.avarage = avarage;
    }
*/
    public String getRank() {
        return rank;
    }


    public String getTeamLogo() {
        return teamLogo;
    }


    public String getName() {
        return name;
    }


    public String getPlayed() {
        return played;
    }


    public String getPoints() {
        return points;
    }


    public String getWins() {
        return wins;
    }


    public String getDraws() {
        return draws;
    }


    public String getDefeits() {
        return defeits;
    }


    public String getGoalsfor() {
        return goalsfor;
    }


    public String getGoalsagainst() {
        return goalsagainst;
    }


    public String getAvarage() {
        return avarage;
    }


    @Override
    public String toString() {
        return "EventMessageModel{" +
                "rank='" + rank + '\'' +
                ", teamLogo='" + teamLogo + '\'' +
                ", name='" + name + '\'' +
                ", played='" + played + '\'' +
                ", points='" + points + '\'' +
                ", wins='" + wins + '\'' +
                ", draws='" + draws + '\'' +
                ", defeits='" + defeits + '\'' +
                ", goalsfor='" + goalsfor + '\'' +
                ", goalsagainst='" + goalsagainst + '\'' +
                ", avarage='" + avarage + '\'' +
                '}';
    }
}
