package cn.byteboy.coding.interviews;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Hong Shaochuan
 * @email xhhsc@outlook.com
 * @date 2020/8/16 00:44
 */
public class Duplicate003Test {

    private Duplicate003 duplicate003 = new Duplicate003();

    @Test
    public void test() {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        Assert.assertEquals(2, duplicate003.findRepeatNumber(nums));
    }
}
