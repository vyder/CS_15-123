package introExam;

import edu.cmu.cs.pattis.cs151xx.Prompt;
import edu.cmu.cs.pattis.cs151xx.TypedBufferReader;
import java.io.EOFException;
import java.util.Iterator;
import java.util.NoSuchElementException;


/************************************************
A minimal file reading class for use within the
15-111/200 Final Exam/Spring 2005
*************************************************/

public class ExamIO {

   /**
   *  Returns an Iterator that produces, by calling <code>next</code>,
   *    a <code>String</code> containing the next line in the file.
   *  Use a StringTokenizer to get the individual tokens from this lline.
   *
   *  @param prompt the message to prompt the user for the file name
   *
   *  @return an Iterator that produces, by calling <code>next</code>,
   *    a <code>String</code> containing the next line in the file
   */
	public static Iterator readFile (String prompt)
	{return new IOIterator(new TypedBufferReader(prompt));}
	    

  public static class IOIterator implements Iterator {
		private TypedBufferReader file;
		private boolean           hasNext = true;
		private String            line;
    public IOIterator (TypedBufferReader tbr)
    {
      file = tbr;
      try {
        line = file.readLine();
      } catch (EOFException eofe) {hasNext = false;}
    
    }

    public boolean hasNext()
    {return hasNext;}
    
    public Object next()
    {
      if (!hasNext)
        throw new NoSuchElementException();
       
      String answer = line;
      try {
        line = file.readLine();
      } catch (EOFException eofe) {hasNext = false;}
      return answer;
    }
    
    public void remove()
    {throw new UnsupportedOperationException();}
  }

}


