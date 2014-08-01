package com.vlad.simion.filetransfer.DataObjects.User;

import android.content.Context;

import com.vlad.simion.filetransfer.RFTApplication;
import com.vlad.simion.filetransfer.UserEntity;
import com.vlad.simion.filetransfer.utils.DeviceInformationUtils;

public class UserBO {

	public static UserEntity getCurrentUser(Context _context) {
	
		RFTApplication _app = (RFTApplication) _context;
		
		UserEntity _userEntity;
		if (_app.getUserEntityDao().loadAll().size() > 0){
			UserEntity _entity = _app.getUserEntityDao().loadAll().get(0);
			return _entity;
		}
		else{
			_userEntity = new UserEntity(null, DeviceInformationUtils.getDevicePrimaryEmail(_context),null,DeviceInformationUtils.getDevicePrimaryEmail(_context), null,null);
			_app.getUserEntityDao().insert(_userEntity);
		}

		return _userEntity;

	}

}
