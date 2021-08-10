import com.springtestlzc.beans.Person;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TestTest {

    @Test
    public void test1() {
        List<Person> taxInvList = new ArrayList<Person>();
        Person person1 = new Person("1", "liu");
        Person person2 = new Person("1", "liu");
        Person person3 = new Person("2", "li");
        Person person4 = new Person("2", "li");
        Person person5 = new Person("3", "si");
        Person person6 = new Person("4", "si");
        taxInvList.add(person1);
        taxInvList.add(person2);
        taxInvList.add(person3);
        taxInvList.add(person4);
        taxInvList.add(person5);
        taxInvList.add(person6);
        //对List根据字段分组
        Map<String, List<Person>> taxInvMap = taxInvList.stream().collect(Collectors.groupingBy(e ->
                e.getAge() + "_" + e.getName()));
        //找出重复的发票
        List<List<Person>> infRepeatLists
                = taxInvMap.entrySet().stream().filter(e -> e.getValue().size() > 1)
                .map(e -> e.getValue()).collect(Collectors.toList());
        for (List<Person> list : infRepeatLists) {
            taxInvList.removeAll(list);
            /*for (Person person : list) {
                person.setMessage("重复");
            }*/
        }
        System.out.println(taxInvList);
    }


    @Test
    public void test2() {
        BigDecimal num1 = null;
        BigDecimal num2 = BigDecimal.ZERO;
        BigDecimal num3 = new BigDecimal("300");

        //System.out.println(num1.compareTo(num2));
        System.out.println(num2.compareTo(num1));
        //System.out.println(num2.compareTo(num3));

    }

    public static void strMove(char[] str) {
        int i = str.length - 1; // 遍历的次数
        int j = i; // j 遍历字符串中的非*字符
        while (j > 0 && str[j] != '*') // 跳过最后面的非'*'字符
        {
            j--;
        }
        while (j > 0 && i >= 0) {
            while (str[i] != '*' && i >= 0) {
                i--;
            }
            while (str[j] == '*' && j >= 0) {
                j--;
            }
        // 交换 j.i 处字符
            str[i--] = str[j]; // *前面的字符后移放到*的位置
            str[j--] = '*'; // 将*前移
        }
        System.out.println(str);
    }

    /**
     * 现再有一字符串*abc**gfe***xyz*，请写一个方法，将*号移到首部，并
     * 不改变其他字母的顺序，即结果为 *******abcgfexy
     */
    @Test
    public void test3() {
        String str = "a*bc**gfe***xyz*";
        char[] strs = str.toCharArray();
        strMove(strs);
    }

    /**
     * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
     * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
     * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
     * 2
     * helloo
     * wooooooow
     * hello
     * woow
     */
    @Test
    public void test4() {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < line; i++) {
            System.out.println(scanner.nextLine().replaceAll("(.)\\1+","$1$1").replaceAll("(.)\\1(.)\\2","$1$1$2"));
        }
    }

    public class Base
    {
        public void methodOne()
        {
            System.out.print("A");
            methodTwo();
        }

        public void methodTwo()
        {
            System.out.print("B");
        }
    }

    public class Derived extends Base
    {
        public void methodOne()
        {
            super.methodOne();
            System.out.print("C");
        }

        public void methodTwo()
        {
            super.methodTwo();
            System.out.print("D");
        }
    }

    @Test
    public void test5() {
        Base b = new Derived();
        b.methodOne();
    }

}
