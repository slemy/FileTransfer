package com.vlad.simion.filetransfer.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vlad.simion.filetransfer.R;

public class FragmentCard extends Fragment {

	public static final FragmentCard newInstance(String message) {
		FragmentCard f = new FragmentCard();
		return f;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.fragment_1_card, container, false);
		return v;

	}

}
