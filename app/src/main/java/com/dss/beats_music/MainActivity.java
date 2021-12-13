package com.dss.beats_music;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.dss.beats_music.databinding.ActivityMainBinding;
import com.dss.beats_music.discover.DiscoverFragment;
import com.dss.beats_music.me.MeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private ActivityMainBinding binding;

    private List<Fragment> fragments = new ArrayList<>();
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        //toolbar
        setSupportActionBar(binding.toolbar);
        actionBar = getSupportActionBar();

        //显示导航按钮
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.left);


        initData();
    }

    private void initData() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener(this);
        binding.bottomNavigation.setSelectedItemId(R.id.home);
    }

    @Override
    // 3. 加载toobar.xml
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toobar, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.home:
                actionBar.setTitle("发现");
                fragmentTransaction.replace(R.id.fragment, new DiscoverFragment()).commit();
                return true;
            case R.id.mine:
                actionBar.setTitle("我的");
                fragmentTransaction.replace(R.id.fragment, new MeFragment()).commit();
                return true;
            case R.id.cloud_city:
                actionBar.setTitle("云村");
                fragmentTransaction.replace(R.id.fragment, new CloudCityFragment()).commit();
                return true;
        }
        return true;
    }
    @Override
    // 设置点击导航栏android.R.id.home就打开侧滑
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            binding.drawerLayout.openDrawer(GravityCompat.START);
        }
        return true;
    }
}