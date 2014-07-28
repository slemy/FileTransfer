package com.vlad.simion.filetransfer.ui.activities.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

public class RFTBaseActivity extends Activity {
	protected Context m_Context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.m_Context = this;
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	}
}
