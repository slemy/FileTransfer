package com.vlad.simion.filetransfer.ui.activities;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.vlad.simion.filetransfer.R;
import com.vlad.simion.filetransfer.ui.activities.baseactivity.RFTBaseActivity;
import com.vlad.simion.filetransfer.ui.adapters.MyRFTPageAdapter;
import com.vlad.simion.filetransfer.ui.fragments.FragmentTitles;
import com.vlad.simion.filetransfer.ui.fragments.MyRFTFragment;

public class RFTMainActivity extends RFTBaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rftmain);
		setUserInterface();
		refreshViews();
	}

	@Override
	public void setUserInterface() {
		ViewHolder.m_ViewPager = (ViewPager) findViewById(R.id.main_activity_viewpager);
		ViewHolder.m_PageAdapter = new MyRFTPageAdapter(getSupportFragmentManager(), getFragments());
		ViewHolder.m_ViewPager.setAdapter(ViewHolder.m_PageAdapter);
	}

	@Override
	public void refreshViews() {
	}

	private static class ViewHolder {
		private static MyRFTPageAdapter m_PageAdapter;
		private static ViewPager m_ViewPager;
	}



	private List<Fragment> getFragments() {

		List<Fragment> fList = new ArrayList<Fragment>();
		fList.add(MyRFTFragment.newInstance(FragmentTitles.FRAGMENT_1_MY_CARD));
		fList.add(MyRFTFragment.newInstance(FragmentTitles.FRAGMENT_2_MY_PHOTOS));
		fList.add(MyRFTFragment.newInstance(FragmentTitles.FRAGMENT_3_MY_APPS));
		fList.add(MyRFTFragment.newInstance(FragmentTitles.FRAGMENT_4_MY_FILES));
		fList.add(MyRFTFragment.newInstance(FragmentTitles.FRAGMENT_5_MY_CONTACTS));

		return fList;

	}

}
