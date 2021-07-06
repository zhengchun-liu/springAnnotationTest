import com.springtestlzc.beans.Person;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
}
