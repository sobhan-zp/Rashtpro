package pro.rasht.ar.Fragment;

import android.content.Context;
import android.content.Intent;
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
import android.widget.ImageView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pro.rasht.ar.ArModuls.ArModulActivity;
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

    private ImageView gyroscopeObserver;

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

        ImageView panoramaImageView = (ImageView)view.findViewById(R.id.panorama_image_view);
        unbinder = ButterKnife.bind(this, view);


        cvArHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, ArModulActivity.class));
            }
        });

        return view;
    }









    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
