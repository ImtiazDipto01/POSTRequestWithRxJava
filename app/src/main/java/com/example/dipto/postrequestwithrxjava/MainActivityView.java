package com.example.dipto.postrequestwithrxjava;

import android.content.Context;

/**
 * Created by sakib on 1/7/2018.
 */

public interface MainActivityView {

    public void showResult(ResponseRoot responseRoot) ;

    public void startLoading() ;

    public void stopLoading() ;

    public void showMessage(String msg) ;

    Context getAppContext() ;
}
