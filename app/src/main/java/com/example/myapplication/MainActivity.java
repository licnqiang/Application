package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements Adapter.IonSlidingViewClickListener {
    private final String TAG = "test";
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setAdapter();

    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
    }

    private void setAdapter() {

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter = new Adapter(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void onItemClick(View view, int position) {
        Log.i(TAG, "点击项：" + position);
    }

    @Override
    public void onDeleteBtnCilck(View view, int position) {
        Log.i(TAG, "删除项：" + position);
        mAdapter.removeData(position);
    }
}
