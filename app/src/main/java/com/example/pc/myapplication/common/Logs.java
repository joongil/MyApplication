package com.example.pc.myapplication.common;

public class Logs {
	/**
	 * log.e 를 사용하여 로그를 표시한다.
	 * @author	: JoonGil
	 * @param txt 출력할 스트링 값
	 */
    public static void e(String txt) {
        if (Controller.release){
            return;
        }
        android.util.Log.e(Controller.tag, txt);
    }
}
