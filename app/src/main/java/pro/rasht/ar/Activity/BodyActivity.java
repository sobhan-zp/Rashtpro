package pro.rasht.ar.Activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;

import butterknife.BindView;
import butterknife.ButterKnife;
import pro.rasht.ar.Fragment.Items_Viewpager_market;
import pro.rasht.ar.Fragment.NonSwipeableViewPager;
import pro.rasht.ar.R;

public class BodyActivity extends AppCompatActivity {

    @BindView(R.id.img_profile_body)
    ImageView imgProfileBody;
    @BindView(R.id.tv_profile_body)
    TextView tvProfileBody;
    @BindView(R.id.img_map_body)
    ImageView imgMapBody;
    @BindView(R.id.tv_map_body)
    TextView tvMapBody;
    @BindView(R.id.img_music_body)
    ImageView imgMusicBody;
    @BindView(R.id.tv_music_body)
    TextView tvMusicBody;
    @BindView(R.id.img_gallery_body)
    ImageView imgGalleryBody;
    @BindView(R.id.tv_gallery_body)
    TextView tvGalleryBody;
    @BindView(R.id.img_home_body)
    ImageView imgHomeBody;
    @BindView(R.id.tv_home_body)
    TextView tvHomeBody;
    @BindView(R.id.viewpager)
    NonSwipeableViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);
        ButterKnife.bind(this);


        pager = (NonSwipeableViewPager) findViewById(R.id.viewpager);
        Items_Viewpager_market adapter_articles = new Items_Viewpager_market(getSupportFragmentManager());
        pager.setAdapter(adapter_articles);
        pager.setCurrentItem(4, false);
        pager.setOffscreenPageLimit(4);


        //defult property View
        tvProfileBody.setVisibility(View.VISIBLE);
        setPermission_Camera();

        //Bottom Navigation

    }

    //for Permission
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 12234: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    //dastrasi dade shode

                } else {
                    new AlertDialog.Builder(this)
                            .setMessage("برای اجرای برنامه باید حتما دسترسی رو به برنامه بدهید")
                            .setCancelable(false)
                            .setNegativeButton("دادن دسترسی", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    setPermission_Camera();

                                }
                            })
                            .show();
                }
            }
            return;
        }
    }

    //checkPermission
    public void setPermission_Camera() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 12234);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 12234);
            }
        }
    }


    public void onCLickHome(View v) {
        setVisibiltyBottomBar(tvHomeBody);
        Animation animation = new TranslateAnimation(0, 0, 15, 0);
        Animation animation1 = new TranslateAnimation(0, 0, 70, 0);
        animation.setDuration(300);
        animation1.setDuration(200);
        imgHomeBody.startAnimation(animation);
        tvHomeBody.startAnimation(animation1);

        pager.setCurrentItem(0);
    }

    public void onCLickGallery(View v) {
        setVisibiltyBottomBar(tvGalleryBody);
        Animation animation = new TranslateAnimation(0, 0, 15, 0);
        Animation animation1 = new TranslateAnimation(0, 0, 70, 0);
        animation.setDuration(300);
        animation1.setDuration(200);
        imgGalleryBody.startAnimation(animation);
        tvGalleryBody.startAnimation(animation1);

        pager.setCurrentItem(1);
    }

    public void onCLickMusic(View v) {
        setVisibiltyBottomBar(tvMusicBody);
        Animation animation = new TranslateAnimation(0, 0, 15, 0);
        Animation animation1 = new TranslateAnimation(0, 0, 70, 0);
        animation.setDuration(300);
        animation1.setDuration(200);
        imgMusicBody.startAnimation(animation);
        tvMusicBody.startAnimation(animation1);

        pager.setCurrentItem(2);
    }

    public void onCLickMap(View v) {
        setVisibiltyBottomBar(tvMapBody);
        Animation animation = new TranslateAnimation(0, 0, 15, 0);
        Animation animation1 = new TranslateAnimation(0, 0, 70, 0);
        animation.setDuration(300);
        animation1.setDuration(200);
        imgMapBody.startAnimation(animation);
        tvMapBody.startAnimation(animation1);

        pager.setCurrentItem(3);


    }

    public void onCLickProfile(View v) {
        setVisibiltyBottomBar(tvProfileBody);
        Animation animation = new TranslateAnimation(0, 0, 15, 0);
        Animation animation1 = new TranslateAnimation(0, 0, 70, 0);
        animation.setDuration(300);
        animation1.setDuration(200);
        imgProfileBody.startAnimation(animation);
        tvProfileBody.startAnimation(animation1);

        pager.setCurrentItem(4);
    }


    /*protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(this, data);

                PendingResult<PlaceBuffer> placeResult = Places.GeoDataApi
                        .getPlaceById(mGoogleApiClient, place.getId());
                placeResult.setResultCallback(mUpdatePlaceDetailsCallback);
            }
        }
    }*/



    //method set visible bottom bar
    public void setVisibiltyBottomBar(TextView tv) {
        tvHomeBody.setVisibility(View.GONE);
        tvGalleryBody.setVisibility(View.GONE);
        tvMusicBody.setVisibility(View.GONE);
        tvMapBody.setVisibility(View.GONE);
        tvProfileBody.setVisibility(View.GONE);
        tv.setVisibility(View.VISIBLE);
    }
}

