package com.vlad.simion.filetransfer.utils;

import android.view.View;
import android.widget.TextView;

public class UIUtils {

	public static void setSafeText(TextView textView, String text) {
		if (textView != null) {
			if (!StringUtils.equals(textView.getText().toString(), text)) {
				textView.setText(text);
			}
		}
	}

	public static void setSafeVisibility(View v, int visibility) {
		if (v != null) {
			if (v.getVisibility() != visibility) {

				v.setVisibility(visibility);
			}
		}
	}

	public static void setSafeVisibility(View v, boolean visibility) {
		if (v != null) {
			if (visibility)
				v.setVisibility(View.VISIBLE);
			else
				v.setVisibility(View.GONE);
		}
	}

}
