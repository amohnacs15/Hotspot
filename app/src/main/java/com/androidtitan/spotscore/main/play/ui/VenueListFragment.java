package com.androidtitan.spotscore.main.play.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.androidtitan.spotscore.R;
import com.androidtitan.spotscore.common.BaseFragment;
import com.androidtitan.spotscore.main.data.Venue;
import com.androidtitan.spotscore.main.play.VenueListAdapter;
import com.androidtitan.spotscore.main.play.presenter.ScorePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class VenueListFragment extends BaseFragment {
    private final String TAG = getClass().getSimpleName();

    private ScorePresenter mScorePresenter;

    @Bind(R.id.list) RecyclerView mRecyclerView;
    private VenueListAdapter mAdapter;


    public VenueListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mScorePresenter = ((ScoreActivity)getActivity()).getScorePresenter();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_venue_list, container, false);
        ButterKnife.bind(this, v);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new VenueListAdapter(getActivity(), mScorePresenter, mScorePresenter.getNearbyVenuesList());
        mRecyclerView.setAdapter(mAdapter);

        return v;
    }


}