package khw.geocom.handilibrary.controller;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import java.util.ArrayList;

import khw.geocom.handilibrary.view.MapView;


public class AirGestureControl implements MapContoller, SensorEventListener {

    MapView mapView;
    Sensor ProximitySensor;
    Sensor LightSensor;
    boolean isHover = false;
    ArrayList<Float> light_val = new ArrayList<Float>();

    public AirGestureControl(MapView view) {
        this.mapView = view;
        this.ProximitySensor = mapView.getSensorManger().getDefaultSensor(Sensor.TYPE_PROXIMITY);
        this.LightSensor = mapView.getSensorManger().getDefaultSensor(Sensor.TYPE_LIGHT);
        mapView.getSensorManger().registerListener(this, ProximitySensor, SensorManager.SENSOR_DELAY_FASTEST);
        mapView.getSensorManger().registerListener(this, LightSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {

            // 0
            if (event.values[0] == 0.0)
                isHover = true;
                // 5
            else
                isHover = false;

            /*Prox_val = event.values[0];
            Log.e("Prox_val", String.valueOf(Prox_val));*/


        } else if (event.sensor.getType() == Sensor.TYPE_LIGHT) {

            if (isHover) {

                Log.e("Light_val", String.valueOf(event.values[0]));
                light_val.add(event.values[0]);


                //크기 체크
                if (light_val.size() == 2) {


                    // 기울기 계산
                    String Bval = slope();

                    if (Bval.equals("big")) {
                        //확대
                        mapView.setZoom("zoomIn");
                        Log.e("Bval", "확대");
                    } else if(Bval.equals("small"))  {
                        //축소
                        mapView.setZoom("zoomOut");
                        Log.e("Bval", "축소");
                    }

                    // 초기화

                    light_val.clear();
                }


            }


        }
    }

    public String slope() {

        Object[] Light_val = light_val.toArray();

        String Bval = ",";
        int plus = 0;
        int minus = 0;

        for (int i = 1; i < Light_val.length; i++) {

         float slope_val = (float) Light_val[0] - (float) Light_val[i];

            if (slope_val > 0) {

                Bval = "small";
            } else if (slope_val < 0) {

                Bval = "big";
            }
        }



//        for (int i = 1; i < Light_val.length; i++) {
//
////            float slope_val= ((float) Light_val[0]-0)/(0-(float) Light_val[i]);
//            float slope_val = (float) Light_val[0] - (float) Light_val[i];
//
//            if (slope_val > 0) {
//                minus++;
//            } else if (slope_val < 0) {
//                plus++;
//            }
//        }
//
//        if (plus < minus) {
//            Bval = "small";
//
//        }if (plus > minus) {
//            Bval = "big";
//
//        }

        return Bval;
    }
}