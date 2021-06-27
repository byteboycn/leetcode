package cn.byteboy.core;

import java.io.File;
import java.util.List;

/**
 * @author hongshaochuan
 * @date 2021/6/27
 */
public interface TestCaseScanner {

    List<TestCase> read(File f);

    List<TestCase> read(String path);
}
