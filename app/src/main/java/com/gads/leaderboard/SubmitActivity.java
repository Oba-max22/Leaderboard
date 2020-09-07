package com.gads.leaderboard;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.gads.leaderboard.services.FormService;
import com.gads.leaderboard.services.FormServiceBuilder;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitActivity extends AppCompatActivity {
    private EditText mFormName;
    private EditText mFormLastName;
    private EditText mFormEmail;
    private EditText mFormGitLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        mFormName = findViewById(R.id.firstName);
        mFormLastName = findViewById(R.id.lastName);
        mFormEmail = findViewById(R.id.EmailAddress);
        mFormGitLink = findViewById(R.id.Git_link);
    }

    public void BackPressed(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void Confirmation(View view) {
        customDialog();
        }
    private void customDialog() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        final AlertDialog alertDialog = alertBuilder.create();
        final LayoutInflater inflater = this.getLayoutInflater();
        final View alertView = inflater.inflate(R.layout.dialog_form, null);
        alertDialog.setView(alertView);
        alertDialog.show();

        ImageButton cancel = alertView.findViewById(R.id.cancel_button);
        cancel.setOnClickListener(v -> alertDialog.dismiss());


        Button SubmitForm = alertView.findViewById(R.id.button_yes);
        SubmitForm.setOnClickListener(v -> {
            alertDialog.dismiss();
            submitFormToServer();
        });

    }

    private void submitFormToServer() {
            String Name = mFormName.getText().toString().trim();
            String LastName = mFormLastName.getText().toString().trim();
            String Email = mFormEmail.getText().toString().trim();
            String GitHubLink = mFormGitLink.getText().toString().trim();

            FormService formService = FormServiceBuilder.buildFormService(FormService.class);
            Call<Void> formRequest = formService.SubmitForm(Name, LastName, Email, GitHubLink);

            formRequest.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                    if(response.isSuccessful()) {
                        Log.d("TAG", "submission successful" + response.body());
                        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SubmitActivity.this);
                        AlertDialog alertDialog1 = alertBuilder.create();
                        LayoutInflater inflater = SubmitActivity.this.getLayoutInflater();
                        View alertView = inflater.inflate(R.layout.dialog_response, null);
                        LinearLayout successLayout = alertView.findViewById(R.id.success);
                        successLayout.setVisibility(View.VISIBLE);
                        alertDialog1.setView(alertView);
                        alertDialog1.show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                    Log.d("TAG", "submission not successful" + t.getMessage());
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SubmitActivity.this);
                    AlertDialog alertDialog2 = alertBuilder.create();
                    LayoutInflater inflater = SubmitActivity.this.getLayoutInflater();
                    View alertView = inflater.inflate(R.layout.dialog_response, null);
                    LinearLayout errorLayout = alertView.findViewById(R.id.error);
                    errorLayout.setVisibility(View.VISIBLE);
                    alertDialog2.setView(alertView);
                    alertDialog2.show();
                }
            });
    }
}