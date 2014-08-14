package com.vlad.simion.filetransfer.utils;

import java.io.ByteArrayOutputStream;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

public class FileUtils {

	public static Bitmap getResizedBitmap(Bitmap image, int bitmapWidth,
			int bitmapHeight) {
		return Bitmap
				.createScaledBitmap(image, bitmapWidth, bitmapHeight, true);
	}

	public static Bitmap getBitmap(Uri _uri, Context _ctx) {
		Cursor cursor = _ctx
				.getContentResolver()
				.query(_uri,
						new String[] { android.provider.MediaStore.Images.ImageColumns.DATA },
						null, null, null);
		cursor.moveToFirst();
		String _selectedImagePath = cursor.getString(0);
		cursor.close();
		Bitmap _profilePicture = BitmapFactory.decodeFile(_selectedImagePath);
		return getResizedBitmap(_profilePicture, 120, 120);
	}

	public static byte[] getByteArrayFromBitmap(Bitmap _image) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		_image.compress(Bitmap.CompressFormat.PNG, 100, stream);
		byte[] byteArray = stream.toByteArray();
		return byteArray;
	}

	public static Bitmap getBitmapFromByteArray(byte[] _byteArray) {
		if (_byteArray != null) {
			Bitmap _bmp = BitmapFactory.decodeByteArray(_byteArray, 0,
					_byteArray.length);
			return _bmp;
		}
		return null;
	}
}
