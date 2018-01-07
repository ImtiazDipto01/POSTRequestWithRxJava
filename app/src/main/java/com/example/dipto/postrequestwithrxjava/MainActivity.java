package com.example.dipto.postrequestwithrxjava;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    MainActivityPresenter presenter ;
    Button sendBtn ;
    TextView searverText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainActivityPresenter(this) ;

        sendBtn = findViewById(R.id.sendbtn) ;
        searverText = findViewById(R.id.statename) ;

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getRequestResult("dha");
            }
        });
    }

    @Override
    public void showResult(ResponseRoot responseRoot) {
        List<NoticeItem> list = new ArrayList() ;

        list = responseRoot.getNotice() ;

        if(!list.isEmpty()){
            searverText.setText(list.get(0).getTitle());
        }
    }

    @Override
    public void startLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public Context getAppContext() {
        return null;
    }
}
