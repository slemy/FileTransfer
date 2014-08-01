package com.vlad.simion.filetransfer.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.vlad.simion.filetransfer.R;
import com.vlad.simion.filetransfer.UserEntity;
import com.vlad.simion.filetransfer.ui.activities.EditCardActivity;
import com.vlad.simion.filetransfer.ui.activities.RFTMainActivity;
import com.vlad.simion.filetransfer.ui.widgets.CardWidget;
import com.vlad.simion.filetransfer.utils.FileUtils;

public class FragmentCard extends Fragment  {
	
	private UserEntity m_User;

	public static final FragmentCard newInstance(String message) {
		FragmentCard f = new FragmentCard();
		return f;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View m_FragmentCardView = inflater.inflate(R.layout.fragment_1_card, container, false);
		setUserInterface(m_FragmentCardView);	
		refreshViews();
		return m_FragmentCardView;
	}
		
	private void setUserInterface(View _layout) {
		ViewHolder.m_CardWidget = (CardWidget) _layout.findViewById(R.id.card_widget);
		setCardWidget();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		RFTMainActivity _main = (RFTMainActivity) getActivity();
		m_User = _main.getConnectedUser();
	}

	private static class ViewHolder{
		private static CardWidget m_CardWidget;
	}
	
	private void setCardWidget(){
		ViewHolder.m_CardWidget.addEditProfileClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				Intent editCardIntent = new Intent(getActivity(), EditCardActivity.class);
				startActivity(editCardIntent);
			}
		});
	}

	public void refreshViews(){			
		ViewHolder.m_CardWidget.setFirstName(m_User.getFirstName());
		ViewHolder.m_CardWidget.setLastName(m_User.getLastName());
		ViewHolder.m_CardWidget.setWorkPlace(m_User.getWorkplace());	
		ViewHolder.m_CardWidget.setProfileImage(FileUtils.getBitmapFromByteArray(m_User.getProfileImage()));
	}
	

}
