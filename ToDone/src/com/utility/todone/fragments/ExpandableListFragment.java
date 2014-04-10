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

public class ExpandableListFragment extends Fragment {
	
	Context _context;
	ExpandableListAdapter _listAdapter;
    ExpandableListView _expListView;
    List<Task> _listDataHeader;
    HashMap<Task, List<Task>> _listDataChild;
 
    public ExpandableListFragment(Activity activity) {
    	_context = activity;
    }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_expandable_list, container, false);

		// get the listview
        _expListView = (ExpandableListView) view.findViewById(R.id.expandable_list);
 
        // preparing list data
        prepareListData();
 
        _listAdapter = new ExpandableListAdapter(_context, _listDataHeader, _listDataChild);
 
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
        
        return view;
	}
	
	/*
     * Preparing the list data
     */
    private void prepareListData() {
        _listDataHeader = new ArrayList<Task>();
        _listDataChild = new HashMap<Task, List<Task>>();
 
        // Adding child data
        _listDataHeader.add(new Task("Top 250"));
        _listDataHeader.add(new Task("Now Showing"));
        _listDataHeader.add(new Task("Coming Soon.."));
 
        // Adding child data
        List<Task> top250 = new ArrayList<Task>();
        top250.add(new Task("The Shawshank Redemption"));
        top250.add(new Task("The Godfather"));
        top250.add(new Task("The Godfather: Part II"));
        top250.add(new Task("Pulp Fiction"));
        top250.add(new Task("The Good, the Bad and the Ugly"));
        top250.add(new Task("The Dark Knight"));
        top250.add(new Task("12 Angry Men"));
 
        List<Task> nowShowing = new ArrayList<Task>();
        nowShowing.add(new Task("The Conjuring"));
        nowShowing.add(new Task("Despicable Me 2"));
        nowShowing.add(new Task("Turbo"));
        nowShowing.add(new Task("Grown Ups 2"));
        nowShowing.add(new Task("Red 2"));
        nowShowing.add(new Task("The Wolverine"));
 
        List<Task> comingSoon = new ArrayList<Task>();
        comingSoon.add(new Task("2 Guns"));
        comingSoon.add(new Task("The Smurfs 2"));
        comingSoon.add(new Task("The Spectacular Now"));
        comingSoon.add(new Task("The Canyons"));
        comingSoon.add(new Task("Europa Report"));
 
        _listDataChild.put(_listDataHeader.get(0), top250); // Header, Child data
        _listDataChild.put(_listDataHeader.get(1), nowShowing);
        _listDataChild.put(_listDataHeader.get(2), comingSoon);
    }

}
