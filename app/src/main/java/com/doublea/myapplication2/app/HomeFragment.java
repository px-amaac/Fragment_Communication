package com.doublea.myapplication2.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ShaDynastys on 9/1/2014.
 */
public class HomeFragment extends Fragment {
    public static final String TAG = HomeFragment.class.getSimpleName();
    private String total;

    static HomeFragment newInstance(String total) {
        HomeFragment frag = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(TAG, total);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment, container, false);
        TextView text = (TextView) root.findViewById(R.id.text);
        text.setText(TAG);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        Bundle bundle = getArguments();
        total = bundle.getString(TAG);
        if (total != null)
            Toast.makeText(getActivity(), total, Toast.LENGTH_LONG).show();

    }
}
