package es.codeurjc.ais.tictactoe;

import static org.assertj.core.api.Assertions.assertThat;
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

import es.codeurjc.ais.tictactoe.TicTacToeGame.EventType;
import es.codeurjc.ais.tictactoe.TicTacToeGame.WinnerValue;

public class TicTacToeGameTest {
	
	@Test
	public void player1WinsTest() throws InterruptedException {
		ticTacToeRunTest(new int[] { 0, 3, 1, 7, 2 }, 0);
	}
	
	@Test
	public void player2WinsTest() throws InterruptedException {
		ticTacToeRunTest(new int[] { 0, 3, 7, 4, 2, 5 }, 1);
	}

	@Test
	public void drawTest() throws InterruptedException {
		ticTacToeRunTest(new int[] { 0, 1, 2, 4, 3, 6, 5, 8, 7 }, -1);
	}


	public void ticTacToeRunTest(int[] cells, int winner) {
		
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
		
		// 5.1) Añadir los jugadores (player1) al objeto TicTacToeGame
		ticTacToeGame.addPlayer(player1);
		
		// 6.1) Comprobar que la conexión 1 recibe el evento JOIN_GAME, con player1
		verify(connection1).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(player1)));
		
		// 7.1) Comprobar que la conexión 2 recibe el evento JOIN_GAME, con player1
		verify(connection2).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(player1)));

		// 5.2) Añadir los jugadores (player2) al objeto TicTacToeGame
		ticTacToeGame.addPlayer(player2);

		// 6.2) Comprobar que la conexión 1 recibe el evento JOIN_GAME, con ambos jugadores
		verify(connection1, times(2)).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(player1, player2)));
		
		// 7.2) Comprobar que la conexión 2 recibe el evento JOIN_GAME, con ambos jugadores
		verify(connection2, times(2)).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(player1, player2)));
				
		// 8) Por turnos, cada jugador va marcando una casilla invocando el método mark de
	    //    TicTacToeGame, comprobando que el turno cambia
		
		for (int i = 0; i < cells.length; i++) {

			if (i %2 == 0 )
			{
				verify(connection1).sendEvent(eq(EventType.SET_TURN), argThat(equalTo(player1)));
				verify(connection2).sendEvent(eq(EventType.SET_TURN), argThat(equalTo(player1)));
			}
			else
			{
				verify(connection1).sendEvent(eq(EventType.SET_TURN), argThat(equalTo(player2)));
				verify(connection2).sendEvent(eq(EventType.SET_TURN), argThat(equalTo(player2)));			
			}
			
			reset(connection1);
			reset(connection2);
			
			ticTacToeGame.mark(cells[i]);

		}

		// 9) Al final se comprueba que el juego acaba y que dependiendo de las casillas marcadas
		//	  uno de los jugadores gana o hay empate.
		ArgumentCaptor<WinnerValue> argumentWinnerValue = ArgumentCaptor.forClass(WinnerValue.class);
		verify(connection1).sendEvent(eq(EventType.GAME_OVER), argumentWinnerValue.capture());
		
		// Comprueba si se espera y realmente ha ocurrido un empate.
		if(winner == -1) {
			assertThat(argumentWinnerValue.getValue()).isNull();	
		}
		else
		{
			// Comprueba el ganador esperado
			assertThat(argumentWinnerValue.getValue().player.getId()).isEqualTo(winner);
		}

	}

}
