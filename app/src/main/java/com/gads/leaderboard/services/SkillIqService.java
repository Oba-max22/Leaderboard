package com.gads.leaderboard.services;

import com.gads.leaderboard.Model.Label;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SkillIqService {
    @GET("skilliq")
    Call<List<Label>> getScore();
}
