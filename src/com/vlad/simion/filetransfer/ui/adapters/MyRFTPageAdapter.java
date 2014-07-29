package com.vlad.simion.filetransfer.ui.adapters;

import java.util.List;

import com.viewpagerindicator.IconPagerAdapter;
import com.vlad.simion.filetransfer.ui.fragments.FragmentTitles;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyRFTPageAdapter extends FragmentPagerAdapter  implements IconPagerAdapter{

	private List<Fragment> m_Fragments;

	public MyRFTPageAdapter(FragmentManager fm, List<Fragment> fragments) {
		super(fm);
		this.m_Fragments = fragments;
	}

	@Override
	public Fragment getItem(int position) {
		return this.m_Fragments.get(position);
	}

	@Override
	public int getCount() {
		return this.m_Fragments.size();
	}

	@Override
	public int getIconResId(int index) {
		return FragmentTitles.FRAGMENT_ICONS[index];
	}

}
