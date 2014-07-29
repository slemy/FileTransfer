package com.vlad.simion.filetransfer.ui.activities.baseactivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * 
 * @author Vlad.Simion
 * @date 7/28/2014
 *
 */

public abstract class RFTBaseActivity extends FragmentActivity {
	protected Context m_Context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.m_Context = this;
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		refreshViews();
	}
	
	/**
	 * Binds the id-s to the ViewHolder components***
	 */
	public abstract void setUserInterface();
	
	/**
	 * Refresh the values from ViewHolder components***
	 */
	public abstract void refreshViews();
	
}
