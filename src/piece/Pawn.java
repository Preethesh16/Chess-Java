package piece;

import main.GamePanel;

public class Pawn extends Piece {

	public Pawn(int color, int col, int row) {
		super(color, col, row);
		
		if(color==GamePanel.WHITE) {
			image =getImage("/piece/w-pawn");
		}
		else
		{
			image =getImage("/piece/b-pawn");
		}
	}

	public boolean canMove(int targetCol,int targetRow) {
		if(isWithinBoard(targetCol,targetRow)&& isSameSquare(targetCol,targetRow)==false) {
		//define the move value based on its color
			int moveValue;
			if(color==GamePanel.WHITE) {
				moveValue=-1;
			}
			else {
				moveValue=1;
			}
			//check hitting piece
			hittingP = getHittingP(targetCol, targetRow);
			//1 square for movement
			if(targetCol==preCol &&  targetRow ==preRow + moveValue && hittingP==null)
			{
				return true;
			}
		}
		return false;
	}
	
}
