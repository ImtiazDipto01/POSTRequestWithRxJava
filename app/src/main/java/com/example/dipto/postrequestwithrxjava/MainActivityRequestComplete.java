package com.example.dipto.postrequestwithrxjava;

/**
 * Created by sakib on 1/7/2018.
 */

public interface MainActivityRequestComplete {

    public void requestCompleteSuccess(ResponseRoot responseRoot) ;

    public void requestCompleteError(String msg) ;
}
