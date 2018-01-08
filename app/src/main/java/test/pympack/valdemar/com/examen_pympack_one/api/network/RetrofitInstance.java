package test.pympack.valdemar.com.examen_pympack_one.api.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.pympack.valdemar.com.examen_pympack_one.api.util.Contanst;

/**
 * Created by CORAIMA on 08/01/2018.
 */

public class RetrofitInstance {
    private static Retrofit mRetrofit;

    public static Retrofit getRetrofitInstance(){
        if(mRetrofit == null){
            mRetrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(Contanst.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

}
