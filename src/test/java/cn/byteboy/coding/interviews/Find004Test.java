package cn.byteboy.coding.interviews;

import org.junit.Test;

/**
 * @author Hong Shaochuan
 * @email xhhsc@outlook.com
 * @date 2020/8/17 22:41
 */
public class Find004Test extends AbstractTest {

    private Find004 find004 = new Find004();

    @Test
    public void test() {
        verify();
    }

    @Override
    Object getObj() {
        return find004;
    }

    @Override
    void loadTestCase() {
        testCaseList.add(new TestCase("true", "[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]", "5"));
    }
}
