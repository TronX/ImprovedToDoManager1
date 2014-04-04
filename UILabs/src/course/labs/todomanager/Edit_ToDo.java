package course.labs.todomanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Edit_ToDo extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.todo_item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.menu2, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
	if(item.getItemId() == R.id.action_save){
		
		//LOOK AT IT LATER...
		//SAVE ITEMS and return to previous Activity..
			
		}
		return true;
	}

	
	
	
	
	
}
