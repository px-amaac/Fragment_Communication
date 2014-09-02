package com.doublea.myapplication2.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ShaDynastys on 9/1/2014.
 */
public class IncomeFragment extends Fragment {
    public static final String TAG = IncomeFragment.class.getSimpleName();

    private SendIncomeData sendIncomeData;

    static IncomeFragment newInstance() {
        IncomeFragment frag = new IncomeFragment();
        return frag;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            sendIncomeData = (SendIncomeData) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement SendIncomeData");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setRetainInstance(true);
        View result = inflater.inflate(R.layout.fragment, container, false);
        TextView text = (TextView) result.findViewById(R.id.text);
        text.setText(TAG);
        final EditText editText = (EditText) result.findViewById(R.id.editText);
        editText.setVisibility(View.VISIBLE);
        Button button = (Button) result.findViewById(R.id.button);
        button.setVisibility(View.VISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIncomeData.onAcceptClicked("income", editText.getText().toString());
            }
        });
        return result;
    }

    public interface SendIncomeData {
        public void onAcceptClicked(String fragment, String total);
    }
}
