package com.channeloffdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * Created by zq on 2016/11/12.
 */

public class DomeActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//添加界面
		setContentView(R.layout.main);
	}

	/****
	 * 键盘监听
	 * @param event
	 * @return
	 */
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
			if (event.getAction() == KeyEvent.ACTION_DOWN
					&& event.getRepeatCount() == 0) {
				setResult(1);
				finish();
			}
			return true;
		}
		return super.dispatchKeyEvent(event);
	}

}
