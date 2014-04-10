package com.utility.todone.fragments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import com.utility.activities.todone.R;
import com.utility.todone.adapters.ExpandableListAdapter;
import com.utility.todone.enums.Ranking;
import com.utility.todone.models.Task;
import com.utility.todone.models.TaskList;

public class ExpandableListFragment extends Fragment {
	
	Context _context;
 
    public ExpandableListFragment(Activity activity) {
    	_context = activity;
    }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_expandable_list, container, false);

		new TaskList(_context, (ExpandableListView) view.findViewById(R.id.expandable_list));
        
        return view;
	}
}
