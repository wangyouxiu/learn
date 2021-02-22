package test.CollectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName ArrayListTest
 * @Description TODO
 * @Author Wang Yue
 * @Date 2021/1/13 16:18
 */

public class ArrayListTest {

    @Test
    public void test() {
        ArrayList<String> strings = new ArrayList<String>() {{
            add("1");
            add("2");
            add("3");
            add("4");
            add("5");
        }};
        System.out.println("success");
    }

    @Test
    public void test1(){
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        ArrayList<String> arrayList = new ArrayList();

    }

    @Test
    public void test2() {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(6);
        objects.add(7);
        objects.addAll(1,integers);
        System.out.println(objects);
        objects.forEach(item -> System.out.println(item));

    }


    @Test
    public void test3() {
        int i = Integer.MAX_VALUE + 1;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(i);
    }

    @Test
    public void test4() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("刘一");
        list.add("刘二");
        list.add("单点");
        list.add("等待");
        list.add("饿饿");
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            String str = (String) iter.next();
            if(str.equals("单点")){
                list.remove(str);
            }
        }
    }

    @Test
    public void test5() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("刘一");
        list.add("刘二");
        list.add("单点");
        list.add("等待");
        list.add("饿饿");
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            String str = (String) iter.next();
            if(str.equals("单点")){
                iter.remove();
            }
        }
    }

    @Test
    public void test6() {
        String a = "古时的";
        String b  = "风筝";
        List<String> stringList = Arrays.asList(a,b);
        stringList.add("!!!");
    }

    @Test
    public void test7() {
        String a = "古时的";
        String b  = "风筝";
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(a, b));
        arrayList.add("!!!");
    }

    @Test
    public void test8() {
        List<String> stringList = new ArrayList<>();
        stringList.add("我");
        stringList.add("是");
        stringList.add("风筝");
        List<String> subList = stringList.subList(0, 2);
    }

    @Test
    public void test9() {
        List<String> stringList = new ArrayList<>();
        stringList.add("我");
        stringList.add("是");
        stringList.add("风筝");

        List<String> subList = stringList.subList(0, 3);
        stringList.add("!!!");
        stringList.add("11111");

        subList.get(0);
    }
}