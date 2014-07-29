package com.vlad.simion.filetransfer.utils;

import java.util.regex.Pattern;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Patterns;

import com.google.gson.Gson;
import com.vlad.simion.filetransfer.DataObjects.User.User;
import com.vlad.simion.filetransfer.platform.constants.DefaultAccountConstants;

public class DeviceInformationUtils {
	
	public static final String KEY_CURRENT_USER = "KEY_CURRENT_USER";

	public static String getDevicePrimaryEmail(Context _context) {
		Pattern emailPattern = Patterns.EMAIL_ADDRESS;
		Account[] accounts = AccountManager.get(_context).getAccounts();
		for (Account account : accounts) {
			if (emailPattern.matcher(account.name).matches()) {
				return account.name;
			}
		}
		return DefaultAccountConstants.DEFAULT_NO_EMAIL_ADDRESS;
	}
	
	public static void setCurrentUserOnApplicationStart(Context _context){
		SharedPreferences p_SPrefs =  PreferenceManager.getDefaultSharedPreferences(_context);		
		String p_Json = p_SPrefs.getString(KEY_CURRENT_USER, null);
		Gson p_UserGson = new Gson();
		
		if(p_Json != null){			
			User p_User = p_UserGson.fromJson(p_Json, User.class);
			User.setUser(p_User);
		}
		else{
			String p_Email = DeviceInformationUtils.getDevicePrimaryEmail(_context);
			
			User p_CurrentUser = User.getUser();
			p_CurrentUser.set_Email(p_Email);
			
			Editor prefsEditor = p_SPrefs.edit();
			String newJson = p_UserGson.toJson(p_CurrentUser);
			prefsEditor.putString(KEY_CURRENT_USER, newJson);
			prefsEditor.commit();
		}	
	}
		
}
