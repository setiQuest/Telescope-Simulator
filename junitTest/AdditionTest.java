package seti.junitTest;

import junit.framework.TestCase;

public class AdditionTest extends TestCase{
	Addition addition = null;
	
	
    public AdditionTest(String name) {
         super(name);
    }

    /*
     * (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
         super.setUp();
         addition = new Addition();
    }
	
    /*
    * Test method for 'Addition.add(int, int)'
    */
         public void testAdd() {
              int x = addition.add(5,6);
              assertEquals(11, x);
         }
         
         public static void main(String[] args) {
             junit.textui.TestRunner.run(AdditionTest.class);
        }
}
