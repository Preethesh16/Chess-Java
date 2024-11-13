package piece;
import main.GamePanel;

public class King extends Piece {

	public King(int color, int col, int row) {
		super(color, col, row);
		
		if(color==GamePanel.WHITE) {
			image =getImage("/piece/w-king");
		}
		else
		{
			image =getImage("/piece/b-king");
		}
	}

	public boolean canMove(int targetCol,int targetRow) {
		if(isWithinBoard(targetCol,targetRow)) {
			//for horizontal and vertical squares for the king //second for diagonals
			if(Math.abs(targetCol-preCol) + Math.abs(targetRow - preRow)==1 || Math.abs(targetCol-preCol) * Math.abs(targetRow - preRow)==1) 
			{
				if(isValidSquare(targetCol,targetRow)) {
				return true;
				}
			} //castle
			if(moved==false)
			{
				//right
				if(targetCol ==preCol+2 && targetRow == preRow && pieceIsOnStraightLine(targetCol,targetRow)==false) {
					for(Piece piece: GamePanel.simPieces)
					{
						if(piece.col==preCol+3 && piece.row ==preRow && piece.moved==false) {
							GamePanel.castlingP=piece;
							return true;
						}
				}
					//left
					
			}	
				
		}
		return false;
	}
	}	
}
