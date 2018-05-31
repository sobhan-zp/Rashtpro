package pro.rasht.ar.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AutoCompleteTextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.suke.widget.SwitchButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pro.rasht.ar.R;

import static android.content.ContentValues.TAG;


public class FragmentMap extends Fragment implements OnMapReadyCallback,
        GoogleApiClient.OnConnectionFailedListener {


    Unbinder unbinder;
    @BindView(R.id.ic_gps)
    FloatingActionButton icGps;
    @BindView(R.id.sw_theme_map)
    SwitchButton swThemeMap;
    @BindView(R.id.input_search)
    AutoCompleteTextView inputSearch;

    //vars
    private GoogleMap mMap;



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

        SupportMapFragment mapFragment =
                (SupportMapFragment)context.getSupportFragmentManager().findFragmentById(R.id.map);




        //swThemeMap.isChecked();
        //swThemeMap.toggle();     //switch state
        swThemeMap.toggle(true);//switch without animation
        swThemeMap.setShadowEffect(true);//disable shadow effect
        //swThemeMap.setEnabled(false);//disable button
        swThemeMap.setEnableEffect(true);//disable the switch animation


       // mapFragment.getMapAsync(this);
        ///java code
        return view;
    }






    @Override
    public void onMapReady(final GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());

        mMap = googleMap;
        swThemeMap.setChecked(false);


        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            context, R.raw.mapstyle_dark));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }
        // Position the map's camera near Sydney, Australia.
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(-34, 151)));
    }




       /* googleMap.setMapStyle(
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
        });*/












    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}


