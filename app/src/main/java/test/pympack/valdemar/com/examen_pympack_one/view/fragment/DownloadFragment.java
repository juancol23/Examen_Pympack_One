package test.pympack.valdemar.com.examen_pympack_one.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import test.pympack.valdemar.com.examen_pympack_one.R;
import test.pympack.valdemar.com.examen_pympack_one.api.down.DownloadTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class DownloadFragment extends Fragment implements View.OnClickListener{

    private Button mBtnDownload;

    public DownloadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_download_service, container, false);

        mBtnDownload = v.findViewById(R.id.btnDownload);
        mBtnDownload.setOnClickListener(this);
        return v;
    }

    public void downloadAny(String url,String name_space, String name_extention) {
        DownloadTask downloadTask = new DownloadTask(getActivity().getApplicationContext());
        downloadTask.execute(url,name_space,name_extention);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDownload:
                downloadAny("http://sentir-terror.com/media/audios/ninop.mp3","testDescarga","mp3");
                break;
        }
    }
}
