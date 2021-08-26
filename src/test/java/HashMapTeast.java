import com.springtestlzc.beans.Blue;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class HashMapTeast {

    public static void main(String[] args) {
        //HashMap hashMap = new HashMap();
        //Integer i = 5;
        String s = "fasdg";
        //System.out.println(i.hashCode());
        System.out.println(s.hashCode());
        HashSet hashSet = new HashSet();
        //hashSet.add();
    }

    @Test
    public void test() throws Exception {
        Blue resultInfs = new Blue();
        List<String> list = new ArrayList<>();
        list.add("合同价格及设备配置清单");
        list.add("采购订单格式");
        resultInfs.setAnnexList(list);
        Blue object = new Blue();
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if ("annexList".equals(field.getName())) {
                List<String> stringList = (List<String>) HashMapTeast.getGetMethod(resultInfs,field.getName());
                StringBuilder listString = new StringBuilder();
                String str = null;
                for (String s : stringList) {
                    listString.append(s).append(";");
                }
                if (listString.length() > 1) {
                    //listString.
                    str = listString.substring(0,listString.length() - 1);
                }
                System.out.println(str);
            }
        }
    }

    /**
     * 根据属性，获取get方法
     * @param ob 对象
     * @param name 属性名
     * @return
     * @throws Exception
     */
    public static Object getGetMethod(Object ob , String name) throws Exception{
        try {
            String firstLetter = name.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + name.substring(1);
            Method method = ob.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(ob, new Object[] {});
            return value;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Test
    public void test2() {
        Blue b = new Blue();
        System.out.println(b == null);
        System.out.println(b != null);
    }
}
