package course.labs.todomanager;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.sax.StartElementListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import course.labs.todomanager.ToDoItem.Priority;
import course.labs.todomanager.ToDoItem.Status;





public class ToDoListAdapter extends BaseAdapter {


	// List of ToDoItems
	private final List<ToDoItem> mItems = new ArrayList<ToDoItem>();
	
	private final Context mContext;
	Status mStatus;

	private static final String TAG = "Lab-UserInterface";

	public ToDoListAdapter(Context context) {

		mContext = context;

	}

	// Add a ToDoItem to the adapter
	// Notify observers that the data set has changed

	public void add(ToDoItem item) {

		mItems.add(item);
		notifyDataSetChanged();

	}
	
	// Clears the list adapter of all items.
	
	public void clear(){

		mItems.clear();
		notifyDataSetChanged();
	
	}

	// Returns the number of ToDoItems

	@Override
	public int getCount() {

		return mItems.size();

	}

	// Retrieve the number of ToDoItems

	@Override
	public Object getItem(int pos) {

		return mItems.get(pos);

	}

	// Get the ID for the ToDoItem
	// In this case it's just the position

	@Override
	public long getItemId(int pos) {

		return pos;

	}

	//Create a View to display the ToDoItem 
	// at specified position in mItems
    Color colours = new Color();
    
  
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {


		
		
		
		//TODO - Get the current ToDoItem
	
		final ToDoItem toDoItem = mItems.get(position);
		

		
		//TODO - Inflate the View for this ToDoItem
		// from todo_item.xml.
		// LayoutInflater  mInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    //  view=mInflater.inflate(R.layout.test2, null, false);}}
		
	//	RelativeLayout itemLayout = (RelativeLayout) view.findViewById(R.id.RelativeLayout1);
		
		LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = mInflater.inflate(R.layout.list_item_layout, null, true);
		
		final LinearLayout linear = (LinearLayout) rowView.findViewById(R.id.toDoItem);
		final CheckBox statusView = (CheckBox) rowView.findViewById(R.id.statCheckBox);
		
		if(toDoItem.getStatus() == Status.DONE){
			
			statusView.setChecked(true);
			linear.setBackgroundColor(Color.rgb(98,213,94));
			
			}else{
			
				statusView.setChecked(false);
			linear.setBackgroundColor(Color.rgb(254,66,77));
			}
        		
		
		
	    
		//TODO - Fill in specific ToDoItem data
		// Remember that the data that goes in this View
		// corresponds to the user interface elements defined 
		// in the layout file 

		//TODO - Display Title in TextView

		final TextView titleView = (TextView) rowView.findViewById(R.id.Title_text);
		titleView.setText(toDoItem.getTitle());
		


	
		// TODO - Set up Status CheckBox
	     
	
		statusView.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				log("Entered onCheckedChanged()");
				
				// TODO - Set up and implement an OnCheckedChangeListener, which 
				// is called when the user toggles the status checkbox
				if(buttonView.isChecked()){
					
					
					toDoItem.setStatus(Status.DONE);
					linear.setBackgroundColor(Color.rgb(98,213,94));
					
					
					
				}else{
					
					toDoItem.setStatus(Status.NOTDONE);
					linear.setBackgroundColor(Color.rgb(254,66,77));
					
					
					
				}
                		
			}
		});

		
		//TODO - Display Priority in a TextView
        
		LinearLayout container = (LinearLayout) rowView.findViewById(R.id.container);
		final TextView priorityView = (TextView) rowView.findViewById(R.id.priorityText);
	   
		
		if(toDoItem.getPriority()== Priority.HIGH){
			
			container.setBackgroundColor(Color.rgb(21,175,225));
			priorityView.setText("H");
			
		}else if(toDoItem.getPriority()== Priority.MED){
			
			container.setBackgroundColor(Color.rgb(247,215,84));
			priorityView.setText("M");
		}else{
			
			container.setBackgroundColor(Color.rgb(116,30,139));
			priorityView.setText("L");
			
		}

		
		// TODO - Display Time and Date. 
		// Hint - use ToDoItem.FORMAT.format(toDoItem.getDate()) to get date and time String

		final TextView dateView = (TextView) rowView.findViewById(R.id.date1);
		dateView.setText(ToDoItem.FORMAT.format(toDoItem.getDate()));
				
	
		// Return the View you just created
		return rowView;

	}
	
	private void log(String msg) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Log.i(TAG, msg);
	}

}
