package com.gads.leaderboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.gads.leaderboard.Model.Label;

import java.util.List;


public class LearningAdapter extends RecyclerView.Adapter<LearningAdapter.ViewHolder> {

    private final List<Label> mValues;

    public LearningAdapter(List<Label> items) {
         mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_learning, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mFullName.setText(mValues.get(position).getName());
        holder.mLearningHours.setText(String.format("%s learning hours, ", mValues.get(position).getHours()));
        holder.mCountry.setText(mValues.get(position).getCountry());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mFullName;
        public final TextView mLearningHours;
        public final TextView mCountry;
        public Label mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mFullName = view.findViewById(R.id.full_name);
            mLearningHours = view.findViewById(R.id.learning_hours);
            mCountry = view.findViewById(R.id.country);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mLearningHours.getText() + "'";
        }
    }
}