Knight's Tour Code
Mary R. Taft

An instance of a Knight contains a board whose dimensions are n*n (based on the input in the constructor).  The "solve" method determines if and how a knight's tour (when a knight, as in the chess piece, makes a sequence of moves in such a way that it touches every position on the board at least once and only once) can be made in that board.  The "solveClosed" method determines if and how a closed tour can be made (such that the path the knight travels is a cycle).

The instance variables are "board," a 2D array of ints which will be used to hold the move numbers of the solution; length, which simply holds the board's side length (since it is a square, only one variable is required); and solved (initialized as false), which holds whether, at any given time, the solution to the knight's tour to the board has been found.

Before either the "solve" or "solveClosed" method is the boolean-returning method "isOutofBounds."  This will be used in both the solve methods to prevent calling a method which will try to reference an array index on the "board" which doesn't exist.

"solve" is a recursive method whose base case is that the move number (the parameter "int n") is one greater than the number of positions on the board.  (For example, if "n" is 26 on a 5*5 board, whose last move should be 25.)  If the base case is reached, "solved" will be set true, and all recursion will cease.  For so long as it isn't solved, the 'knight' (at position board[x][y]) will place its move number on an 'empty' position (where board[x][y] is 0) or try another move.  If all possible moves within the limits (in bounds) of the "board" have been exhausted, it will then backtrack, reverting the move number to a 0 on the "board."

"solveClosed" functions the same way, but its base case is more specific - not only does the 'knight' have to have reached its final move, but it also must be one move away from the starting location (which in this particular code is always (0,0)).