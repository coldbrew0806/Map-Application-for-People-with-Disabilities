package khw.geocom.handimap;

import android.os.Bundle;

import khw.geocom.handilibrary.controller.AirGestureControl;
import khw.geocom.handilibrary.controller.MapContoller;
import khw.geocom.handilibrary.view.WebMapActivity;
public class MainActivity extends WebMapActivity {

    MapContoller mapInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle = new Bundle();
        bundle.putString("url", "http://210.107.208.92:8080/HandiWebMap/MapPage.jsp");
        super.onCreate(bundle);

    mapInterface = new AirGestureControl(this);
//        mapInterface = new JoyStickControl(this);

    }

}
