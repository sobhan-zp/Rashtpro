package pro.rasht.ar.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import pro.rasht.ar.Classes.CircularImageView;
import pro.rasht.ar.R;

;

public class ProfileActivity extends Activity {


    @BindView(R.id.profile_image)
    CircularImageView profileImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

    }
}
