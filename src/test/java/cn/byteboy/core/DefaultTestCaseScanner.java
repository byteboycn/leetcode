package cn.byteboy.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hongshaochuan
 * @date 2021/6/27
 */
public class DefaultTestCaseScanner implements TestCaseScanner {

    @Override
    public List<TestCase> read(File f) {
        BufferedReader r = null;
        List<TestCase> list = new ArrayList<>();
        try {
            r = new BufferedReader(new FileReader(f));
            List<String> lines = new LinkedList<>();
            String line;

            while ((line = r.readLine()) != null) {
                if ("\r".equals(line) || "\r\n".equals(line) || "\n".equals(line) || "".equals(line)) {
                    TestCase testCase = linesToTestCase(lines);
                    if (testCase != null) {
                        list.add(linesToTestCase(lines));
                    }
                    lines.clear();
                } else {
                    lines.add(line);
                }
            }
            TestCase testCase = linesToTestCase(lines);
            if (testCase != null) {
                list.add(testCase);
            }
            lines.clear();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (r != null) {
                    r.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public List<TestCase> read(String path) {
        List<TestCase> list = new ArrayList<>();
        for (File file : scan(path)) {
            list.addAll(read(file));
        }
        return list;
    }


    private TestCase linesToTestCase(List<String> lines) {
        if (lines == null || lines.size() < 2) {
            return null;
        }
        return new TestCase(lines.get(lines.size() - 1), lines.subList(0, lines.size() - 1).toArray(new String[0]));
    }

    private List<File> scan(String path) {
        List<File> files = new ArrayList<>();
        try {
            Enumeration<URL> resources = ClassLoader.getSystemResources(path);
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                File file = new File(url.getPath());
                if (file.isDirectory()) {
                    File[] subFiles = file.listFiles();
                    if (subFiles != null) {
                        for (File subFile : subFiles) {
                            if (subFile.isFile()) {
                                files.add(subFile);
                            }
                        }
                    }
                } else {
                    files.add(file);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }
}
