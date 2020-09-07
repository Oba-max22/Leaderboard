package com.gads.leaderboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gads.leaderboard.Model.Label;

import java.util.List;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.ViewHolder> {

    private final List<Label> mValues;

    public SkillAdapter(List<Label> items) {
        mValues = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_skill, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mFullName.setText(mValues.get(position).getName());
        holder.mSkillIq.setText(String.format("%s skill IQ, ", mValues.get(position).getScore()));
        holder.mCountry.setText(mValues.get(position).getCountry());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mFullName;
        public final TextView mSkillIq;
        public final TextView mCountry;
        public Label mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mFullName = view.findViewById(R.id.full_name);
            mSkillIq = view.findViewById(R.id.skill_IQ);
            mCountry = view.findViewById(R.id.country);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mSkillIq.getText() + "'";
        }
    }
}