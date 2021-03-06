package com.vlad.simion.filetransfer.ui.activities;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.PageIndicator;
import com.vlad.simion.filetransfer.R;
import com.vlad.simion.filetransfer.ui.activities.baseactivity.RFTBaseActivity;
import com.vlad.simion.filetransfer.ui.adapters.MyRFTPageAdapter;
import com.vlad.simion.filetransfer.ui.fragments.FragmentCard;
import com.vlad.simion.filetransfer.ui.fragments.FragmentTitles;
import com.vlad.simion.filetransfer.ui.fragments.MyRFTFragment;

public class RFTMainActivity extends RFTBaseActivity {
	List<Fragment> m_FragmentList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rftmain);
		setUserInterface();
		refreshViews();	
		registerGCM();
	}

	private void registerGCM() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUserInterface() {
		ViewHolder.m_ViewPager = (ViewPager) findViewById(R.id.main_activity_viewpager);
		ViewHolder.m_TitlePageIndicator = (PageIndicator) findViewById(R.id.main_activity_viewpager_title_indicator);
		ViewHolder.m_PageAdapter = new MyRFTPageAdapter(
				getSupportFragmentManager(), getFragments());
		ViewHolder.m_ViewPager.setAdapter(ViewHolder.m_PageAdapter);
		ViewHolder.m_TitlePageIndicator.setViewPager(ViewHolder.m_ViewPager);
	}

	@Override
	public void refreshViews() {
		ViewHolder.m_ViewPager.setAdapter(ViewHolder.m_PageAdapter);
	}

	private static class ViewHolder {
		private static MyRFTPageAdapter m_PageAdapter;
		private static ViewPager m_ViewPager;
		private static PageIndicator m_TitlePageIndicator;
	}

	private List<Fragment> getFragments() {
		m_FragmentList = new ArrayList<Fragment>();
		m_FragmentList.add(FragmentCard.newInstance(FragmentTitles.FRAGMENT_1_MY_CARD));
		m_FragmentList.add(MyRFTFragment
				.newInstance(FragmentTitles.FRAGMENT_2_MY_PHOTOS));
		m_FragmentList.add(MyRFTFragment.newInstance(FragmentTitles.FRAGMENT_3_MY_APPS));
		m_FragmentList.add(MyRFTFragment.newInstance(FragmentTitles.FRAGMENT_4_MY_FILES));
		m_FragmentList.add(MyRFTFragment
				.newInstance(FragmentTitles.FRAGMENT_5_MY_CONTACTS));

		return m_FragmentList;
	}

}
