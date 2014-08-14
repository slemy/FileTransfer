package com.vlad.simion.filetransfer;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.vlad.simion.filetransfer.DaoMaster.DevOpenHelper;
import com.vlad.simion.filetransfer.DataObjects.User.UserBO;
import com.vlad.simion.filetransfer.platform.Constants;
import com.vlad.simion.filetransfer.ui.activities.RFTMainActivity;
import com.vlad.simion.filetransfer.utils.StringUtils;

public class RFTApplication extends Application {

	public static RFTApplication INSTANCE;
	private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

	private SQLiteDatabase m_Database;
	private DaoMaster m_DaoMaster;
	private DaoSession m_DaoSession;
	private UserEntityDao m_UserEntityDao;
	private UserEntity m_User;


	@Override
	public void onCreate() {
		super.onCreate();
		INSTANCE = this;
		greenDaoDatabaseInit();
	}

	private void greenDaoDatabaseInit() {
		DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,
				Constants.DATABASE_NAME, null);
		m_Database = helper.getWritableDatabase();
		m_DaoMaster = new DaoMaster(m_Database);
		m_DaoSession = m_DaoMaster.newSession();
		m_UserEntityDao = m_DaoSession.getUserEntityDao();
		m_User = UserBO.getCurrentUser(getApplicationContext());
	}

	static public Context getContext() {
		return INSTANCE;
	}

	public DaoMaster getDaoMaster() {
		return m_DaoMaster;
	}

	public DaoSession getDaoSession() {
		return m_DaoSession;
	}

	public UserEntityDao getUserEntityDao() {
		return m_UserEntityDao;
	}

	public UserEntity getUser() {
		return m_User;
	}

}
