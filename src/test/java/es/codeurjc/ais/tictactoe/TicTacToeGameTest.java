package es.codeurjc.ais.tictactoe;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// import static org.hamcrest.CoreMatchers.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.hamcrest.MockitoHamcrest.argThat;

import org.junit.jupiter.api.Test;

import es.codeurjc.ais.tictactoe.TicTacToeGame.EventType;

public class TicTacToeGameTest {

	@Test
	public void testTicTacToeGame() {
		
		// 1) Crear el objeto TicTacToeGame
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
				
		// 2) Crear los dobles de los objetos Connection
		Connection connection1 = mock(Connection.class);
		Connection connection2 = mock(Connection.class);
		
		// 3) Añadir los dobles al objeto TicTacToeGame
		ticTacToeGame.addConnection(connection1);
		ticTacToeGame.addConnection(connection2);
		
		// 4) Crear los dos jugadores (objetos Player)
		Player player1 = new Player(0, "label1", "player1");
		Player player2 = new Player(1, "label2", "player2");
		
		// 5) Añadir los jugadores al objeto TicTacToeGame
		ticTacToeGame.addPlayer(player1);
		ticTacToeGame.addPlayer(player2);
		
		// 6) Comprobar que la conexión 1 recibe el evento JOIN_GAME, con ambos jugadores
		verify(connection1, times(2)).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(player1, player2)));
		
		// 7) Comprobar que la conexión 2 recibe el evento JOIN_GAME, con ambos jugadores
		verify(connection2, times(2)).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(player1, player2)));
		
		// 8) Por turnos, cada jugador va marcando una casilla invocando el método mark de
	    //    TicTacToeGame, comprobando que el turno cambia
		// 9) Al final se comprueba que el juego acaba y que dependiendo de las casillas marcadas
		//	  uno de los jugadores gana o hay empate.
	}

}
