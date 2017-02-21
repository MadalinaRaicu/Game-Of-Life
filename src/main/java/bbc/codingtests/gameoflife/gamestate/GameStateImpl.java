package bbc.codingtests.gameoflife.gamestate;

public class GameStateImpl implements GameState 
{
	private char[][] matrix;
	private String[] rows;
	//TODO implement this method such that live cells are represented as a '*' and dead cells are represented by a '.'
    //TODO use newline ('\n') to separate rows
    @Override
    public String toString() 
    {
    	StringBuffer generation = new StringBuffer();
        //throw new UnsupportedOperationException("Please implement the 'toString' method");
    	for (int row = 0; row < getRows(); row++) 
    	{
    		for (int col = 0; col < getCols(); col++) 
    		{
    			if (isCellAliveAt(row, col)) { generation.append('*');}
    			else { generation.append('.');}
    		}
    		if (row+1 < getRows()) { generation.append('\n');}
    	}
    	return generation.toString();   
    }

    //TODO implement this constructor to parse an input string and return a new GameStateImpl object representing what you got in the string
    //TODO as above, live cells are '*' and dead cells are '.' Rows are separated by newline ('\n')
    public GameStateImpl(String input) 
    {
        rows = input.split("\n");
        matrix = new char[getRows()][getCols()];
        for (int i = 0; i < getRows(); i++) 
        {
        	matrix[i] = rows[i].toCharArray();
        }
    }

    //TODO implement this method according to explanation in GameState.java
    public boolean isCellAliveAt(int row, int col) 
    {
    	if (row < 0 || col < 0 || row >= getRows() || col >= getCols()) { return false;}
    	if (matrix[row][col] != '*' && matrix[row][col] != '.')
    	{
    		throw new IllegalStateException("Cell input not valid");
    	}
    	return matrix[row][col] == '*';
    }
    
    public int aliveNeighbours(int row, int col) 
    {
    	int num = 0;
    	num = isCellAliveAt(row-1, col-1) ? num+1 : num;
    	num = isCellAliveAt(row-1,   col) ? num+1 : num;
    	num = isCellAliveAt(row-1, col+1) ? num+1 : num;
    	num = isCellAliveAt(  row, col-1) ? num+1 : num;
    	num = isCellAliveAt(  row, col+1) ? num+1 : num;
    	num = isCellAliveAt(row+1, col-1) ? num+1 : num;
    	num = isCellAliveAt(row+1,   col) ? num+1 : num;
    	num = isCellAliveAt(row+1, col+1) ? num+1 : num;
    	return num;
    }

    public int getRows() 
    {
        return rows.length;
    }

    public int getCols() 
    {
        for (int i = 1; i< rows.length; i++) 
        {
        	if (rows[i-1].length() != rows[i].length()) 
        	{
        		throw new IllegalStateException("Not equal number of rows");
        	}
        }
        return rows[0].length();
    }
}
