package com.gads.leaderboard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gads.leaderboard.Model.Label;
import com.gads.leaderboard.services.HoursService;
import com.gads.leaderboard.services.ServiceBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LearningFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;


    public LearningFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static LearningFragment newInstance(int columnCount) {
        LearningFragment fragment = new LearningFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            final Context context = view.getContext();
            final RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            HoursService hoursService = ServiceBuilder.buildService(HoursService.class);
            Call<List<Label>> hoursRequest = hoursService.getHours();

            hoursRequest.enqueue(new Callback<List<Label>>() {
                @Override
                public void onResponse(Call<List<Label>> call, Response<List<Label>> response) {
                    recyclerView.setAdapter(new LearningAdapter(response.body()));

                }

                @Override
                public void onFailure(Call<List<Label>> call, Throwable t) {
                    Toast.makeText(context, "Failed to retrieve Learning Leaders.", Toast.LENGTH_SHORT).show();
                }
            });
        }
        return view;
    }
}