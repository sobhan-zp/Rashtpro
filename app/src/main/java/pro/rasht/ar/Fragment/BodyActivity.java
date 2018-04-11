package pro.rasht.ar.Fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
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
        pager.setCurrentItem(5, false);
        pager.setOffscreenPageLimit(5);


        //defult property View
        imgHomeBody.setVisibility(View.VISIBLE);


        //Bottom Navigation

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

