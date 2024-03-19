package org.example;

import junit.framework.TestCase;

public class MyStringTest extends TestCase {

    public void testIndexOfString() {
        int result=MyString.indexOfString("hello world","world",0);
        assertEquals(-2,result);
    }
}