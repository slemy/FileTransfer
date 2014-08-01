package com.vlad.simion.filetransfer.utils;

import java.util.regex.Pattern;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.Patterns;

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
			
}
