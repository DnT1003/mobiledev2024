package vn.edu.usth.weather;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;

public class ForecastFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Create a new LinearLayout
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        // Create a TextView for the day
        TextView dayTextView = new TextView(getActivity());
        dayTextView.setText("Thursday");
        dayTextView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        // Create an ImageView for the weather icon
        ImageView weatherImageView = new ImageView(getActivity());
        weatherImageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.d01));
        weatherImageView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        // Add the TextView and ImageView to the LinearLayout
        linearLayout.addView(dayTextView);
        linearLayout.addView(weatherImageView);

        // Return the dynamically created layout
        return linearLayout;
    }
}
