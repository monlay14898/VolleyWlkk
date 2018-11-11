package com.example.mongyi.volleywlkk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity implements Response.Listener<String>, Response.ErrorListener, View.OnClickListener {
    TextView tvResp;
    Button btnClk;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResp=(TextView)findViewById(R.id.tvResponse);
        btnClk=(Button)findViewById(R.id.btnClick);

        btnClk.setOnClickListener( this);

    }public void onClick(View view){
        queue = Volley.newRequestQueue(this);
        String url="http://www.google.com";
        StringRequest request=new StringRequest(Request.Method.GET,url,this,this);
        queue.add(request);

    }


    @Override
    public void onResponse(String response) {
tvResp.setText("Response is: "+ response.substring(0,500));
    }

    @Override
    public void onErrorResponse(VolleyError error) {
            tvResp.setText("That didn't work!");
    }


}
