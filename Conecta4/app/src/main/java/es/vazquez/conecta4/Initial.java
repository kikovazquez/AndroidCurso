package es.vazquez.conecta4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Initial extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_initial);
		
		 Animation animation = AnimationUtils.loadAnimation(this, R.anim.initial);
		 ImageView imageView = (ImageView) findViewById(R.id.imageView1);
		 imageView.startAnimation(animation);
		
	}
	
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
		startActivity(new Intent("es.vazquez.conecta4.MAINACTIVITY"));
		}
		return true;
		}
}
