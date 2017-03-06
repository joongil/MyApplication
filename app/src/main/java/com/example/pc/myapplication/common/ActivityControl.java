package com.example.pc.myapplication.common;

import android.app.Activity;

import java.util.ArrayList;

public class ActivityControl {

	private static ActivityControl activityMananger = null;
	private ArrayList<Activity> activityList = null;
	
	private ActivityControl() {
		activityList = new ArrayList<Activity>();
	}
	
	public static ActivityControl getInstance() {
		
		if( ActivityControl.activityMananger == null ) {
			activityMananger = new ActivityControl();
		}
		return activityMananger;
	}
	
	/**
	 * 액티비티 리스트 getter.
	 * @return activityList
	 */
	public ArrayList<Activity> getActivityList() {
		return activityList;
	}

	/**
	 * 액티비티 리스트에 추가.
	 * @param activity
	 */
	public void addActivity(Activity activity) {
		activityList.add(activity);
	}
	
	/**
	 * 액티비티 리스트에서 삭제.
	 * @param activity
	 * @return boolean
	 */
	public boolean removeActivity(Activity activity) {
		return activityList.remove(activity);
	}
	
	/**
	 * 모든 액티비티 종료.
	 */
	public void finishAllActivity() {
		// 액티비티 리스트 확인.
		Logs.e("모든 액티비티 확인..." + activityList.size());
		for (Activity activity : activityList) {
			Logs.e("종료!!" + activity.toString());
			activity.finish();
		}
	}
}
