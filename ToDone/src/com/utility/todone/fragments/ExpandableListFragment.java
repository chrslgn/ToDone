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

public class ExpandableListFragment extends Fragment {
	
	Context _context;
	ExpandableListAdapter _listAdapter;
    ExpandableListView _expListView;
    List<String> _listDataHeader;
    HashMap<String, List<String>> _listDataChild;
 
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
                        _listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });
 
        // Listview Group collasped listener
        _expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
 
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(_context,
                        _listDataHeader.get(groupPosition) + " Collapsed",
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
                        _listDataHeader.get(groupPosition)
                                + " : "
                                + _listDataChild.get(
                                        _listDataHeader.get(groupPosition)).get(
                                        childPosition), Toast.LENGTH_SHORT)
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
        _listDataHeader = new ArrayList<String>();
        _listDataChild = new HashMap<String, List<String>>();
 
        // Adding child data
        _listDataHeader.add("Top 250");
        _listDataHeader.add("Now Showing");
        _listDataHeader.add("Coming Soon..");
 
        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");
 
        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");
 
        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");
 
        _listDataChild.put(_listDataHeader.get(0), top250); // Header, Child data
        _listDataChild.put(_listDataHeader.get(1), nowShowing);
        _listDataChild.put(_listDataHeader.get(2), comingSoon);
    }

}
