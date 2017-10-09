package com.ozan.positivemulakat.network.response;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by ozanurkan on 6.10.2017.
 *
 */

public class LeagueStage {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("TournamentName")
    @Expose
    private String tournamentName;
    @SerializedName("shownOrder")
    @Expose
    private Long shownOrder;
    @SerializedName("tournamentFK")
    @Expose
    private Long tournamentFK;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("countryFK")
    @Expose
    private Long countryFK;
    @SerializedName("countryName")
    @Expose
    private String countryName;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("n")
    @Expose
    private Long n;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("CurrentWeek")
    @Expose
    private String currentWeek;
    @SerializedName("TotalWeek")
    @Expose
    private String totalWeek;
    @SerializedName("MatchCount")
    @Expose
    private Long matchCount;
    @SerializedName("ut")
    @Expose
    private String ut;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("LeagueFixture")
    @Expose
    private List<Object> leagueFixture;
    @SerializedName("LeagueTable")
    @Expose
    private List<LeagueTable> leagueTable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public Long getShownOrder() {
        return shownOrder;
    }

    public void setShownOrder(Long shownOrder) {
        this.shownOrder = shownOrder;
    }

    public Long getTournamentFK() {
        return tournamentFK;
    }

    public void setTournamentFK(Long tournamentFK) {
        this.tournamentFK = tournamentFK;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getCountryFK() {
        return countryFK;
    }

    public void setCountryFK(Long countryFK) {
        this.countryFK = countryFK;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Long getN() {
        return n;
    }

    public void setN(Long n) {
        this.n = n;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getCurrentWeek() {
        return currentWeek;
    }

    public void setCurrentWeek(String currentWeek) {
        this.currentWeek = currentWeek;
    }

    public String getTotalWeek() {
        return totalWeek;
    }

    public void setTotalWeek(String totalWeek) {
        this.totalWeek = totalWeek;
    }

    public Long getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(Long matchCount) {
        this.matchCount = matchCount;
    }

    public String getUt() {
        return ut;
    }

    public void setUt(String ut) {
        this.ut = ut;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Object> getLeagueFixture() {
        return leagueFixture;
    }

    public void setLeagueFixture(List<Object> leagueFixture) {
        this.leagueFixture = leagueFixture;
    }

    public List<LeagueTable> getLeagueTable() {
        return leagueTable;
    }

    public void setLeagueTable(List<LeagueTable> leagueTable) {
        this.leagueTable = leagueTable;
    }

    @Override
    public String toString() {
        return "LeagueStage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tournamentName='" + tournamentName + '\'' +
                ", shownOrder=" + shownOrder +
                ", tournamentFK=" + tournamentFK +
                ", gender='" + gender + '\'' +
                ", countryFK=" + countryFK +
                ", countryName='" + countryName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", n=" + n +
                ", isActive=" + isActive +
                ", currentWeek='" + currentWeek + '\'' +
                ", totalWeek='" + totalWeek + '\'' +
                ", matchCount=" + matchCount +
                ", ut='" + ut + '\'' +
                ", logo='" + logo + '\'' +
                ", leagueFixture=" + leagueFixture +
                ", leagueTable=" + leagueTable +
                '}';
    }
}
