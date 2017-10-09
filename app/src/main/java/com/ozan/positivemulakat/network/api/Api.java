package com.ozan.positivemulakat.network.api;

import com.ozan.positivemulakat.network.response.Datas;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ozanurkan on 7.10.2017.
 *
 */

public interface Api {
        @GET("LeagueStage")
        Call<Datas> getData(
                @Query("TournamentID") String tournamentId,
                @Query("includeTable") String tableId
        );
}
