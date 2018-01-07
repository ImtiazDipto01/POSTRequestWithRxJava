package com.example.dipto.postrequestwithrxjava;

import android.content.Context;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sakib on 1/7/2018.
 */

public class InvokeApi {

    RetrofitInterface retrofitInterface ;
    MainActivityRequestComplete mainActivityRequestComplete ;

    public InvokeApi(final Context context, final String key, final MainActivityRequestComplete requestComplete){

        this.mainActivityRequestComplete = requestComplete ;
        retrofitInterface = RetrofitClient.getRetrofitClient().create(RetrofitInterface.class) ;


        retrofitInterface.getResponseResult("dha")
                         .subscribeOn(Schedulers.io())
                         .observeOn(AndroidSchedulers.mainThread())
                         .subscribe(new Observer<ResponseRoot>() {
                             @Override
                             public void onSubscribe(Disposable d) {

                             }

                             @Override
                             public void onNext(ResponseRoot responseRoot) {
                                 mainActivityRequestComplete.requestCompleteSuccess(responseRoot);
                                 Log.d("+++onNext+++","yes") ;
                             }

                             @Override
                             public void onError(Throwable e) {
                                 mainActivityRequestComplete.requestCompleteError("Searver Error");
                                 Log.d("+++onError+++","yes") ;
                             }

                             @Override
                             public void onComplete() {

                             }
                         });



    }
}
