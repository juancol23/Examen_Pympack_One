package test.pympack.valdemar.com.examen_pympack_one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.pympack.valdemar.com.examen_pympack_one.api.adapter.ArticleAdapter;
import test.pympack.valdemar.com.examen_pympack_one.api.model.Article;
import test.pympack.valdemar.com.examen_pympack_one.api.model.ArticleResponse;
import test.pympack.valdemar.com.examen_pympack_one.api.network.RetrofitInstance;
import test.pympack.valdemar.com.examen_pympack_one.api.service.ServiceApiNew;
import test.pympack.valdemar.com.examen_pympack_one.api.util.Contanst;

public class MainActivity extends AppCompatActivity {

    private Retrofit mRetrofit;

    @BindView(R.id.text_welcome_cus)
    TextView mText_welcome_cus;

    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;

    ArticleAdapter mArticleAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        changeTextFlavor();


        mRecyclerView.hasFixedSize();

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mArticleAdapter = new ArticleAdapter(getApplicationContext());

        mRecyclerView.setAdapter(mArticleAdapter);

/*
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Contanst.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
*/
        obtenerData();

   }

    private void obtenerData() {
       // ServiceApiNew service = mRetrofit.create(ServiceApiNew.class);

        ServiceApiNew service = RetrofitInstance.getRetrofitInstance().create(ServiceApiNew.class);

        Call<ArticleResponse> articleResponseCall = service.obtenerListaAnunciosApi();

        articleResponseCall.enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                ArticleResponse listaArticle = response.body();
                ArrayList<Article> articlelista = listaArticle.getArticles();

                for (int i = 0; i<articlelista.size();i++){
                    Article articleList = articlelista.get(i);
                    Log.v(Contanst.TAG_LOG,"\n"+articleList.getTitle());
                    Log.v(Contanst.TAG_LOG,"\n"+articleList.getUrlToImage());

                }


                mArticleAdapter.passDataAdapter(articlelista);

            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {

            }
        });
    }

    private void changeTextFlavor() {
       if(Contants.type == Contants.Type.FREE){
           mText_welcome_cus.setText("FREE HEY FREE");
       }else {
           mText_welcome_cus.setText("PAGO PUTA PAGO");

       }
    }


}
