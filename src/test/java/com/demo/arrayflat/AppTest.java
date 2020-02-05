package com.demo.arrayflat;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp(){
        String[] args = {"[410  ,[1,2,[3]],4777,[5,[6,[7,[8,[889]]]]]"};
        AppFlatArray.main(args);
        assertEquals(new Integer(410), AppFlatArray.arrayFlat.get(0));
    }
    
    public void testApp1(){
        String[] args = {"[[1,2,[3]],4,[5,[6]]"};
        AppFlatArray.main(args);
        assertEquals(new Integer(6), AppFlatArray.arrayFlat.get(5));
    }
}
