package com.utility.todone.activities;

import android.app.Activity;
import android.os.Bundle;

import com.utility.activities.todone.R;
import com.utility.todone.fragments.ExpandableListFragment;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        getFragmentManager().beginTransaction().replace(R.id.main_layout, new ExpandableListFragment(this)).commit();
    }
}
