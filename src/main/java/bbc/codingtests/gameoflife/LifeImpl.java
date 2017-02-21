package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;

public class LifeImpl implements Life 
{
	public GameState evolve(GameState currentState) 
	{
		int rows = currentState.getRows();
		int cols = currentState.getCols();
		StringBuffer generationBuilder = new StringBuffer();
		for (int row = 0; row < rows; row++)
		{
			for (int col = 0; col < cols; col++) 
			{
				int neighbours = currentState.aliveNeighbours(row, col);
				boolean alive = currentState.isCellAliveAt(row, col);
				
                if (alive) 
                {
                	if (neighbours < 2 || neighbours > 3) { generationBuilder.append('.');}
                	else { generationBuilder.append('*');} 
                	// generationBuilder.append(neighbours < 2 || neighbours > 3 ?'.' : '*');      	
                 } 
                 else 
                 {
				    if (neighbours == 3) generationBuilder.append('*');
				    else { generationBuilder.append('.');}
				    // generationBuilder.append(neighbours == 3 ?'*' : '.');
				 }
			}
			if (row < rows-1) generationBuilder.append('\n');
		}
		String generation = generationBuilder.toString();
		GameState nextState = new GameStateImpl(generation);
		return nextState;
	}
}
