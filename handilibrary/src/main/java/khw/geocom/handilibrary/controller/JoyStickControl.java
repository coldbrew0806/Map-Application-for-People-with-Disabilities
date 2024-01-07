package khw.geocom.handilibrary.controller;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

import khw.geocom.handilibrary.view.MapView;

public class JoyStickControl implements MapContoller,View.OnTouchListener {
    MapView mapView;
    private Context mContext;

    public JoyStickControl(MapView view) {
        this.mapView = view;


}



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}