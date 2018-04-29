package pro.rasht.ar.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pro.rasht.ar.R;

;

public class FragmentProfile extends Fragment {


    @BindView(R.id.btn_insert_profile)
    Button btnInsertProfile;

    Unbinder unbinder;
    private FragmentActivity contInst;
    private View view;
    private LinearLayoutManager mLayoutManager;

    public static FragmentProfile newInstance() {

        Bundle args = new Bundle();
        FragmentProfile fragment = new FragmentProfile();
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
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
