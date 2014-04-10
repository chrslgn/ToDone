package com.utility.todone.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.utility.activities.todone.R;
import com.utility.todone.dialogs.CreateTaskDialog;
import com.utility.todone.models.Task;
import com.utility.todone.models.TaskList;

public class ExpandableListFragment extends Fragment {
	
	Context _context;
	TaskList _taskList;
 
    public ExpandableListFragment(Activity activity) {
    	setHasOptionsMenu(true);
    	_context = activity;
    }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_expandable_list, container, false);

		_taskList = new TaskList(_context, (ExpandableListView) view.findViewById(R.id.expandable_list));
        
        return view;
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.expandable_list_fragment, menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.add_task:
			(new CreateTaskDialog(_taskList)).show(getFragmentManager(), null);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
