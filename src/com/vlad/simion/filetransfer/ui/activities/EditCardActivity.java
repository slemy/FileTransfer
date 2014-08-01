package com.vlad.simion.filetransfer.ui.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;

import com.vlad.simion.filetransfer.R;
import com.vlad.simion.filetransfer.RFTApplication;
import com.vlad.simion.filetransfer.UserEntity;
import com.vlad.simion.filetransfer.ui.activities.baseactivity.RFTBaseActivity;
import com.vlad.simion.filetransfer.utils.FileUtils;

public class EditCardActivity extends RFTBaseActivity {
	private static final int INTENT_KEY_SELECT_PROFILE_PICURE = 2001;

	private UserEntity m_User;
	private RFTApplication _appContext;
	private Bitmap _profilePicture;

	private static class ViewHolder {
		private static EditText et_FirstName;
		private static EditText et_LastName;
		private static EditText et_WorkPlace;
		private static ImageView imv_ProfilePicture;
		private static ImageView imv_EditProfilePicture;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_card);
		setUserInterface();
		refreshViews();
	}

	@Override
	public void setUserInterface() {
		_appContext = (RFTApplication) getApplicationContext();
		m_User = _appContext.getUser();
		ViewHolder.et_FirstName = (EditText) findViewById(R.id.et_edit_first_name);
		ViewHolder.et_LastName = (EditText) findViewById(R.id.et_edit_last_name);
		ViewHolder.et_WorkPlace = (EditText) findViewById(R.id.et_edit_workplace);
		ViewHolder.imv_ProfilePicture = (ImageView) findViewById(R.id.imv_edit_card_profile_picture);
		ViewHolder.imv_EditProfilePicture = (ImageView) findViewById(R.id.imv_edit_card_edit_picture);
		setUpEditProfilePicture();

	}

	@Override
	public void refreshViews() {
		ViewHolder.et_FirstName.setText(m_User.getFirstName());
		ViewHolder.et_LastName.setText(m_User.getLastName());
		ViewHolder.et_WorkPlace.setText(m_User.getWorkplace());
		refreshProfilePicture();
	}

	private void refreshProfilePicture() {
		if (_profilePicture != null) {
			ViewHolder.imv_ProfilePicture.setImageBitmap(_profilePicture);
			return;
		}
		if (m_User.getProfileImage() != null) {
			ViewHolder.imv_ProfilePicture.setImageBitmap(FileUtils
					.getBitmapFromByteArray(m_User.getProfileImage()));
		}
	};

	private void setUpEditProfilePicture() {
		ViewHolder.imv_EditProfilePicture
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(
								Intent.ACTION_PICK,
								android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
						startActivityForResult(
								Intent.createChooser(
										intent,
										getApplicationContext()
												.getString(
														R.string.activity_edit_card_select_picture)),
								INTENT_KEY_SELECT_PROFILE_PICURE);
					}
				});
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			if (requestCode == INTENT_KEY_SELECT_PROFILE_PICURE) {
				Uri _uri = data.getData();
				_profilePicture = FileUtils.getBitmap(_uri,
						getApplicationContext());
				if (_profilePicture != null) {
					ViewHolder.imv_ProfilePicture
							.setImageBitmap(_profilePicture);
					refreshProfilePicture();
				}
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		ActionBar actionBar = getActionBar();
		actionBar.setTitle(this.getString(R.string.activity_edit_card_title));
		actionBar.setHomeButtonEnabled(true);
		actionBar.setIcon(R.drawable.actionbar_back_button);

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_edit_card, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			this.finish();
			return true;
		case R.id.item_edit_card_save:
			saveUserCard();
			this.finish();
			return true;
		case R.id.item_edit_card_cancel:
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void saveUserCard() {
		m_User.setFirstName(ViewHolder.et_FirstName.getText().toString());
		m_User.setLastName(ViewHolder.et_LastName.getText().toString());
		m_User.setWorkplace(ViewHolder.et_WorkPlace.getText().toString());
		if (_profilePicture != null)
			m_User.setProfileImage(FileUtils
					.getByteArrayFromBitmap(_profilePicture));

		_appContext.getDaoSession().update(m_User);
	}

}
