package com.utility.todone.dialogs;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.utility.activities.todone.R;
import com.utility.todone.enums.Ranking;
import com.utility.todone.models.Task;
import com.utility.todone.models.TaskList;

public class CreateTaskDialog extends DialogFragment {
	
	TaskList _taskList;
	
	public CreateTaskDialog(TaskList taskList) {
		_taskList = taskList;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		Activity activity = getActivity(); assert activity != null;
		
		Builder builder = new Builder(activity);
		
		LayoutInflater inflater = activity.getLayoutInflater();
		
		final View view = inflater.inflate(R.layout.fragment_new_task, null);
		
		builder.setView(view)
			.setPositiveButton("Create", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					
					String title = ((EditText) view.findViewById(R.id.create_task_title)).getText().toString();
					String description = ((EditText) view.findViewById(R.id.create_task_description)).getText().toString();
					
					Ranking importance;
					switch (((RadioGroup) view.findViewById(R.id.importance)).getCheckedRadioButtonId()) {
					case R.id.importance_high:
						importance = Ranking.High;
						break;
					case R.id.importance_medium:
						importance = Ranking.Medium;
						break;
					case R.id.importance_low:
						importance = Ranking.Low;
						break;
					default:
						importance = Ranking.Unassigned;
						break;
					}
					
					Ranking effort;
					switch (((RadioGroup) view.findViewById(R.id.effort)).getCheckedRadioButtonId()) {
					case R.id.effort_high:
						effort = Ranking.High;
						break;
					case R.id.effort_medium:
						effort = Ranking.Medium;
						break;
					case R.id.effort_low:
						effort = Ranking.Low;
						break;
					default:
						effort = Ranking.Unassigned;
						break;
					}
					
					Ranking urgency;
					switch(((RadioGroup) view.findViewById(R.id.urgency)).getCheckedRadioButtonId()) {
					case R.id.urgency_high:
						urgency = Ranking.High;
						break;
					case R.id.urgency_medium:
						urgency = Ranking.Medium;
						break;
					case R.id.urgency_low:
						urgency = Ranking.Low;
						break;
					default:
						urgency = Ranking.Unassigned;
						break;
					}
					
					_taskList.add(new Task(title, description, importance, effort, urgency));
				}
		}).setNegativeButton("Cancel", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				CreateTaskDialog.this.getDialog().cancel();
			}
		});
		
		return builder.create();
	}

}
