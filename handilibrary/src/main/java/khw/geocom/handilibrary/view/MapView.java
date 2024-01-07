package khw.geocom.handilibrary.view;

import android.gesture.GestureOverlayView;
import android.hardware.SensorManager;
import android.widget.RelativeLayout;

public interface MapView {
    public SensorManager getSensorManger();
    public RelativeLayout getJoyStick();
    public GestureOverlayView getGesturePanel();

    public void setZoom(String Zoomset);
    public void move();
}
