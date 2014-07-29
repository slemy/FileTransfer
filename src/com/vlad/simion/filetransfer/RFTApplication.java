package com.vlad.simion.filetransfer;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.vlad.simion.filetransfer.DaoMaster.DevOpenHelper;
import com.vlad.simion.filetransfer.platform.Constants;
import com.vlad.simion.filetransfer.utils.DeviceInformationUtils;

public class RFTApplication extends Application {

	public static RFTApplication INSTANCE;
	
	private SQLiteDatabase m_Database;
	private static DaoMaster m_DaoMaster;
	private static DaoSession m_DaoSession;

	@Override
	public void onCreate() {
		super.onCreate();
		INSTANCE = this;
		DeviceInformationUtils.setCurrentUserOnApplicationStart(this);
		
		greenDaoDatabaseInit();
	}
	
	private void greenDaoDatabaseInit() {
		DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, Constants.DATABASE_NAME, null);
		m_Database =  helper.getWritableDatabase();
		m_DaoMaster = new DaoMaster(m_Database);
		m_DaoSession = m_DaoMaster.newSession();
	}

	static public Context getContext() {
		return INSTANCE;
	}
	
	public static DaoMaster getDaoMaster(){
		return m_DaoMaster;
	}
	
	public static DaoSession getDaoSession(){
		return m_DaoSession;
	}

}
