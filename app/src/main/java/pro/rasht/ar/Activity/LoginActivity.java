package pro.rasht.ar.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.rasht.ar.Fragment.BodyActivity;
import pro.rasht.ar.R;
import za.co.riggaroo.materialhelptutorial.TutorialItem;
import za.co.riggaroo.materialhelptutorial.tutorial.MaterialTutorialActivity;

public class LoginActivity extends AppCompatActivity implements ImageLoadingListener {

    private static final int REQUEST_CODE = 1234;
    SharedPreferences prefs;


    @BindView(R.id.btn_login_login)
    Button btnLoginLogin;


    private GoogleApiClient client;

    //background
    private KenBurnsView mImg;
    private ProgressBar mProgressBar;
    private ImageLoaderConfiguration config;
    private File cacheDir;
    private DisplayImageOptions options;
    private ImageLoader imageLoader = ImageLoader.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        // Start code for Intro App
        prefs = getSharedPreferences("pro.rasht.ar", MODE_PRIVATE);
        if (prefs.getBoolean("firstrun", true)) {
            loadTutorial();
            prefs.edit().putBoolean("firstrun", false).commit();
        }
//        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        // End code for Intro App



        // Start code for Background Page
        mImg = (KenBurnsView) findViewById(R.id.img);
        mProgressBar = (ProgressBar) findViewById(android.R.id.progress);
        loadImage();
        // End code for Background Page


        btnLoginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this , BodyActivity.class));
            }
        });

    }


    // Start code for Background Page
    private void loadImage() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            String cacheDirName = "." + getString(R.string.app_name);
            cacheDir = new File(Environment.getExternalStorageDirectory(), cacheDirName);
        } else {
            cacheDir = getCacheDir();
        }
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }

        config = new ImageLoaderConfiguration.Builder(this)
                .memoryCache(new WeakMemoryCache())
                .denyCacheImageMultipleSizesInMemory()
                .diskCache(new UnlimitedDiscCache(cacheDir))
                .threadPoolSize(5)
                .build();

        options = new DisplayImageOptions.Builder()
                .bitmapConfig(Bitmap.Config.RGB_565)
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .build();

        imageLoader.init(config);

        imageLoader.displayImage("http://loper.ir/Rasht-Pro/bg_login.png", mImg, options, this);

    }


    @Override
    public void onLoadingStarted(String imageUri, View view) {

    }


    @Override
    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
        Toast.makeText(getApplicationContext(), "Failed to load image.", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
        mProgressBar.setVisibility(View.GONE);
        mImg.setVisibility(View.VISIBLE);
    }


    @Override
    public void onLoadingCancelled(String imageUri, View view) {

    }


    // Start code for Intro App
    public void loadTutorial() {
        Intent mainAct = new Intent(this, MaterialTutorialActivity.class);
        mainAct.putParcelableArrayListExtra(MaterialTutorialActivity.MATERIAL_TUTORIAL_ARG_TUTORIAL_ITEMS, getTutorialItems(this));
        startActivityForResult(mainAct, REQUEST_CODE);

    }

    private ArrayList<TutorialItem> getTutorialItems(Context context) {
        TutorialItem tutorialItem1 = new TutorialItem(R.string.slide1_title, R.string.slide1_subtitle,
                R.color.slide1, R.drawable.tut_page_3_foreground, R.drawable.tut_page_3_foreground);
        TutorialItem tutorialItem2 = new TutorialItem(R.string.slide2_title, R.string.slide2_subtitle,
                R.color.slide2, R.drawable.tut_page_3_foreground, R.drawable.tut_page_3_foreground);
        TutorialItem tutorialItem3 = new TutorialItem(R.string.slide3_title, R.string.slide3_subtitle,
                R.color.slide3, R.drawable.tut_page_3_foreground, R.drawable.tut_page_3_foreground);
        TutorialItem tutorialItem4 = new TutorialItem(R.string.slide4_title, R.string.slide4_subtitle,
                R.color.slide4, R.drawable.tut_page_3_foreground, R.drawable.tut_page_3_foreground);


        ArrayList<TutorialItem> tutorialItems = new ArrayList<>();
        tutorialItems.add(tutorialItem1);
        tutorialItems.add(tutorialItem2);
        tutorialItems.add(tutorialItem3);
        tutorialItems.add(tutorialItem4);

        return tutorialItems;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //    super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            Toast.makeText(this, "Tutorial finished", Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        /*client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://pro.rasht.ar/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);*/
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        /*Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://pro.rasht.ar/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();*/
    }
    // End code for Intro App
}
