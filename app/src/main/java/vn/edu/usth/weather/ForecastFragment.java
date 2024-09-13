package vn.edu.usth.weather;


import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class ForecastFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Create a parent LinearLayout with vertical orientation
        LinearLayout parentLayout = new LinearLayout(getActivity());
        parentLayout.setOrientation(LinearLayout.VERTICAL);
        parentLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));
        parentLayout.setBackgroundColor(Color.parseColor("#E1F5FE")); // Set blue background

        // Add a padding for aesthetic
        parentLayout.setPadding(16, 16, 16, 16);

        // Now, let's create multiple rows for each day's forecast
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        String[] weatherDetails = {
                "Partly Cloudy 25C - 32C",
                "Showers 24C - 30C",
                "Scattered Showers 23C - 29C",
                "Sunny 28C - 35C",
                "Partly Cloudy 26C - 32C",
                "Thunderstorms 24C - 29C",
                "Scattered Thunderstorms 25C - 31C"
        };

        int[] weatherIcons = {
                R.drawable.cloudy, // Replace with actual drawable resources
                R.drawable.rain,
                R.drawable.rain,
                R.drawable.sunny,
                R.drawable.cloudy,
                R.drawable.thunderstorm,
                R.drawable.thunderstorm
        };

        for (int i = 0; i < days.length; i++) {
            // Create a row for each day's forecast
            LinearLayout rowLayout = new LinearLayout(getActivity());
            rowLayout.setOrientation(LinearLayout.HORIZONTAL);
            rowLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            rowLayout.setPadding(8, 8, 8, 8);
            rowLayout.setGravity(Gravity.CENTER_VERTICAL);

            // Add a TextView for the day
            TextView dayTextView = new TextView(getActivity());
            dayTextView.setText(days[i]);
            dayTextView.setTextSize(16);
            dayTextView.setLayoutParams(new LinearLayout.LayoutParams(
                    0, LinearLayout.LayoutParams.WRAP_CONTENT, 1
            )); // Use weight to balance text and icons
            dayTextView.setGravity(Gravity.START);

            // Add an ImageView for the weather icon
            ImageView weatherImageView = new ImageView(getActivity());
            weatherImageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), weatherIcons[i]));
            weatherImageView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            weatherImageView.setPadding(16, 0, 16, 0);

            // Add another TextView for the weather details
            TextView detailsTextView = new TextView(getActivity());
            detailsTextView.setText(weatherDetails[i]);
            detailsTextView.setTextSize(14);
            detailsTextView.setLayoutParams(new LinearLayout.LayoutParams(
                    0, LinearLayout.LayoutParams.WRAP_CONTENT, 2
            )); // Use weight to balance text and icons
            detailsTextView.setGravity(Gravity.END);

            // Add the views to the row layout
            rowLayout.addView(dayTextView);
            rowLayout.addView(weatherImageView);
            rowLayout.addView(detailsTextView);

            // Add the row layout to the parent layout
            parentLayout.addView(rowLayout);
        }

        // Return the completed layout
        return parentLayout;
    }
}
