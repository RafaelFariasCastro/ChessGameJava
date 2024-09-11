package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardExeption("Sorry, there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRow() {
		return rows;
	}


	public int getColuns() {
		return columns;
	}

		
	public Piece piece(int row, int column) {
		if(!positionExists(row, column))
			throw new BoardExeption("Position not on the board");
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardExeption("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(therIsAPiece(position)) {
			throw new BoardExeption("There is alredy a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(),position.getColumn());
	}
	
	public boolean therIsAPiece(Position position) {
		if(!positionExists(row, column)) {
			throw new BoardExeption("Position not on the board");
		}
		return piece(position) != null;
	}
}
