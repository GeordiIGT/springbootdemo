package com.itheima.streamsDemo;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo1 {
    private ArrayList<String> list = new ArrayList<>();

    public StreamDemo1() {
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰", "张翠山", "张良", "王二麻子", "谢广坤");
    }

    /**
     * arraylist的遍历和过滤
     * 创建集合添加元素, 完成以下需求:
     * 1. 把所有以'张'开头的元素存储到一个新的集合中
     * 2. 把所有以'张'开头,并且长度为3的元素存储到一个新的集合中
     * 3. 遍历打印最终的结果
     */
    public void test3() {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("张无忌");
        list1.add("周芷若");
        list1.add("赵敏");
        list1.add("张强");
        list1.add("张三丰");

        //1. 把所有以'张'开头的元素存储到一个新的集合中
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        for (String name : list1) {
            if (name.startsWith("张")) {
                list2.add(name);
                if (name.length() == 3) {
                    list3.add(name);
//                    System.out.println(name);
                }
            }
        }
//        System.out.println(list3);

        //使用stream方法实现相同的功能, 并将结果存储到list4变量中
        list1.stream().filter(name -> name.startsWith("张")).filter(name -> name.length() == 3).forEach(System.out::println);
        list1.stream().filter(name -> name.length() == 3).forEach(System.out::println);


    }

    /**
     * 使用stream对下列集合进行操作
     * 单列集合
     * 双列集合
     * 数组
     * 零散数据
     **/
    public void test4() {
        //单列集合
//        this.collectionTest();
        //双列集合
//        this.mapTest();
        //数组
//        this.arrayTest();
        //零散数据
//        this.bitsTest();
        //过滤
//        this.filterTest();
        //跳过 和 限额
//        this.skipAndLimitTest();
        //去重 and 合并
//        this.distinctAndConcatTest();
        //类型转换map
//        this.streamMapTest();
        //forEach
//        this.forEachTest();
        //count
//        this.countTest();
        //collect
//        this.collectTest();
        //toArray
//        this.toArrayTest();
    }

    private void collectTest() {
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "张无忌-男-15", "周芷若-女-16", "赵敏-女-17", "张强-男-18", "张三丰-男-100", "张翠山-男-34", "张良-男-55", "王二麻子-男-0", "谢广坤-男-45");
        System.out.println("To List======================================");
        //收集到List, 把所有的男性元素收集到List中
        List<String> rsList = list1.stream()
                .filter(s -> "男".equals(s.split("-")[1])) //在使用equals方法时, 一定要把确定的值写在前面, 避免空指针异常
                .collect(Collectors.toList());
        System.out.println(rsList);
        //收集到Set
        System.out.println("To Set======================================");
        Set<String> rsSet = list1.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toSet());
        System.out.println(rsSet);
        //收集到Map
        System.out.println("To Map======================================");
        /**
         * toMap方法:
         * 第一个参数是Key键的生成规则,
         * 第二个参数是Value值的生成规则
         * 参数一:
         *      Function泛型一: 表示流中的元素类型
         *      Function泛型二: 表示Key键的类型
         *          apply方法的形参: 表示流中的每一个数据元素
         *          apply方法的返回值: 表示生成的Key键
         */
        Map<String, Integer> rsMap = list1.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(
                        new Function<String, String>() { //第一个String表示流中的元素类型, 第二个String表示Key键的类型,也就是apply方法返回值的类型
                            @Override
                            public String apply(String s) {
                                return s.split("-")[0];
                            }
                        },
                        new Function<String, Integer>() { //第一个String表示流中的元素类型, 第二个Integer表示Value值的类型,也就是apply方法返回值的类型
                            @Override
                            public Integer apply(String s) {
                                return Integer.parseInt(s.split("-")[2]);
                            }
                        }));
        System.out.println(rsMap);
        System.out.println("To Map (lambda)-----------------------------------");
        //Lambda
        rsMap = list1.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(s -> s.split("-")[0], s -> Integer.parseInt(s.split("-")[2])));
        /**/
        System.out.println(rsMap);
}

private void toArrayTest() {
    //无参数的toArray方法, 返回的是一个Object数组
    Object[] arr = list.stream().toArray();
    System.out.println(Arrays.toString(arr));
    System.out.println("======================================");
    /**
     * toArray的参数IntFunction的作用是创建一个指定类型的数组
     * toArray的底层, 会依次得到流中的数据,并存储到创建的数组中
     * toArray的返回值是一个装着流里面所有数据的数组
     */
    String[] arr1 = list.stream().toArray(new IntFunction<String[]>() {
        @Override
        public String[] apply(int value) { //注意这里的参数类型是int
            System.out.println(value);
            return new String[value]; //这里的方法体实际上只被调用了一次, value值为最终数组的长度
        }
    });
    System.out.println(Arrays.toString(arr1));
    System.out.println("======================================");
    //lambda表达式
    String[] arr2 = list.stream().toArray((value) -> new String[value]);
    System.out.println(Arrays.toString(arr2));
}

private void countTest() {
    long count = list.stream().count();
    System.out.println(count);
    System.out.println("===================================");
    System.out.println(list.stream().count());
}

private void forEachTest() {
    /**
     * forEach方法的参数是一个Consumer接口, 所以可以传递一个Lambda表达式
     * Consumer接口是一个消费型接口, 可以传递Lambda表达式, 泛型是流中的数据类型
     *  accept方法的参数(形参)依次表示流中的数据, 其数据类型需要与Consumer的泛型保持一致
     *  accept 方法的方法体, 就是对数据进行处理的代码
     */
        /*list.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) { //参数类型需要于Consumer的泛型一致
                System.out.println(s); //除了可以打印还可以进行存储等操作, 但是不可以修改
            }
        });*/
    //lambda表达式
    list.stream().forEach(s -> System.out.println(s));
}

private void streamMapTest() {
    ArrayList<String> list1 = new ArrayList<>();
    Collections.addAll(list1, "张无忌-15", "周芷若-16", "赵敏-17", "张强-18", "张三丰-100", "张翠山-34", "张良-55", "王二麻子-0", "谢广坤-45");
    list1.stream().map(new Function<String, Integer>() {
        @Override
        public Integer apply(String s) {
            String[] arr = s.split("-");
            String ageString = arr[1];
            int age = Integer.parseInt(ageString);
            return age;
        }
    }); //.forEach(age-> System.out.println(age));

    list1.stream()
            .map(s -> Integer.parseInt(s.split("-")[1]))
            .forEach(age -> System.out.println(age));
}

private void distinctAndConcatTest() {
    ArrayList<String> list1 = new ArrayList<>();
    ArrayList<String> list2 = new ArrayList<>();
    Collections.addAll(list1, "a", "b", "c", "d", "e", "a", "b");
    Collections.addAll(list2, "x", "y", "z");

    list1.stream().distinct().forEach(s -> System.out.println(s)); //去重
    System.out.println("===================================");
//        list1.stream()
    Stream.concat(list1.stream(), list2.stream()).forEach(s -> System.out.println(s)); //合并两个集合
    Stream<String> s = Stream.concat(list1.stream(), list2.stream()); //合并两个集合
}

private void skipAndLimitTest() {
    list.stream().skip(2).forEach(s -> System.out.println(s)); //跳过前两个元素, 如果n值大于集合的长度, 则返回空集合
    System.out.println("===================================");
    list.stream().limit(3).forEach(s -> System.out.println(s)); //只要前三个元素,如果n值大于集合的长度, 则返回原集合
}

private void filterTest() {

    //过滤出所有姓张的人
        /*list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                //如果返回值是true, 则表示s这个元素保留
                //如果返回值是false, 则表示s这个元素舍弃不要
                return s.startsWith("张");
            }
        }).forEach(System.out::println);*/
    list.stream().filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));
}

private void collectionTest() {
    ArrayList<String> list = new ArrayList<>();
    Collections.addAll(list, "a", "b", "c", "d", "e");
    Stream<String> stream1 = list.stream(); //ctrl+alt+v
    stream1.forEach(new Consumer<String>() {
        @Override
        public void accept(String s) {
            //s: 依次表示stream流上的每一个元素
            System.out.println(s);
        }
    });

//        list.stream().forEach(s-> System.out.println(s));
}

private void mapTest() {
    HashMap<String, String> hm = new HashMap<>(); //hashmap是一个双列集合,key 是无序的
    hm.put("aaa", "1");
    hm.put("bbb", "2");
    hm.put("ccc", "3");
    hm.put("ddd", "4");
    hm.put("eee", "5");
    hm.replace("aaa", "000"); //替换key为aaa的value, 更新操作?

    //获取所有的key, 这里的key是一个set集合,可以保证不重复性
    Set<String> keySet = hm.keySet();
    //获取所有的value, 这里的value是一个collection集合, 不一定是非重复的数据.
    Collection<String> values = hm.values();

//        keySet.stream().forEach(k-> System.out.println(k));
//        values.stream().forEach(v-> System.out.println(v));

    //获取所有的key-value对, 这里的entry是一个set集合, 可以保证不重复性
    Set<Map.Entry<String, String>> entries = hm.entrySet();
//        entries.stream().forEach(entry-> System.out.println(entry.getKey()+"="+entry.getValue()));
    entries.stream().forEach(entry -> System.out.println(entry));
}

private void arrayTest() {
    int[] arr1 = {1, 2, 3, 4, 5}; //这是一个基本数据类型
    String[] arr = {"a", "b", "c", "d", "e"}; //这是一个引用数据类型
    Arrays.stream(arr1).forEach(i -> System.out.println(i));
    System.out.println("===================================");
    Arrays.stream(arr).forEach(s -> System.out.println(s));
}

private void bitsTest() {
    int[] arr1 = {1, 2, 3, 4, 5}; //这是一个基本数据类型
    String[] arr = {"a", "b", "c", "d", "e"}; //这是一个引用数据类型
    Stream.of(arr).forEach(s -> System.out.println(s)); //正确结果 abcde
    Stream.of(arr1).forEach(s -> System.out.println(s)); //错误结果 [I@2f3166a
}
}
