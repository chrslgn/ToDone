package com.utility.todone.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import com.utility.todone.adapters.ExpandableListAdapter;

public class TaskList {

	Context _context;
	ExpandableListAdapter _listAdapter;
    ExpandableListView _expListView;
    List<Task> _listDataHeader = new ArrayList<Task>();
    HashMap<Task, List<Task>> _listDataChild = new HashMap<Task, List<Task>>();
    
    public TaskList(Context context, ExpandableListView expListView) {
    	
    	_context = context;
    	// get the listview
        _expListView = expListView;
 
        _listAdapter = new ExpandableListAdapter(context, _listDataHeader, _listDataChild);
 
        // setting list adapter
        _expListView.setAdapter(_listAdapter);
 
        // Listview Group click listener
        _expListView.setOnGroupClickListener(new OnGroupClickListener() {
 
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                    int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });
 
        // Listview Group expanded listener
        _expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
 
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(_context,
                        _listDataHeader.get(groupPosition).getTitle() + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });
 
        // Listview Group collasped listener
        _expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
 
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(_context,
                        _listDataHeader.get(groupPosition).getTitle() + " Collapsed",
                        Toast.LENGTH_SHORT).show();
 
            }
        });
 
        // Listview on child click listener
        _expListView.setOnChildClickListener(new OnChildClickListener() {
 
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                    int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        _context,
                        _listDataHeader.get(groupPosition).getTitle()
                                + " : "
                                + _listDataChild.get(
                                        _listDataHeader.get(groupPosition)).get(
                                        childPosition).getTitle(), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

	public void add(Task task) {
		
		_listDataHeader.add(task);
		_listAdapter.notifyDataSetChanged();
		
	}

}
