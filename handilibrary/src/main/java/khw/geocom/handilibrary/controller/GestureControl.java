package khw.geocom.handilibrary.controller;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;

import java.io.File;

import khw.geocom.handilibrary.view.MapView;

public class GestureControl implements MapContoller, GestureOverlayView.OnGesturePerformedListener, GestureOverlayView.OnGestureListener {

    private GestureLibrary gLibrary;
    private File StoreFile = new File(Environment.getExternalStorageDirectory(), "gestures");

    private MapView mapView;

    public GestureControl(MapView mavView){
        this.mapView = mavView;
        mapView.getGesturePanel().addOnGesturePerformedListener(this);
        Log.i("path", Environment.getExternalStorageDirectory().getAbsolutePath());
        if(gLibrary == null)
            gLibrary = GestureLibraries.fromFile(StoreFile);
    }

    @Override
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
       /* ArrayList<Prediction> predictions = gLibrary.recognize(gesture);
        for (Prediction p : predictions) {

        }*/
    }

    @Override
    public void onGestureStarted(GestureOverlayView overlay, MotionEvent event) {

    }

    @Override
    public void onGesture(GestureOverlayView overlay, MotionEvent event) {

    }

    @Override
    public void onGestureEnded(GestureOverlayView overlay, MotionEvent event) {

    }

    @Override
    public void onGestureCancelled(GestureOverlayView overlay, MotionEvent event) {

    }
}
