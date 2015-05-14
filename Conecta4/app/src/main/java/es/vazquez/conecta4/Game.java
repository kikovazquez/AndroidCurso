package es.vazquez.conecta4;

public class Game {
	static final int FILAS = 6;
	static final int COLUMNAS = 7;
	

	private int tablero[][];
	private static final int TABLEROINICIAL[][] = { { 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 0 },{ 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 0 } };
	

	public Game() {
		tablero = new int[FILAS][COLUMNAS];

		for (int i = 0; i < FILAS; i++)
			for (int j = 0; j < COLUMNAS; j++)
				tablero[i][j] = TABLEROINICIAL[i][j];

	}
	public void restart(){
		for (int i = 0; i < FILAS; i++)
		for (int j = 0; j < COLUMNAS; j++)
		tablero[i][j] = TABLEROINICIAL[i][j];
		
	}

	public int getTablero(int i, int j) {
		return tablero[i][j];
	}
	
	public void setTablero(int i ,int j, int jugador) {
		tablero[i][j] = jugador;
		
	}

	public boolean sePuedeColocarFicha(int i, int j) {

		if (tablero[i][j] == 1 || tablero[i][j] == 2)
			//el hueco esta ocupado......
			return false;
		
		if (i < FILAS - 1) {
			if (tablero[i + 1][j] == 0 ){
				return false;
				// la columna esta vacia , hay que ponerla en la primera fila
			}
		}

		return true;
	}

	public void juegaMaquina() {
		
		for (int i = FILAS -1 ; i >= 0; i--) {
			for (int j = COLUMNAS - 1 ; j >= 0; j--) {
				
				if (tablero[i][j] == 0) {
					tablero[i][j]=1;
					i = -1;
					j = -1;
				}
			}
		}
		
	}
	public boolean comprobarFilas( int turno) {
		int conectadas = 0;
		
		
		for (int i= FILAS -1 ; i>= 0 ; i--){
			conectadas = 0;
			for (int j = COLUMNAS - 1 ; j >= 0; j--) {
				
				if ( tablero[i][j] == turno ){
					conectadas++;
					if (conectadas >= 4) { return true; }
				}
				else
				{
					conectadas = 0;
				}
				
			}
			
					
		}
		return false;
	}
	public boolean comprobarColumnas( int turno) {
		int conectadas = 0;
	
		for (int j = COLUMNAS - 1 ; j >= 0; j--) {
			conectadas = 0;
			for (int i= FILAS -1 ; i>= 0 ; i--){
				if ( tablero[i][j] == turno ){
					conectadas++;
					if (conectadas >= 4) { return true; }
				}
				else
				{
					conectadas = 0;
				}
				
			}
			
		}
		return false;
	}
	public boolean comprobarDiagonales( int turno) {
		int conectadas = 0;
		int fila = 0;
		int columna =0;
		
		for (int i= FILAS -2 ; i>= COLUMNAS - 4 ; i--){
			// COMPROBAMOS LA fila de abajo y las tres de cada esquina
			conectadas = 0;
			fila = i;
			columna = 0;
			for (int z= 0 ; z <= i  ; z++) {
				if ( tablero[fila - z][columna + z] == turno){
					conectadas++;
					if (conectadas >= 4) { return true; }
				}
			}
			columna = COLUMNAS - 1;
			conectadas = 0;
			for (int z= 0 ; z <= i  ; z++) {
				if ( tablero[fila - z][columna - z] == turno){
					conectadas++;
					if (conectadas >= 4) { return true; }
				}
			}
		}	
		// ahora compruebo la fila base.
		fila = FILAS -1;
		for (int j = COLUMNAS - 1 ; j >= 0; j--) {
			conectadas = 0;
			columna = j;
			//diagonales hacia la derecha
			if ( columna == 3 ) {
				
				columna = 3;
			}
			for (int z= 0 ; z <= FILAS - 1 ; z++) {
				if (((columna + z) <= COLUMNAS-1) || ((fila + z) <= FILAS-1)) {
					if (tablero[fila - z][columna + z] == turno){
						conectadas++;
						if (conectadas >= 4) { return true; }
					}
				}
				
			}	
			//diagonales hacia la izquierda
			conectadas =0;
			for (int z= 0 ; z <= FILAS - 1 ; z++) {
				if (((columna - z) >= 0) && ((fila - z) >=0)) {
					if (tablero[fila - z][columna - z] == turno){
						conectadas++;
						if (conectadas >= 4) { return true; }
					}
				}
				
			}				
			
			
			
		}
		
		
		
		return false;
	}
	public boolean comprobarConectaCuatro( int i) {
		if (comprobarFilas(i) || comprobarColumnas(i) || comprobarDiagonales(i))  {
			return true; 
			}
		else
		{
			return false;
		}
		
	}
}