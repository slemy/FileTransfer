package com.vlad.simion.filetransfer.ui.fragments;

import com.vlad.simion.filetransfer.R;

public class FragmentTitles {

	public final static String FRAGMENT_1_MY_CARD = "My Card";
	public final static String FRAGMENT_2_MY_PHOTOS = "Photos";
	public final static String FRAGMENT_3_MY_APPS = "Applications";
	public final static String FRAGMENT_4_MY_FILES = "Files";
	public final static String FRAGMENT_5_MY_CONTACTS = "Contacts";
	
	public static final String[] FRAGMENT_TITLES =  new String[]{
			FRAGMENT_1_MY_CARD, FRAGMENT_2_MY_PHOTOS, FRAGMENT_3_MY_APPS, FRAGMENT_4_MY_FILES, FRAGMENT_5_MY_CONTACTS
	};
	
	public static final int[] FRAGMENT_ICONS =  new int[]{
			R.drawable.item_view_pager_indicator_card,
			R.drawable.item_view_pager_indicator_photo,
			R.drawable.item_view_pager_indicator_applications,
			R.drawable.item_view_pager_indicator_files,
			R.drawable.item_view_pager_indicator_contacts,
	};
}
