package piece;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Board;
import main.GamePanel;
import main.Type;

public class Piece {
	public Type type;
	public BufferedImage image;
	public int x,y;
	public int col,row,preCol, preRow;
	public int color;
	public Piece hittingP;
	public boolean moved,twoStepped;//for castle n pawn movement
	
	public Piece(int color,int col,int row) {
		this.color=color;
		this.col=col;
		this.row=row;
		x =getX(col);
		y= getY(row);
		preCol=col;
		preRow=row;
	}
	public BufferedImage getImage(String imagePath) {
		
		BufferedImage image =null;
		
		try {
			image=ImageIO.read(getClass().getResourceAsStream(imagePath +".png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public int getX(int col) {
	return col*Board.SQUARE_SIZE;	
	}
	public int getY(int row) {
		return row * Board.SQUARE_SIZE;
	}
	public int getCol(int x) {
		return (x + Board.HALF_SQUARE_SIZE)/Board.SQUARE_SIZE;
	}
	public int getRow(int y) {
		return (y + Board.HALF_SQUARE_SIZE)/Board.SQUARE_SIZE;
	}
	public int getIndex()
	{
		for(int index=0;index<GamePanel.simPieces.size();index++) {
			if(GamePanel.simPieces.get(index)==this) 
			{
				return index;
			}
		}
		return 0;
	}
	public void updatePosition()
	{
		//To check En Passant
		if(type==Type.PAWN) {
			if(Math.abs(row-preRow)==2) {
				twoStepped = true;
			}
		}
		
		
		x=getX(col);
		y=getY(row);
		preCol = getCol(x);
		preRow = getRow(y);
		moved =true;
	}
	public void resetPosition() {
		
		col=preCol;
		row=preRow;
		x=getX(col);
		y=getY(row);
	}
	public boolean canMove(int targetCol,int targetRow) {
		return false;
	}
	public boolean isWithinBoard(int targetCol, int targetRow) {
		if(targetCol >=0 && targetCol<=7 && targetRow >=0 && targetRow <= 7) {
			return true;
		}
		return false;
	}
	public Piece getHittingP(int targetCol,int targetRow)
	{
		for(Piece piece :GamePanel.simPieces)
		{
			if(piece.col== targetCol && piece.row == targetRow && piece != this)
			{
				return piece;
			}
		}
		return null;
	}
	public boolean isSameSquare(int targetCol,int targetRow) {
	
		if(targetCol== preCol && targetRow ==preRow) {
			return true;
		}
		return false;
	}
	public boolean pieceIsOnStraightLine(int targetCol,int targetRow) {
		//when pieces are moving towards left no direct jump between the pieces
		for(int c=preCol-1;c>targetCol;c--) {
			for(Piece piece: GamePanel.simPieces) {
				if(piece.col==c && piece.row==targetRow) {
					hittingP=piece;
					return true;
				}
			}
		}
		//when pieces are moving towards right no direct jump between the pieces
				for(int c=preCol+1;c<targetCol;c++) {
					for(Piece piece: GamePanel.simPieces) {
						if(piece.col==c && piece.row==targetRow) {
							hittingP=piece;
							return true;
						}
					}
				}
				//when pieces are moving towards up no direct jump between the pieces
				for(int r=preRow-1;r>targetRow;r--) {
					for(Piece piece: GamePanel.simPieces) {
						if(piece.col==targetCol && piece.row==r) {
							hittingP=piece;
							return true;
						}
					}
				}
				//when pieces are moving towards down no direct jump between the pieces
				for(int r=preRow+1;r<targetRow;r++) {
					for(Piece piece: GamePanel.simPieces) {
						if(piece.col==targetCol && piece.row==r) {
							hittingP=piece;
							return true;
						}
					}
				}
		return false;
	}
	public boolean pieceIsOnDiagonalLine(int targetCol,int targetRow) {
		
		if(targetRow<preRow)
		{
			//when pieces are moving towards left-upside no direct jump between the pieces
			for(int c=preCol-1;c>targetCol;c--) {
			int diff =Math.abs(c-preCol);
			for(Piece piece: GamePanel.simPieces) {
				if(piece.col==c && piece.row==preRow -diff) {
					hittingP=piece;
					return true;
				}
			}
		}
			//up-right
			for(int c=preCol+1;c<targetCol;c++) {
			int diff =Math.abs(c-preCol);
			for(Piece piece: GamePanel.simPieces) {
				if(piece.col==c && piece.row==preRow -diff) {
					hittingP=piece;
					return true;
				}
			}
		}		
	}
		else {
			//down left
			for(int c=preCol-1;c>targetCol;c--) {
				int diff =Math.abs(c-preCol);
				for(Piece piece: GamePanel.simPieces) {
					if(piece.col==c && piece.row==preRow +diff) {
						hittingP=piece;
						return true;
					}
				}
			}
			//Down right
			for(int c=preCol+1;c<targetCol;c++) {
				int diff =Math.abs(c-preCol);
				for(Piece piece: GamePanel.simPieces) {
					if(piece.col==c && piece.row==preRow +diff) {
						hittingP=piece;
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean isValidSquare(int targetCol, int targetRow) {
		hittingP = getHittingP(targetCol, targetRow);
		if(hittingP==null) {//square khali hai
			return true;
		}else {// ye square occupied hai
			if(hittingP.color !=this.color) {// different color ka hai toh capture hoga
				return true; 
			}
			else {
				hittingP=null;
			}
		}
		return false;
	}
	public void draw(Graphics2D g2) {
		g2.drawImage(image, x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE,null);
	}
}
