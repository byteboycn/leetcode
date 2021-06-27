package cn.byteboy.difficulty.medium._322;

import cn.byteboy.core.AbstractTest;
import cn.byteboy.core.TestCase;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author hongshaochuan
 * @date 2021/6/26
 */
public class CoinChangeTest extends AbstractTest {


    @Test
    public void test() {
        verify();
    }



    @Override
    protected Object getObj() {
        return new CoinChange();
    }

    @Override
    protected void loadTestCase() {
        super.testCaseList.addAll(testCaseScanner.read("TestCases/difficulty/medium/_322"));
    }
}
