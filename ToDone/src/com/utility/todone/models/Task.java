package com.utility.todone.models;

import com.utility.todone.enums.Ranking;

public class Task {
	
	Ranking _importance;
	Ranking _urgency;
	Ranking _effort;
	String _title;
	String _description;
	
	public Task(String title) {
		_title = title;
		_description = null;
		_importance = Ranking.Unassigned;
		_urgency = Ranking.Unassigned;
		_effort = Ranking.Unassigned;
	}
	
	public Task(String title, String description) {
		_title = title;
		_description = description;
		_importance = Ranking.Unassigned;
		_urgency = Ranking.Unassigned;
		_effort = Ranking.Unassigned;
	}
	
	public Task(String title, String description, Ranking importance, Ranking urgency, Ranking effort) {
		_title = title;
		_description = description;
		_importance = importance;
		_urgency = urgency;
		_effort = effort;
	}
	
	public String getTitle() { return _title; }

	public void setTitle(String title) { _title = title; }
	
	public String getDescription() { return _description; }
	
	public void setDescription(String description) { _description = description; }
	
	public Ranking getImportance() { return _importance; }
	
	public void setImportance(Ranking importance) { _importance = importance; }
	
	public Ranking getUrgency() { return _urgency; }
	
	public void setUrgency(Ranking urgency) { _urgency = urgency; }
	
	public Ranking getEffort() { return _effort; }

	public void setEffort(Ranking effort) { _effort = effort; }
}
