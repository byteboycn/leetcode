package cn.byteboy.coding.interviews;

import cn.byteboy.core.test.AbstractTest;
import cn.byteboy.core.test.TestCase;
import org.junit.Test;

/**
 * @author Hong Shaochuan
 * @email xhhsc@outlook.com
 * @date 2020/8/17 22:41
 */
public class Find004Test extends AbstractTest {


    @Test
    public void test() {
        verify();
    }

    @Override
    protected Object getObj() {
        return new Find004();
    }

    @Override
    protected void loadTestCase() {
        testCaseList.add(new TestCase("true", "[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]", "5"));
    }
}
