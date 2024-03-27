package com.itheima.streamsDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 现在有两个ArrayList集合
 * 第一个集合中:存储6名男演员的名字和年龄。第二个集合中:存储6名女演员的名字和年龄。姓名和年龄中间用逗号隔开。比如:张三,23要求完成如下的操作:
 * 1，男演员只要名字为3个字的前两人
 * 2，女演员只要姓杨的，并且不要第一个
 * 3，把过滤后的男演员姓名和女演员姓名合并到一起
 * 4，将上一步的演员信息封装成Actor对象。
 * 5，将所有的演员对象都保存到List集合中。
 * 备注:演员类Actor，属性有:name，age
 * 男演员:"蔡坤坤,24”，"叶齁咸,23"，"刘不甜,22"，"吴签,24"，"谷嘉,30"，"肖梁梁,27”
 * 女演员:"赵小颖,35”"杨颖，36"，"高元元,43"，"张天天,31"，"刘诗,35"，"杨小,33"
 */
public class StreamTask {
    private ArrayList<String> maleActors = new ArrayList<>();
    private ArrayList<String> femaleActors = new ArrayList<>();
    private List<Actor> actors = new ArrayList<>();
    public StreamTask(){
        Collections.addAll((maleActors), "蔡坤坤,24", "叶齁咸,23", "刘不甜,22", "吴签,24", "谷嘉,30", "肖梁梁,27");
        Collections.addAll((femaleActors), "赵小颖,35", "杨颖,36", "高元元,43", "张天天,31", "刘诗,35", "杨小,33");
        this.myAnswer();
    }

    private void myAnswer(){

        List<String> newMaleActors = maleActors.stream()
                .filter(a -> a.split(",")[0].length()== 3) // 过滤出名字长度为三个字的元素
                .limit(2)                               //只留下前两个
                .toList();

        List<String> newFemaleActors = femaleActors.stream()
                .filter(a -> a.split(",")[0].startsWith("杨")) //女演员只要姓杨的
                .skip(1)                                        //并且不要第一个
                .toList();
        Stream.concat(newMaleActors.stream(), newFemaleActors.stream())
                .forEach(s->{
                    String[] arr= s.split(",");
                    actors.add(new Actor(arr[0], Integer.parseInt(arr[1])));
                });
        /**
         * option 2
         */
        List<Actor> result = Stream.concat(
                        maleActors.stream()
                                .filter(a -> a.split(",")[0].length() == 3) // 过滤出名字长度为三个字的元素
                                .limit(2)
                        ,
                        femaleActors.stream()
                                .filter(a -> a.split(",")[0].startsWith("杨")) //女演员只要姓杨的
                                .skip(1))
                .map(a -> new Actor(a.split(",")[0], Integer.parseInt(a.split(",")[1]))) //将字符串元素转化成Actor对象
                .toList(); //进行存储, 这里也可以使用collect方法.

        System.out.println("My Answer is here: ");
        System.out.println(actors);
        System.out.println("One line spirit==================================================");
        System.out.println(result);
    }
}
