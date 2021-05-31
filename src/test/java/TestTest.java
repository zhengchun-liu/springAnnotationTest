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
}
