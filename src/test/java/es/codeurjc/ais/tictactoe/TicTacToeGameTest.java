package es.codeurjc.ais.tictactoe;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.hamcrest.MockitoHamcrest.argThat;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import es.codeurjc.ais.tictactoe.TicTacToeGame.CellMarkedValue;
import es.codeurjc.ais.tictactoe.TicTacToeGame.EventType;
import es.codeurjc.ais.tictactoe.TicTacToeGame.WinnerValue;

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
		Player player1 = new Player(0, "X", "player1");
		Player player2 = new Player(1, "O", "player2");
		
		// 5) Añadir los jugadores al objeto TicTacToeGame
		ticTacToeGame.addPlayer(player1);
		ticTacToeGame.addPlayer(player2);
		
		// 6) Comprobar que la conexión 1 recibe el evento JOIN_GAME, con ambos jugadores
		verify(connection1, times(2)).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(player1, player2)));
		reset(connection1);
		
		// 7) Comprobar que la conexión 2 recibe el evento JOIN_GAME, con ambos jugadores
		verify(connection2, times(2)).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(player1, player2)));
		reset(connection2);
				
		// 8) Por turnos, cada jugador va marcando una casilla invocando el método mark de
	    //    TicTacToeGame, comprobando que el turno cambia
		ticTacToeGame.mark(0);
		ArgumentCaptor<CellMarkedValue> argumentCellMarkedValue = ArgumentCaptor.forClass(CellMarkedValue.class);
		verify(connection1).sendEvent(eq(EventType.MARK), argumentCellMarkedValue.capture());
		Object event = argumentCellMarkedValue.getValue();

		verify(connection1).sendEvent(eq(EventType.SET_TURN), argThat(equalTo(player2)));
		reset(connection1);

		ticTacToeGame.mark(1);
		verify(connection2).sendEvent(eq(EventType.SET_TURN), argThat(equalTo(player2)));
		reset(connection2);

		ticTacToeGame.mark(3);
		verify(connection1).sendEvent(eq(EventType.SET_TURN), argThat(equalTo(player1)));
		reset(connection1);

		ticTacToeGame.mark(4);
		verify(connection2).sendEvent(eq(EventType.SET_TURN), argThat(equalTo(player2)));
		reset(connection2);

		ticTacToeGame.mark(6);
		verify(connection1).sendEvent(eq(EventType.SET_TURN), argThat(equalTo(player1)));
		reset(connection1);

		// 9) Al final se comprueba que el juego acaba y que dependiendo de las casillas marcadas
		//	  uno de los jugadores gana o hay empate.
		ArgumentCaptor<WinnerValue> argumentWinnerValue = ArgumentCaptor.forClass(WinnerValue.class);
		verify(connection2).sendEvent(eq(EventType.GAME_OVER), argumentWinnerValue.capture());
		event = argumentWinnerValue.getValue();
	}

}
