package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.helloworld;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainActivityUnitTest extends TestCase {
    MainActivity mainActivity;

    @Before
    public void setUp(){
        mainActivity = new MainActivity();
    }

    @Test
    public void test_ganjil_check(){
        assertTrue(mainActivity.cekGanjil(17));
    }

    @After
    public void tearDown(){}
}
