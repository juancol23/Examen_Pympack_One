package test.pympack.valdemar.com.examen_pympack_one.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import test.pympack.valdemar.com.examen_pympack_one.OnDataPass;
import test.pympack.valdemar.com.examen_pympack_one.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class BrindgData extends Fragment implements View.OnClickListener{

    private EditText mEdit_name;
    private Button mBtnSave;
    private OnDataPass dataPasser;

    public BrindgData() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_brindg_data, container, false);

        initView(v);



        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSave:
                String name = mEdit_name.getText().toString();
                Log.v("nameTLog","Click: Name: "+name);
                passData(name);
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dataPasser = (OnDataPass) context;
    }

    private void initView(View v) {
        mEdit_name = v.findViewById(R.id.edit_name);
        mBtnSave = v.findViewById(R.id.btnSave);
        mBtnSave.setOnClickListener(this);



    }
    private void saveData(View v){
        initView(v);
    }

    public void passData(String data) {
        dataPasser.onDataPass(data);
    }
}
