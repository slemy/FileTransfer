package com.vlad.simion.filetransfer.DataObjects.User;

import java.io.ByteArrayOutputStream;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import android.util.Base64;

import com.google.gson.Gson;
import com.vlad.simion.filetransfer.RFTApplication;
import com.vlad.simion.filetransfer.utils.DeviceInformationUtils;

public class UserOperations {

	public static void persistUser(){
		User p_CurrentUser = User.getUser();
		SharedPreferences p_SPrefs =  PreferenceManager.getDefaultSharedPreferences(RFTApplication.getContext());		
		Gson p_UserGson = new Gson();
		
		Editor prefsEditor = p_SPrefs.edit();
		String newJson = p_UserGson.toJson(p_CurrentUser);
		prefsEditor.putString(DeviceInformationUtils.KEY_CURRENT_USER, newJson);
		prefsEditor.commit();
	}
	
	public static void saveUserImage(String _pathToImage){
		Bitmap p_FullImage = BitmapFactory.decodeFile(_pathToImage);
		ByteArrayOutputStream p_Baos = new ByteArrayOutputStream();
		p_FullImage.compress(Bitmap.CompressFormat.JPEG, 100, p_Baos);
		
		byte[] imgBytes = p_Baos.toByteArray();
		String encodedImage = Base64.encodeToString(imgBytes, Base64.DEFAULT);
		
		User.getUser().set_EncodedImage(encodedImage);
		UserOperations.persistUser();
	}
		
}
