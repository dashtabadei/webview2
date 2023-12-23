package com.example.webview2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView wb;
    Button searchbtn;
    EditText searchbar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wb=findViewById(R.id.webv);
        searchbar=findViewById(R.id.searchbox);
        searchbtn=findViewById(R.id.search);
        wb.canGoBack();
        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().getBuiltInZoomControls();
        wb.getSettings().setDefaultFontSize(25);
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=searchbar.getText().toString();
                if(a.contains("https://")||a.contains("http://")||a.contains("www.")) {
                 wb.loadUrl(a);
                }
                //else{

                //}
            }
        });
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.wb.canGoBack()) {
            this.wb.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("خروج");
        alert.setMessage("آیا خارج میشوید");
        alert.setPositiveButton("بله", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();

            }
        });
        alert.setNegativeButton("خیر", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert.create();
        alert.show();

    }

}