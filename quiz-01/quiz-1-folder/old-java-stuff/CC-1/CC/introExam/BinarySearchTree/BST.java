package introExam.BinarySearchTree;


/************************************************
A minimal <code>BST</code> class using a nested
<code>BSTNode</code> class, for the 15-111/200
Final Exam/Spring 2005
<p>
Students are not permitted to modify or augment
this class in any way. This file must not change.
<p>
Note that all instance variables declared in the
nested <code>BSTNode</code> class are <code>public</code>
and that <code>value</code> is also declared with
the <code>final</code> access modifier.
<p>
Thus, the information that they store can be accessed
through these names directly, or through the provided
getters/setters (except <code>value</code> cannot be
changed once it has been initialized, and it has no
setter).
*************************************************/


public class BST {

  protected BSTNode root;


  /**
   * The default constructor: creates an empty binary search tree
   */
  public BST()
  {
    root = null;
  }


  /**
   * Inserts a value into the proper position of a binary search tree.
   *  @param value to be inserted into the binary search tree
   */
  public void insert(Comparable data)
  {
    if (null == data)
      return;
    
    root = insert(root, data);
  }


  /**
   * This is a helper method -- no further description available
  */
  private BSTNode insert(BSTNode root, Comparable value)
  {
    if (null == root)
      return new BSTNode(value);
    
    if (value.compareTo(root.getValue()) == 0)
      return root;
    
    if (value.compareTo(root.getValue()) < 0)
      root.setLeft ( insert(root.getLeft(), value) );
    else
      root.setRight ( insert(root.getRight(), value) );
    
    return root;
  }


  /**
   * This is a helper method -- no further description available
   */
  private String niceTreeString (BSTNode t, String indent)
  {
    return (t==null?"":(t.getRight()==null?"":niceTreeString(t.getRight(),"  "+indent)) +
           indent+t.getValue()+System.getProperty("line.separator")+
           (t.getLeft()==null?"":niceTreeString(t.getLeft(),"  "+indent)));
  } 


  /**
   * Provides a nice string represention of a BST. 
   * <p>
   * Students should not concern themselves with how it works -- an 
   * understanding of this is not important to this exam.
   */
  public String toString()
  {
    if (root == null)
      return "(empty tree)";
    else
      return niceTreeString(root,"  ");
  }

  
  protected class BSTNode {

     //Public instance variables: no need for getters/settors
     
     /**
      *  Note <code>final</code> access modifier: cannot be changed!
      *  Also, there is no setter for <code>value</code>.
     */
     public final Comparable value;
     
     public BSTNode left, right;


     /**
     *  Constructor builds the BSTNode with the supplied parameter;
     *  it has empty subtrees.
     *  @param value to store in this node
     */
     public BSTNode(Comparable value)
     {
        this.value = value;
        this.left = this.right = null;
     }


     /**
     *  Constructor builds the BSTNode with the supplied parameters.
     *  @param value to store in this node
     *  @param left  must refer to its left subtree
     *  @param right must refer to its right subtree
     */
     public BSTNode(Comparable value, BSTNode left, BSTNode right)
     {
        this.value = value;
        this.left  = left;
        this.right = right;
     }

     
     
     //////////
     //
     //  Getters and Setters for those students who want to use them.
     //
     //////////
     
     
     /**
     *  Returns reference to the left child, or null, if none.
     *  @return reference to left child
     */
     public BSTNode getLeft()
     {
        return left;
     }


     /**
     *  Returns reference to the right child, or null, if none.
     *  @return reference to right child
     */
     public BSTNode getRight()
     {
        return right;
     }


     /**
     *  Sets the left-child reference of this object to the parameter object.
     *  @param newLeftChild which is an object of the class BSTNode
     */
     public void setLeft(BSTNode newLeftChild)
     {
       left = newLeftChild;
     }


     /**
     *  Sets the right-child reference of this object to the parameter object.
     *  @param newRightChild which is an object of the class BSTNode
     */
     public void setRight(BSTNode newRightChild)
     {
       right = newRightChild;
     }


     /**
     *  Returns reference to the value of the object.
     *  @return reference to the value
     */

     public Comparable getValue()
     {
        return value;
     }


     /**
     *  Returns string representation of the object
     *  @return String reference
     */
     public String toString()
     {
        return value.toString();
     }
  }
}
