package pro.rasht.ar.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gjiazhe.panoramaimageview.GyroscopeObserver;
import com.gjiazhe.panoramaimageview.PanoramaImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pro.rasht.ar.R;


public class FragmentHome extends Fragment {


    @BindView(R.id.cv_ar_home)
    CardView cvArHome;
    @BindView(R.id.cv_vr_home)
    CardView cvVrHome;
    Unbinder unbinder;





    private FragmentActivity context;
    private View view;
    private LinearLayoutManager mLayoutManager;

    private GyroscopeObserver gyroscopeObserver;

    public static FragmentHome newInstance() {

        Bundle args = new Bundle();
        FragmentHome fragment = new FragmentHome();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        context = getActivity();
        //java code

        gyroscopeObserver = new GyroscopeObserver();

        PanoramaImageView panoramaImageView = (PanoramaImageView)view.findViewById(R.id.panorama_image_view);
        panoramaImageView.setGyroscopeObserver(gyroscopeObserver);


        ///java code
        unbinder = ButterKnife.bind(this, view);
        return view;
    }








    @Override
    public void onResume() {
        super.onResume();
        gyroscopeObserver.register(context);
    }

    @Override
    public void onPause() {
        super.onPause();
        gyroscopeObserver.unregister();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
