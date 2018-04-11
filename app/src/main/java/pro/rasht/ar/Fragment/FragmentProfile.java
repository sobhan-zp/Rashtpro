package pro.rasht.ar.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import pro.rasht.ar.Classes.CircularImageView;
import pro.rasht.ar.R;

;

public class FragmentProfile extends Fragment {



    private FragmentActivity contInst;
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
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        contInst = getActivity();
        //java code













        ///java code
        return view;
    }





}
