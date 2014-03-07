import java.io.*;
import java.util.*;

public class Knight {

    private int[][] board;
    private int length;
    private boolean solved=false;

    public Knight(int n) {
	board = new int[n][n];
	for (int i=0;i<board.length;i++) {
	    for (int j=0;j<board[0].length;j++)
		board[i][j]=0;
	}
	length=n;
    }

    public void solve() {
	solve(0,0,1);
    }

    public boolean isOutofBounds(int x, int y) {
	if(x>=length||x<0||y>=length||y<0)
	    return true;
	return false;
    }

    public void solve(int x, int y, int n) {
	// System.out.println(this); // prints the board at each step
	if(n==length*length+1){ // or simply (n>length*length)
	    solved=true;
	}else if(!solved&&board[x][y]==0){
	    board[x][y]=n;
	    if (!isOutofBounds(x+1,y+2)/*&&!solved*/) solve(x+1,y+2,n+1);
	    if (!isOutofBounds(x-1,y+2)&&!solved) solve(x-1,y+2,n+1);
	    if (!isOutofBounds(x+1,y-2)&&!solved) solve(x+1,y-2,n+1);
	    if (!isOutofBounds(x-1,y-2)&&!solved) solve(x-1,y-2,n+1);
	    if (!isOutofBounds(x+2,y+1)&&!solved) solve(x+2,y+1,n+1);
	    if (!isOutofBounds(x-2,y+1)&&!solved) solve(x-2,y+1,n+1);
	    if (!isOutofBounds(x+2,y-1)&&!solved) solve(x+2,y-1,n+1);
	    if (!isOutofBounds(x-2,y-1)&&!solved) solve(x-2,y-1,n+1);
	    if (!solved) board[x][y]=0;
	}
	if(solved&&n<=length*length) System.out.println("Move: "+n+"; Position: ("+x+", "+y+")");
    }

    public void solveClosed() {
   	solveClosed(0,0,1);
    }

    public void solveClosed(int x, int y, int n) {
   	if(n==length*length && ((x-1==0&&y-2==0)||(x-2==0&&y-1==0)) && board[x][y]==0){
	    board[x][y]=n;
   	    solved=true;
	}else if(!solved&&board[x][y]==0){
   		board[x][y]=n;
   	    if (!isOutofBounds(x+1,y+2)) solveClosed(x+1,y+2,n+1);
   	    if (!isOutofBounds(x-1,y+2)&&!solved) solveClosed(x-1,y+2,n+1);
   	    if (!isOutofBounds(x+1,y-2)&&!solved) solveClosed(x+1,y-2,n+1);
   	    if (!isOutofBounds(x-1,y-2)&&!solved) solveClosed(x-1,y-2,n+1);
   	    if (!isOutofBounds(x+2,y+1)&&!solved) solveClosed(x+2,y+1,n+1);
   	    if (!isOutofBounds(x-2,y+1)&&!solved) solveClosed(x-2,y+1,n+1);
   	    if (!isOutofBounds(x+2,y-1)&&!solved) solveClosed(x+2,y-1,n+1);
   	    if (!isOutofBounds(x-2,y-1)&&!solved) solveClosed(x-2,y-1,n+1);
   	    if(!solved) board[x][y]=0;
   	}
	if(solved&&n<=length*length) System.out.println("Move: "+n+"; Position: ("+x+", "+y+")"); 
  }

    public String toString() {
	String ans = "Board:\n";
	for (int i=0;i<board.length;i++) {
	    for (int j=0;j<board[0].length;j++)
		ans+=board[i][j]+ "\t";
	    ans+="\n";
	}
	return ans;
    }
}
