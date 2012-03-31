package illinois.sweng.sctracker;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

public class PlayerStatusActivity extends Activity {
	static String TAG = "playerStatusActivity";
	// String data;
	// JSONObject player;
	// JSONObject playerData;
	TrackerDatabaseAdapter mDBAdapter;

	String handle = "";
	Object picture = "";
	String name = "";
	String race = "";
	String team = "";
	String nationality = "";
	String elo;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playerstatus);

		getDataFromIntent();
		
		TextView t = (TextView) findViewById(R.id.playerStatusHandleTextView);
		t.append(handle);
		t = (TextView) findViewById(R.id.playerStatusNameTextView);
		t.append(name);
		t = (TextView) findViewById(R.id.playerStatusRaceTextView);
		t.append(race);
		t = (TextView) findViewById(R.id.playerStatusTeamTextView);
		t.append(team);
		t = (TextView) findViewById(R.id.playerStatusNationalityTextView);
		t.append(nationality);
		t = (TextView) findViewById(R.id.playerStatusEloTextView);
		t.append(elo);
	}

	/**
	 * Retrieve field data from the intent used to start this activity
	 */
	private void getDataFromIntent() {
		Intent intent = getIntent();
		Resources res = getResources();
		
		String handleKey = res.getString(R.string.keyHandle);
		handle = intent.getStringExtra(handleKey);
		
		String nameKey = res.getString(R.string.keyName);
		name = intent.getStringExtra(nameKey);
		
		String raceKey = res.getString(R.string.keyRace);
		race = intent.getStringExtra(raceKey);
		
		String teamKey = res.getString(R.string.keyTeam);
		team = intent.getStringExtra(teamKey);
		
		String nationalityKey = res.getString(R.string.keyNationality);
		nationality = intent.getStringExtra(nationalityKey);
		
		String eloKey = res.getString(R.string.keyELO);
		elo = intent.getIntExtra(eloKey, 0) + "";
	}
}
