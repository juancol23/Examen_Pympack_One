package test.pympack.valdemar.com.examen_pympack_one.api.service;

import retrofit2.Call;
import retrofit2.http.GET;
import test.pympack.valdemar.com.examen_pympack_one.api.model.ArticleResponse;
import test.pympack.valdemar.com.examen_pympack_one.api.util.Contanst;

/**
 * Created by CORAIMA on 08/01/2018.
 */

public interface ServiceApiNew {

    @GET(Contanst.ROOT_URL)
    Call<ArticleResponse> obtenerListaAnunciosApi();



}
