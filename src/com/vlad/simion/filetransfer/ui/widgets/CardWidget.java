package com.vlad.simion.filetransfer.ui.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vlad.simion.filetransfer.R;
import com.vlad.simion.filetransfer.utils.StringUtils;
import com.vlad.simion.filetransfer.utils.UIUtils;

public class CardWidget extends RelativeLayout {

	private TextView tv_FirstName;
	private TextView tv_LastName;
	private TextView tv_WorkPlace;
	private ImageView imv_ProfilePicture;
	private ImageView imv_EditProfile;
	
	private View view_Divider1;
	private View view_Divider2;

	public CardWidget(Context context) {
		super(context);
		initCardWidget(null);
	}

	public CardWidget(Context context, AttributeSet attrs) {
		super(context, attrs);
		initCardWidget(attrs);
	}

	private void initCardWidget(AttributeSet attrs) {
		
		LayoutInflater m_Inflater = null;
			
		if (getContext() instanceof Activity) {
			m_Inflater = ((Activity) getContext()).getLayoutInflater();
		} else {
			m_Inflater = LayoutInflater.from(getContext());
		}

		View m_CardWidgetLayout = m_Inflater.inflate(R.layout.card_layout, this, true);
		
		tv_FirstName = (TextView) m_CardWidgetLayout.findViewById(R.id.tv_card_profile_first_name);
		tv_LastName = (TextView) m_CardWidgetLayout.findViewById(R.id.tv_card_profile_last_name);
		tv_WorkPlace = (TextView) m_CardWidgetLayout.findViewById(R.id.tv_card_profile_workplace);
		
		imv_ProfilePicture = (ImageView) m_CardWidgetLayout.findViewById(R.id.imv_card_profile_image);
		imv_EditProfile = (ImageView) m_CardWidgetLayout.findViewById(R.id.imv_card_edit);
		
		view_Divider1 = (View) m_CardWidgetLayout.findViewById(R.id.view_card_profile_divider_one);
		view_Divider2 = (View) m_CardWidgetLayout.findViewById(R.id.view_card_profile_divider_two);
	}
	
	public void setFirstName(String _firstName){
		UIUtils.setSafeText(tv_FirstName, _firstName);
	}
	
	public void setLastName(String _lastName){
		UIUtils.setSafeText(tv_LastName, _lastName);
		if(StringUtils.isEmptyOrBlank(_lastName)){
			UIUtils.setSafeVisibility(view_Divider1, false);
			return;
		}
		UIUtils.setSafeVisibility(view_Divider1, true);
	}
	
	public void setWorkPlace(String _workPlace){
		UIUtils.setSafeText(tv_WorkPlace, _workPlace);
		if(StringUtils.isEmptyOrBlank(_workPlace)){
			UIUtils.setSafeVisibility(view_Divider2, false);
			return;
		}
		UIUtils.setSafeVisibility(view_Divider2, true);
	}
	
	public void setProfileImage(Bitmap _profileImage){
		imv_ProfilePicture.setImageBitmap(_profileImage);
	}
	
	public void setEditProfileVisibility(boolean _visibility){
		UIUtils.setSafeVisibility(imv_EditProfile, _visibility);	
	}
	
	public void addEditProfileClickListener(OnClickListener _listener){
		imv_EditProfile.setOnClickListener(_listener);
	}

}
