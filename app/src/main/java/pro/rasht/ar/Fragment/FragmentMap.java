package pro.rasht.ar.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.suke.widget.SwitchButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pro.rasht.ar.R;

import static com.google.android.gms.maps.model.BitmapDescriptorFactory.fromResource;


public class FragmentMap extends Fragment implements OnMapReadyCallback {


    static final LatLng abojafar = new LatLng(37.279088, 49.583653);
    static final LatLng pirsara = new LatLng(37.275186, 49.573086);
    static final LatLng darvishmokhles = new LatLng(37.275522, 49.571745);
    static final LatLng chomasara = new LatLng(37.275934, 49.567535);
    static final LatLng karfabad = new LatLng(37.272923, 49.571907);
    static final LatLng bisetoon = new LatLng(37.277112, 49.574916);


    Unbinder unbinder;
    @BindView(R.id.sw_theme_map)
    SwitchButton swThemeMap;




    private GoogleMap mMap;
    private MapView mMapView;


    private FragmentActivity context;
    private View view;
    private LinearLayoutManager mLayoutManager;

    public static FragmentMap newInstance() {

        Bundle args = new Bundle();
        FragmentMap fragment = new FragmentMap();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_map, container, false);
        context = getActivity();
        unbinder = ButterKnife.bind(this, view);
        //java code

        //swThemeMap.isChecked();
        //swThemeMap.toggle();     //switch state
        swThemeMap.toggle(true);//switch without animation
        swThemeMap.setShadowEffect(true);//disable shadow effect
        //swThemeMap.setEnabled(false);//disable button
        swThemeMap.setEnableEffect(true);//disable the switch animation



        ///java code

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        mMapView = (MapView) view.findViewById(R.id.map);

        if (mMapView != null) {
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);

        }


    }


    @Override
    public void onStart() {
        super.onStart();
        mMapView.onStart();
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());

        mMap = googleMap;
        swThemeMap.setChecked(false);

        googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                        context, R.raw.mapstyle_light));


        swThemeMap.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {

                if (isChecked)
                    googleMap.setMapStyle(
                            MapStyleOptions.loadRawResourceStyle(
                                    context, R.raw.mapstyle_dark));

                else
                    googleMap.setMapStyle(
                            MapStyleOptions.loadRawResourceStyle(
                                    context, R.raw.mapstyle_light));

            }
        });


        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        googleMap.addMarker(new MarkerOptions().position(abojafar)
                .title("بقعه ابوجعفر")
                .icon(fromResource(R.mipmap.ic_place)));

        googleMap.addMarker(new MarkerOptions().position(pirsara)
                .title("مسجد و بقعه پیرسرا")
                .icon(fromResource(R.mipmap.ic_place)));

        googleMap.addMarker(new MarkerOptions().position(darvishmokhles)
                .title("مسجد دوریش مخلص")
                .icon(fromResource(R.mipmap.ic_place)));

        googleMap.addMarker(new MarkerOptions().position(chomasara)
                .title("مسجد چمارسرا")
                .icon(fromResource(R.mipmap.ic_place)));

        googleMap.addMarker(new MarkerOptions().position(karfabad)
                .title("مسجد کرف آباد")
                .icon(fromResource(R.mipmap.ic_place)));

        googleMap.addMarker(new MarkerOptions().position(bisetoon)
                .title("مسجد سمیع بزاز (بیستون)")
                .icon(fromResource(R.mipmap.ic_place)));

        googleMap.getUiSettings().setZoomControlsEnabled(true);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    /*private void getMyLocation() {
        LatLng latLng = new LatLng(Double.parseDouble(getLatitude()), Double.parseDouble(getLongitude()));
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 18);
        mMap.animateCamera(cameraUpdate);
    }*/


}


