package com.example.dipto.postrequestwithrxjava;

/**
 * Created by sakib on 1/7/2018.
 */

public class MainActivityPresenter {

    MainActivityView view ;

    public MainActivityPresenter(MainActivityView mainActivityView){
        this.view = mainActivityView ;
    }

    public void getRequestResult(String key){

        new InvokeApi(view.getAppContext(), key, new MainActivityRequestComplete() {

            @Override
            public void requestCompleteSuccess(ResponseRoot responseRoot) {
                view.showResult(responseRoot);
            }

            @Override
            public void requestCompleteError(String msg) {
                view.showMessage(msg);
            }
        });
    }
}
