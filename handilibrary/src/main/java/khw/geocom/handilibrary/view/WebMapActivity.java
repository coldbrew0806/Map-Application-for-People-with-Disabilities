package khw.geocom.handilibrary.view;

import android.app.Activity;
import android.gesture.GestureOverlayView;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import khw.geocom.handilibrary.R;

public class WebMapActivity extends Activity implements MapView {
            WebView mapView;
            boolean isCreateMode = false;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_web);
                String url = savedInstanceState.getString("url");

        initWebMap(url);
    }

    private void initWebMap(String url){
        mapView = (WebView) this.findViewById(R.id.webmap);
        mapView.getSettings().setJavaScriptEnabled(true);
        mapView.getSettings().setBuiltInZoomControls(true);
        mapView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mapView.getSettings().setSaveFormData(true);
        mapView.setWebViewClient(new WebMapClient());
        mapView.loadUrl(url);
    }

    @Override
    public void setZoom(String Zoomset) {
        if(Zoomset.equals("zoomIn")){
                mapView.loadUrl("javascript:handiJS.zoomIn()");
        }else if(Zoomset.equals("zoomOut")){
            mapView.loadUrl("javascript:handiJS.zoomOut()");
        }
    }

    @Override
    public void move() {



    }

    private class WebMapClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public SensorManager getSensorManger() {

        return (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    public RelativeLayout getJoyStick() {


        return null;
    }

    @Override
      public GestureOverlayView getGesturePanel() {

        return null;
        //return (GestureOverlayView) findViewById(R.id.dogestures);
    }


}
