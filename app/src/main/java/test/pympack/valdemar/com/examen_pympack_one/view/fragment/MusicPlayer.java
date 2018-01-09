package test.pympack.valdemar.com.examen_pympack_one.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import test.pympack.valdemar.com.examen_pympack_one.BackgroundSoundService;
import test.pympack.valdemar.com.examen_pympack_one.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MusicPlayer extends Fragment implements View.OnClickListener{

    private Button mBtnPlay;
    private Button mBtnStop;


    public MusicPlayer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_music_player, container, false);

        mBtnPlay = v.findViewById(R.id.btnPlay);
        mBtnStop = v.findViewById(R.id.btnStop);

        mBtnPlay.setOnClickListener(this);
        mBtnStop.setOnClickListener(this);


        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPlay:
                Intent serviceStart= new Intent(getActivity().getApplicationContext(),BackgroundSoundService.class);
                getActivity().startService(serviceStart);
                break;

            case R.id.btnStop:
                Intent serviceStop = new Intent(getActivity().getApplicationContext(),BackgroundSoundService.class);
                getActivity().stopService(serviceStop);
                break;

        }
    }
}
