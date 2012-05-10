class Child extends Parent
{
    Child( int v )
    {
        super(v);
    }      
    void echoParent()
    {                
      System.out.println("Parent's i var = " + i );  
    }       
}
