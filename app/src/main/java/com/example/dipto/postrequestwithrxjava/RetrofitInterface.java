package com.example.dipto.postrequestwithrxjava;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by sakib on 1/7/2018.
 */

public interface RetrofitInterface {

    @FormUrlEncoded
    @POST("get_search_result.php")
    Observable<ResponseRoot> getResponseResult(@Field("key") String key) ;
}
