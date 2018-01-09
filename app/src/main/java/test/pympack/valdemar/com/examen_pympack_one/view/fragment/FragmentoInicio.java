package test.pympack.valdemar.com.examen_pympack_one.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.pympack.valdemar.com.examen_pympack_one.R;
import test.pympack.valdemar.com.examen_pympack_one.api.adapter.ArticleAdapter;
import test.pympack.valdemar.com.examen_pympack_one.api.model.Article;
import test.pympack.valdemar.com.examen_pympack_one.api.model.ArticleResponse;
import test.pympack.valdemar.com.examen_pympack_one.api.network.RetrofitInstance;
import test.pympack.valdemar.com.examen_pympack_one.api.service.ServiceApiNew;
import test.pympack.valdemar.com.examen_pympack_one.api.util.Contanst;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentoInicio extends Fragment {


    RecyclerView mRecyclerView;

    ArticleAdapter mArticleAdapter;

    RecyclerView.LayoutManager mLayoutManager;

    public FragmentoInicio() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragmento_inicio, container, false);

        mRecyclerView = v.findViewById(R.id.fragmento_recycler);

        mRecyclerView.hasFixedSize();

        mArticleAdapter = new ArticleAdapter(getActivity().getApplicationContext());

        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());


        mRecyclerView.setAdapter(mArticleAdapter);

        mRecyclerView.setLayoutManager(mLayoutManager);



        obtenerData();

        return v;
    }

    private void obtenerData() {
        ServiceApiNew service = RetrofitInstance.getRetrofitInstance().create(ServiceApiNew.class);
        Call<ArticleResponse> articleResponseCall = service.obtenerListaAnunciosApi();
        articleResponseCall.enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                ArticleResponse listaArticle = response.body();
                ArrayList<Article> articlelista = listaArticle.getArticles();

                for (int i = 0; i<articlelista.size();i++){
                    Article articleList = articlelista.get(i);
                    Log.v("TAG_FRAGMENTO","\n"+articleList.getTitle());
                    Log.v("TAG_FRAGMENTO","\n"+articleList.getUrlToImage());
                }

                mArticleAdapter.passDataAdapter(articlelista);
            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {

            }
        });
    }

}
