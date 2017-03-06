package com.example.pc.myapplication.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonActivity extends Activity {
	public static Context mContext;
	public static ActivityControl am = ActivityControl.getInstance();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		am.addActivity(this);
	}
	
//	/**
//	 * 수동 자동 실행 모드 프리퍼런스에 저장
//	 * @author	: JoonGil
//	 * @param 	: mode : false = 수동, true = 자동
//	 * @return	: void
//	 */
//	public void setAutoPlayMode(boolean mode){
//		SharedPreferences pref = getSharedPreferences("TTSPlayer", Activity.MODE_PRIVATE);
//		SharedPreferences.Editor pEeditor = pref.edit();
//		pEeditor.putBoolean("AutoMode", mode);
//		pEeditor.commit();
//	}
//
//	/**
//	 * 수동 자동 듣기 모드
//	 * 마지막에 종료 할것인지 묻는 것과 또는 자동 첨부터 반복되는 기능
//	 * @author	: JoonGil
//	 * @return	: 수동 자동 모드를 true false로 체크
//	 */
//	public boolean getAutoListenMode(){
//		SharedPreferences pref = getSharedPreferences("TTSPlayer", Activity.MODE_PRIVATE);
//		return pref.getBoolean("AutoListenMode", false);
//	}

	/**
	 * 다이얼로그
	 * @author	: JoonGil
	 * @param	: message             =
	 * @param	: positiveButtonText  =
	 * @param	: positiveListener    =
	 * @return	: void
	 */
	public void showDialog(String message, String positiveButtonText, DialogInterface.OnClickListener positiveListener) {
        new AlertDialog.Builder(this).setMessage(message).setPositiveButton(positiveButtonText, positiveListener).create().show();
    }
	
	public void showDialog(String message, String positiveButtonText, DialogInterface.OnClickListener positiveListener, String negativeButtonText, DialogInterface.OnClickListener negativeListener) {
        new AlertDialog.Builder(this).setMessage(message).setPositiveButton(positiveButtonText, positiveListener).setNegativeButton(negativeButtonText, negativeListener).create().show();
    }
	
	/**
     * 현재 시간 가져오기
     * @author	: JoonGil
     * @return	: String = 현재 시간
     */
	public static String getNowTime() {
		long time = System.currentTimeMillis();
	
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(time);
		  
		return formater.format(date);
	}
	
	/**
	 * 커스텀 토스트
	 * @author	: JoonGil
	 * @param	: text : 표시할 텍스트 값
	 * @return	: void
	 */
	protected void toastCustom(String text) {

		LayoutInflater inflater = getLayoutInflater();
		View layout = inflater.inflate(R.layout.toast_border, (ViewGroup) findViewById(R.id.toast_layout_root));
		TextView contents = (TextView) layout.findViewById(R.id.text);
		Toast toast = new Toast(mContext);
		contents.setText(text);
		toast.setGravity(Gravity.BOTTOM, 0, 50);
		toast.setDuration(Toast.LENGTH_SHORT);

		toast.setView(layout);
		toast.show();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		am.removeActivity(this);
	}
}
