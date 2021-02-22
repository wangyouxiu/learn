package test.CollectionTest;

import org.junit.Test;

import java.util.LinkedHashMap;

/**
 * @ClassName LinkedHashMapTest
 * @Description TODO
 * @Author Wang Yue
 * @Date 2021/1/21 13:57
 */

public class LinkedHashMapTest {

    @Test
    public void test() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>(16, 0.75f, true);
        linkedHashMap.put("aaa", "111");
        linkedHashMap.put("aaa", "222");
        linkedHashMap.remove("aaa");

    }

}