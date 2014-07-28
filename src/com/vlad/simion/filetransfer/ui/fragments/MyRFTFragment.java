package com.vlad.simion.filetransfer.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vlad.simion.filetransfer.R;

public class MyRFTFragment extends Fragment {

	public static final String KEY_FRAGMENT_MESSAGE = "KEY_F_M";

	public static final MyRFTFragment newInstance(String message) {
		MyRFTFragment f = new MyRFTFragment();
		Bundle bundle = new Bundle(1);
		bundle.putString(KEY_FRAGMENT_MESSAGE, message);
		f.setArguments(bundle);

		return f;

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		String message = getArguments().getString(KEY_FRAGMENT_MESSAGE);
		View v = inflater.inflate(R.layout.fragment_default, container, false);
		TextView messageTextView = (TextView) v.findViewById(R.id.fragment_default_title);
		messageTextView.setText(message);

		return v;

	}

}
