package pro.rasht.ar.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Gallery;

import java.util.ArrayList;
import java.util.List;

import pro.rasht.ar.Adapter.GalleryRecyclerAdapter;
import pro.rasht.ar.Data.Gallery_app;
import pro.rasht.ar.Model.GalleryModel;
import pro.rasht.ar.R;


public class FragmentGallery extends Fragment {




    private FragmentActivity context;
    private View view;
    private LinearLayoutManager mLayoutManager;


    private List<GalleryModel> itemList = new ArrayList<>();
    private RecyclerView rv_gallery;
    private GalleryRecyclerAdapter adapter;
    

    public static FragmentGallery newInstance() {

        Bundle args = new Bundle();
        FragmentGallery fragment = new FragmentGallery();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gallery, container, false);
        context = getActivity();
        //java code




        rv_gallery = (RecyclerView)view.findViewById(R.id.rv_gallery);
        adapter = new GalleryRecyclerAdapter(context, itemList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context);
        rv_gallery.setLayoutManager(mLayoutManager);
        rv_gallery.setItemAnimator(new DefaultItemAnimator());
        rv_gallery.setAdapter(adapter);




        itemList.addAll(new Gallery_app().getData());
        adapter.notifyDataSetChanged();







        ///java code
        return view;
    }





}
