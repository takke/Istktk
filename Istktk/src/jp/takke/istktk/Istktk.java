package jp.takke.istktk;

import jp.co.sharp.android.hardware.Pedometer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Istktk extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);

		// •à”‚Ìæ“¾
		Pedometer pedometer = Pedometer.createInstance(getApplicationContext());
		final int steps = pedometer.getIntParameter(Pedometer.STEPS);
		String text = String.format("–{“ú‚Í%d•àI #istktk", steps);

		// Intent ‘—M
		try {
			final Intent intent = new Intent();
			intent.setAction(Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_TEXT, text);
			startActivity(intent);
		} catch (Exception e) {
			Log.e("istktk", e.getMessage(), e);
		}

		finish();
	}
}