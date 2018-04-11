package pro.rasht.ar.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import java.util.List;
import javax.sql.DataSource;
import pro.rasht.ar.R;


public class FragmentHome extends Fragment {



    private FragmentActivity contInst;
    private View view;
    private LinearLayoutManager mLayoutManager;

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
        contInst = getActivity();
        //java code













        ///java code
        return view;
    }





}
