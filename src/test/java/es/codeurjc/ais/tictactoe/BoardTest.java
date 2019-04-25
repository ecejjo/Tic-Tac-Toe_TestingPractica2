package es.codeurjc.ais.tictactoe;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

import es.codeurjc.ais.tictactoe.TicTacToeGame.Cell;

public class BoardTest {

	Board board = new Board();

	String xValue = "X";
	String oValue = "O";
	
	public void setCell(Board board, int cellNumber, String value) {
		Cell cell = board.getCell(cellNumber);
		cell.active = true;
		cell.value = value;		
	}

	@Test
	public void testBoard_x012() {

		// Given
		board = new Board();		
		setCell(board, 0, xValue);
		setCell(board, 3, oValue);
		setCell(board, 1, xValue);
		setCell(board, 7, oValue);
		setCell(board, 2, xValue);
		setCell(board, 5, oValue);

		// When
		int [] calculatedCells = board.getCellsIfWinner(xValue);
		int [] expectedCells = {0, 1, 2};
		boolean checkDrawResult = board.checkDraw();
		
		// Then
		assertArrayEquals(calculatedCells,expectedCells);
		assertThat(checkDrawResult).isEqualTo(false);
		assertThat(board.getCellsIfWinner(oValue)).isNull();
	}
	
	@Test
	public void testBoard_o345() {

		// Given
		board = new Board();		
		setCell(board, 0, xValue);
		setCell(board, 3, oValue);
		setCell(board, 7, xValue);
		setCell(board, 4, oValue);
		setCell(board, 2, xValue);
		setCell(board, 5, oValue);
		
		// When
		int [] calculatedCells = board.getCellsIfWinner(oValue);
		int [] expectedCells = {3, 4, 5};
		boolean checkDrawResult = board.checkDraw();
		
		// Then
		assertArrayEquals(calculatedCells,expectedCells);
		assertThat(checkDrawResult).isEqualTo(false);
		assertThat(board.getCellsIfWinner(xValue)).isNull();
	}

	@Test
	public void testBoard_x678() {

		// Given
		board = new Board();		
		setCell(board, 6, xValue);
		setCell(board, 0, oValue);
		setCell(board, 7, xValue);
		setCell(board, 4, oValue);
		setCell(board, 8, xValue);

		// When
		int [] calculatedCells = board.getCellsIfWinner(xValue);
		int [] expectedCells = {6, 7, 8};
		boolean checkDrawResult = board.checkDraw();
		
		// Then
		assertArrayEquals(calculatedCells,expectedCells);
		assertThat(checkDrawResult).isEqualTo(false);
		assertThat(board.getCellsIfWinner(oValue)).isNull();
	}

	
	@Test
	public void testBoard_o036() {

		// Given
		board = new Board();		
		setCell(board, 1, xValue);
		setCell(board, 0, oValue);
		setCell(board, 5, xValue);
		setCell(board, 3, oValue);
		setCell(board, 7, xValue);
		setCell(board, 6, oValue);
		
		// When
		int [] calculatedCells = board.getCellsIfWinner(oValue);
		int [] expectedCells = {0, 3, 6};
		boolean checkDrawResult = board.checkDraw();
		
		// Then
		assertArrayEquals(calculatedCells,expectedCells);
		assertThat(checkDrawResult).isEqualTo(false);
		assertThat(board.getCellsIfWinner(xValue)).isNull();
	}

	@Test
	public void testBoard_x147() {

		// Given
		board = new Board();		
		setCell(board, 1, xValue);
		setCell(board, 2, oValue);
		setCell(board, 4, xValue);
		setCell(board, 3, oValue);
		setCell(board, 7, xValue);
		
		// When
		int [] calculatedCells = board.getCellsIfWinner(xValue);
		int [] expectedCells = {1, 4, 7};
		boolean checkDrawResult = board.checkDraw();
		
		// Then
		assertArrayEquals(calculatedCells,expectedCells);
		assertThat(checkDrawResult).isEqualTo(false);
		assertThat(board.getCellsIfWinner(oValue)).isNull();
	}
	
	@Test
	public void testBoard_o258() {

		// Given
		board = new Board();		
		setCell(board, 1, xValue);
		setCell(board, 2, oValue);
		setCell(board, 3, xValue);
		setCell(board, 5, oValue);
		setCell(board, 7, xValue);
		setCell(board, 8, oValue);
				
		// When
		int [] calculatedCells = board.getCellsIfWinner(oValue);
		int [] expectedCells = {2, 5, 8};
		boolean checkDrawResult = board.checkDraw();
		
		// Then
		assertArrayEquals(calculatedCells,expectedCells);
		assertThat(checkDrawResult).isEqualTo(false);
		assertThat(board.getCellsIfWinner(xValue)).isNull();
	}
	
	@Test
	public void testBoard_x048() {

		// Given
		board = new Board();		
		setCell(board, 0, xValue);
		setCell(board, 1, oValue);
		setCell(board, 4, xValue);
		setCell(board, 3, oValue);
		setCell(board, 8, xValue);
		setCell(board, 7, oValue);
		
		// When
		int [] calculatedCells = board.getCellsIfWinner(xValue);
		int [] expectedCells = {0, 4, 8};
		boolean checkDrawResult = board.checkDraw();
		
		// Then
		assertArrayEquals(calculatedCells,expectedCells);
		assertThat(checkDrawResult).isEqualTo(false);
		assertThat(board.getCellsIfWinner(oValue)).isNull();
	}

	@Test
	public void testBoard_o246() {

		// Given
		board = new Board();		
		setCell(board, 0, xValue);
		setCell(board, 2, oValue);
		setCell(board, 5, xValue);
		setCell(board, 4, oValue);
		setCell(board, 7, xValue);
		setCell(board, 6, oValue);
		
		// When
		int [] calculatedCells = board.getCellsIfWinner(oValue);
		int [] expectedCells = {6, 4, 2};
		boolean checkDrawResult = board.checkDraw();
		
		// Then
		assertArrayEquals(calculatedCells,expectedCells);
		assertThat(checkDrawResult).isEqualTo(false);
		assertThat(board.getCellsIfWinner(xValue)).isNull();
	}

	@Test
	public void testBoard_checkDraw_x02567_o1348() {

		// Given
		board = new Board();		
		setCell(board, 0, xValue);
		setCell(board, 1, oValue);
		setCell(board, 2, xValue);
		setCell(board, 3, oValue);
		setCell(board, 5, xValue);
		setCell(board, 4, oValue);
		setCell(board, 6, xValue);
		setCell(board, 8, oValue);
		setCell(board, 7, xValue);

		// When
		boolean checkDrawResult = board.checkDraw();
		
		// Then
		assertThat(checkDrawResult).isEqualTo(true);
		assertThat(board.getCellsIfWinner(xValue)).isNull();
		assertThat(board.getCellsIfWinner(oValue)).isNull();
	}
	
	@Test
	public void testBoard_checkDraw_x02357_o1468() {

		// Given
		board = new Board();
		setCell(board, 0, xValue);
		setCell(board, 1, oValue);
		setCell(board, 2, xValue);
		setCell(board, 4, oValue);
		setCell(board, 3, xValue);
		setCell(board, 6, oValue);
		setCell(board, 5, xValue);
		setCell(board, 8, oValue);
		setCell(board, 7, xValue);
		
		// When
		boolean checkDrawResult = board.checkDraw();
		
		// Then
		assertThat(checkDrawResult).isEqualTo(true);
		assertThat(board.getCellsIfWinner(xValue)).isNull();
		assertThat(board.getCellsIfWinner(oValue)).isNull();
	}
	
	@Test
	public void testBoard_checkDraw_x02457_o1368() {

		// Given
		board = new Board();		
		setCell(board, 0, xValue);
		setCell(board, 1, oValue);
		setCell(board, 2, xValue);
		setCell(board, 3, oValue);
		setCell(board, 4, xValue);
		setCell(board, 6, oValue);
		setCell(board, 5, xValue);
		setCell(board, 8, oValue);
		setCell(board, 7, xValue);
		
		// When
		boolean checkDrawResult = board.checkDraw();
		
		// Then
		assertThat(checkDrawResult).isEqualTo(true);
		assertThat(board.getCellsIfWinner(xValue)).isNull();
		assertThat(board.getCellsIfWinner(oValue)).isNull();
	}
}
