package khw.geocom.handilibrary.view;

import android.gesture.GestureOverlayView;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import khw.geocom.handilibrary.R;

public class MapsActivity extends FragmentActivity implements MapView {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        initMap();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initMap();
    }

    private void initMap() {

        if (mMap == null) {

            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();

            if (mMap != null) {
                setUpMap();
            }
        }
    }


    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }

    @Override
    public SensorManager getSensorManger() {
        return (SensorManager) getSensorManger();
    }

    @Override
    public RelativeLayout getJoyStick() {
        return null;
    }

    @Override
    public GestureOverlayView getGesturePanel() {
        return null;
    }

    @Override
    public void setZoom(String Zoomset){

    }

    @Override
    public void move() {

    }
}
