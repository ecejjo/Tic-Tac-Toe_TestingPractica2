package es.codeurjc.ais.tictactoe;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

import es.codeurjc.ais.tictactoe.TicTacToeGame.Cell;

public class BoardTest {
	
	String xValue = "X";
	String oValue = "O";

	@Test
	public void testBoard_x012() {

		// Given
		Board board = new Board();

		Cell cell = board.getCell(0);
		cell.active = true;
		cell.value = xValue;
		
		cell = board.getCell(1);
		cell.active = true;
		cell.value = xValue;

		cell = board.getCell(2);
		cell.active = true;
		cell.value = xValue;

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
		Board board = new Board();

		Cell cell = board.getCell(3);
		cell.active = true;
		cell.value = oValue;
		
		cell = board.getCell(4);
		cell.active = true;
		cell.value = oValue;

		cell = board.getCell(5);
		cell.active = true;
		cell.value = oValue;

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
		Board board = new Board();

		Cell cell = board.getCell(6);
		cell.active = true;
		cell.value = xValue;
		
		cell = board.getCell(7);
		cell.active = true;
		cell.value = xValue;

		cell = board.getCell(8);
		cell.active = true;
		cell.value = xValue;

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
		Board board = new Board();

		Cell cell = board.getCell(0);
		cell.active = true;
		cell.value = oValue;
		
		cell = board.getCell(3);
		cell.active = true;
		cell.value = oValue;

		cell = board.getCell(6);
		cell.active = true;
		cell.value = oValue;
		
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
		Board board = new Board();

		Cell cell = board.getCell(1);
		cell.active = true;
		cell.value = xValue;
		
		cell = board.getCell(4);
		cell.active = true;
		cell.value = xValue;

		cell = board.getCell(7);
		cell.active = true;
		cell.value = xValue;
		
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
		Board board = new Board();

		Cell cell = board.getCell(2);
		cell.active = true;
		cell.value = oValue;
		
		cell = board.getCell(5);
		cell.active = true;
		cell.value = oValue;

		cell = board.getCell(8);
		cell.active = true;
		cell.value = oValue;
		
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
		Board board = new Board();

		Cell cell = board.getCell(0);
		cell.active = true;
		cell.value = xValue;
		
		cell = board.getCell(4);
		cell.active = true;
		cell.value = xValue;

		cell = board.getCell(8);
		cell.active = true;
		cell.value = xValue;
		
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
	public void testBoard_x0247_o13568() {

		// Given
		Board board = new Board();

		Cell cell = board.getCell(2);
		cell.active = true;
		cell.value = oValue;
		
		cell = board.getCell(4);
		cell.active = true;
		cell.value = oValue;

		cell = board.getCell(6);
		cell.active = true;
		cell.value = oValue;
		
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
	public void testBoard_checkDraw() {

		// Given
		Board board = new Board();

		Cell cell = board.getCell(0);
		cell.active = true;
		cell.value = xValue;

		cell = board.getCell(1);
		cell.active = true;
		cell.value = oValue;

		cell = board.getCell(2);
		cell.active = true;
		cell.value = xValue;

		cell = board.getCell(3);
		cell.active = true;
		cell.value = oValue;
		
		cell = board.getCell(4);
		cell.active = true;
		cell.value = xValue;
		
		cell = board.getCell(5);
		cell.active = true;
		cell.value = oValue;

		cell = board.getCell(6);
		cell.active = true;
		cell.value = oValue;
		
		cell = board.getCell(7);
		cell.active = true;
		cell.value = xValue;

		cell = board.getCell(8);
		cell.active = true;
		cell.value = oValue;

		// When
		int [] calculatedCells = board.getCellsIfWinner(oValue);
		int [] expectedCells = null;
		boolean checkDrawResult = board.checkDraw();
		
		// Then
		assertArrayEquals(calculatedCells,expectedCells);
		assertThat(checkDrawResult).isEqualTo(true);
		assertThat(board.getCellsIfWinner(xValue)).isNull();
		assertThat(board.getCellsIfWinner(oValue)).isNull();
	}
}
