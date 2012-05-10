/*
	Coin.java
		Instructor solution to Coin Class recitation exercise on 4-Sep-2003
*/

import java.util.Random;

public class Coin
{
  private

	final int TAILS=0;
	final int HEADS=1;
	Random r = new Random();

  	int numHeads,numTails;

  public

  	Coin() {} // compiler sets numHeads and numTails to 0 because they are primitives

	String flip()
	{
		int side = r.nextInt(HEADS+1); // produces 0 or 1
		if (side==HEADS)
		{
			++numTails;
			return "T";
		}
		else
		{
			++numHeads;
			return "H";
		}
	}

	public int getNumHeads()
	{
		return numHeads;
	}

	public int getNumTails()
	{
		return numTails;
	}
	public void reset()
	{
		numHeads=numTails=0;
	}
} //EOF