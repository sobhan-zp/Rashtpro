package pro.rasht.ar.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pro.rasht.ar.R;


public class FragmentMusic extends Fragment {



    private FragmentActivity contInst;
    private View view;
    private LinearLayoutManager mLayoutManager;

    public static FragmentMusic newInstance() {

        Bundle args = new Bundle();
        FragmentMusic fragment = new FragmentMusic();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_music, container, false);
        contInst = getActivity();
        //java code













        ///java code
        return view;
    }





}
