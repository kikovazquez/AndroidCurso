package es.vazquez.conecta4;





import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;



public class MainActivity extends Activity implements OnClickListener {
	Game game;
	static final int COLUMNAS = 7;
	static final int FILAS = 6;
	private int jugador = 2;
	
	private final int identificadores[][] = {
			{R.id.ImageButton01 ,R.id.ImageButton02 , R.id.ImageButton03 , R.id.ImageButton04 ,R.id.ImageButton05 , R.id.ImageButton06 , R.id.ImageButton07},
			{R.id.ImageButton8 ,R.id.ImageButton9 , R.id.ImageButton10 , R.id.ImageButton11 ,R.id.ImageButton12 , R.id.ImageButton13 , R.id.ImageButton14},
			{R.id.ImageButton15 ,R.id.ImageButton16 , R.id.ImageButton17 , R.id.ImageButton18 ,R.id.ImageButton19 , R.id.ImageButton20 , R.id.ImageButton21},
			{R.id.ImageButton22 ,R.id.ImageButton23 , R.id.ImageButton24 , R.id.ImageButton25 ,R.id.ImageButton26 , R.id.ImageButton27 , R.id.ImageButton28},
			{R.id.ImageButton29 ,R.id.ImageButton30 , R.id.ImageButton31 , R.id.ImageButton32 ,R.id.ImageButton33 , R.id.ImageButton34 , R.id.ImageButton35},
			{R.id.ImageButton36 ,R.id.ImageButton37 , R.id.ImageButton38 , R.id.ImageButton39 ,R.id.ImageButton40 , R.id.ImageButton41 , R.id.ImageButton42}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		game = new Game();
		inicializaeventos();
		
	}
	public void restart(){
		//Toast.makeText(this, "Vuelvo a empezar....", Toast.LENGTH_SHORT).show();
		game.restart();
		TextView t=(TextView)findViewById(R.id.textView1); 
		t.setText("Conecta 4");
		
	}
	
	private void inicializaeventos() {
		// TODO Auto-generated method stub
		for (int i=0; i<FILAS; i++)
    		for (int j=0; j<COLUMNAS; j++)
    			if (identificadores[i][j]!=0){
    				ImageButton boton = (ImageButton) findViewById(identificadores[i][j]);
    				boton.setOnClickListener(this);
    			}
    	
		
	}

	protected int deIdentificadorAFila (int id) {
		
		for (int i=0; i<FILAS; i++) {
			for (int j=0; j<COLUMNAS; j++) {
				if (identificadores[i][j] == id ) {
					return i;
				}
					
			}
		}
		
		return 0;
	}
	protected int deIdentificadorAColumna(int id) {
		
		for (int i=0; i<FILAS; i++) {
			for (int j=0; j<COLUMNAS; j++) {
				if (identificadores[i][j] == id ) {
					return j;
				}
					
			}
		}
		
		return 0;
	}
	
	public void onClick (View v){
		pulsado(v);
	}
	
	protected void pulsado(View v) {
		int id =  v.getId();
		jugador = 2;
		int fila = deIdentificadorAFila(id);
		int columna = deIdentificadorAColumna(id);
		TextView t=(TextView)findViewById(R.id.textView1); 
		int finalizar = 0;
		
		if ( game.sePuedeColocarFicha(fila, columna) == true ) {
			// ok
			game.setTablero(fila, columna, jugador);
			if (game.comprobarConectaCuatro(jugador)) {
				  
			    t.setText (getPlayerName() + " ganaste,enhorabuena!!!") ;
			    finalizar = 1;
			}
			if (finalizar == 0) {
				jugador = 1;
				game.juegaMaquina();
				dibujarTablero();
				if (game.comprobarConectaCuatro(jugador)) {
				
					t.setText ("Te gane!!!") ;
					Toast.makeText(this, "Hay que ser malo ,macho ....", Toast.LENGTH_SHORT).show();
					finalizar = 1;
				}
			}
			
		}else{
		// aviso toast.......
			Toast.makeText(this, "Posicion no permitida", Toast.LENGTH_SHORT).show();
		}
		if (finalizar == 1)	{
			AlertDialogFragment ad = new AlertDialogFragment();
			ad.show(getFragmentManager(), "DIALOGO ALERTA");
			
		}	
		
	}
	
	protected void dibujarTablero() {
		for (int i=0; i<FILAS; i++) {
			for (int j=0; j<COLUMNAS; j++) {
				int valor = game.getTablero(i,j);
				ImageButton boton = (ImageButton) findViewById(identificadores[i][j]);
				if (valor != 0) {
					
					
					
					if (valor == 1) {	
						//boton.setChecked(true); 
						boton.setImageResource(R.drawable.c4_button_ord);
					}
					else
					{	//boton.setChecked(false); 
						//DEPENDE DE LA PROPIEDADES.
						String color = getFigure();
						if(color.contains("rojo")) {
							boton.setImageResource(R.drawable.c4_button_playerred);
						}
						else if (color.contains("amarillo")) {
							boton.setImageResource(R.drawable.c4_button_playeryellow);
						}
						else {
							boton.setImageResource(R.drawable.c4_button_playergreen);
						}
							
					
					}
				}else{
					 
					  boton.setImageResource(R.drawable.c4_button);
				}	
			}
		}
		
	}
	
	
	
	protected void onResume(){
		super.onResume();
		Boolean play = false;
		
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
	   	if (sharedPreferences.contains(CCCPreference.PLAY_MUSIC_KEY))
    	    play = sharedPreferences.getBoolean(CCCPreference.PLAY_MUSIC_KEY, 
    	    		CCCPreference.PLAY_MUSIC_DEFAULT);

	   	if (play == true)
	   		Music.play(this, R.raw.funkandblues);
    }
	
    protected void onPause(){
		super.onPause();
		Music.stop(this);
    }
	  public boolean onCreateOptionsMenu(Menu menu) {
	        super.onCreateOptionsMenu(menu);
	        MenuInflater inflater = getMenuInflater();
	        inflater.inflate(R.menu.c4_menu, menu);
	        return true;
	    } 
	    
	    /*************************************************************************
	    Completa este metodo.
	    Incluye una instruccion switch dentro de este metodo para arrancar las 
	    actividades About o CCCPreference, dependiendo del valor del identificador 
	    de item. Este valor se consigue de la siguiente manera: item.getItemId().
	    *************************************************************************/
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Aqui debes incluir tu instruccion switch
	    	switch (item.getItemId()) {
	    	
	    		case R.id.acercaDe:
	    			startActivity(new Intent(this,AcercaDe.class));
	    			return true;
	    		case R.id.preferencias:
	    			startActivity(new Intent(this,CCCPreference.class));
	    			return true;
	    	
	    	
	    	}
	        return super.onOptionsItemSelected(item);
	    } 
	    
	    public String getFigure () {
			String figure = null;
			
		   	SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		   	if (sharedPreferences.contains(CCCPreference.FIGURE_KEY))
	    	    figure = sharedPreferences.getString(CCCPreference.FIGURE_KEY, CCCPreference.FIGURE_DEFAULT);

		   	return figure;	    	
	    }	
	
	    public String getPlayerName(){
		   	SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
	    	String name = sharedPreferences.getString(CCCPreference.PLAYER_KEY, CCCPreference.PLAYER_DEFAULT);
			return name;	
		}
}
