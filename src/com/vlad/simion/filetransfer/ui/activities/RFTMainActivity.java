package com.vlad.simion.filetransfer.ui.activities;

import android.os.Bundle;
import com.vlad.simion.filetransfer.R;
import com.vlad.simion.filetransfer.ui.activities.base.RFTBaseActivity;

public class RFTMainActivity extends RFTBaseActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rftmain);
		
		System.out.println("Test commit 2");
	}



}
