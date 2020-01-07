package com.didispace;


import java.util.*;
import java.util.stream.Collectors;

public class JavaStreamTest {

    private static List<Person> personList = new ArrayList<>();

    public static void main(String[] args) {

        personList.add(new Person(1L , "猪爸爸", 30, "男"));
        personList.add(new Person(2L , "猪妈妈", 28, "女"));
        personList.add(new Person(3L , "佩奇", 5, "女"));
        personList.add(new Person(3L , "佩奇", 5, "女"));
        personList.add(new Person(3L , "佩奇", 5, "女"));
        personList.add(new Person(3L , "佩奇", 5, "女"));
        personList.add(new Person(3L , "佩奇", 5, "女"));
        personList.add(new Person(4L , "乔治", 2, "男"));

        System.out.println("hello");

        System.out.println("===foreach循环===");
        for (Person person : personList){
            System.out.println(person.toString());
        }

        System.out.println("===Java8的foreach()===");
        personList.forEach(person -> System.out.println(person.toString()));

        System.out.println("===foreach()年龄都加1岁===");
        personList.forEach(p -> p.setAge(p.getAge() + 1));
        print();

        System.out.println("===map toList===");
        //获取id的List集合
        List<Long> ids = personList.stream().map(Person::getId).collect(Collectors.toList());
        ids.forEach(id -> System.out.println(id));

        System.out.println("===map toSet===");
        //获取性别的Set集合
        Set<String> genders = personList.stream().map(Person::getGender).collect(Collectors.toSet());
        genders.forEach(gender -> System.out.println(gender));

        System.out.println("===获取名称以逗号分隔===");
        String names = personList.stream().map(Person::getName).collect(Collectors.joining(","));
        System.out.println(names);

        System.out.println("===List 转 Map<Long, Person> 根据ID分组===");
        //如果ID重复就用第一个
        Map<Long, Person> mapById = personList.stream().collect(Collectors.toMap(Person::getId, a -> a, (k1, k2) -> k1));
        mapById.forEach((key, value) -> System.out.println(key + " -> " + value.toString()));

        System.out.println("===List 转 Map<String, Person> 根据gender分组===");
        //如果gender重复就用第一个
        Map<String, Person> mapByGender = personList.stream().collect(Collectors.toMap(Person::getGender, a -> a, (k1, k2) -> k1));
        mapByGender.forEach((key, value) -> System.out.println(key + " -> " + value.toString()));

        System.out.println("===List 转  Map<String, List<Person>> 根据gender分组===");
        Map<String, List<Person>> groupByGender = personList.stream().collect(Collectors.groupingBy(Person::getGender));
        groupByGender.forEach((key, value) -> System.out.println(key + " -> " + value.toString()));

        System.out.println("===统计值===");
        //最大年龄
        Integer maxAge = personList.stream().mapToInt(Person::getAge).max().getAsInt();
        //最小年龄
        Integer minAge = personList.stream().mapToInt(Person::getAge).min().getAsInt();
        //年龄求和
        Integer sumAge = personList.stream().mapToInt(Person::getAge).sum();
        //平均年龄
        Double avgAge = personList.stream().mapToInt(Person::getAge).average().getAsDouble();
        System.out.println("maxAge = " + maxAge);
        System.out.println("minAge = " + minAge);
        System.out.println("sumAge = " + sumAge);
        System.out.println("avgAge = " + avgAge);

        System.out.println("===List<Integer> 的最大值===");
        System.out.println("最大的ID=" + Collections.max(ids));

        System.out.println("===SummaryStatistics统计===");
        IntSummaryStatistics iss = personList.stream().mapToInt(Person::getAge).summaryStatistics();
        System.out.println("max = " + iss.getMax());
        System.out.println("min = " + iss.getMin());
        System.out.println("sum = " + iss.getSum());
        System.out.println("avg = " + iss.getAverage());

        System.out.println("===分组统计 利用SummaryStatistics===");
        //求不同性别的平均年龄
        Map<String, IntSummaryStatistics> genderSummary =
                personList.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.summarizingInt(Person::getAge)));
        genderSummary.forEach((k, v) -> System.out.println(k + " -> 最大年龄=" + v.getMax() + ", 平均年龄=" + v.getAverage() + ", 人数=" + v.getCount()));

        System.out.println("===分组统计数量===");
        //求不同性别的人数
        Map<String, Long> genderSummary2 =
                personList.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));
        genderSummary2.forEach((k, v) -> System.out.println(k + " -> 人数=" + v));
        
        genderSummary2.forEach((sex,count)->{
        	switch(sex) {
        		case "男":
        			System.out.println("male's count:"+count);
        			break;
        		case "女":
        			System.out.println("male's count:"+count);
        			break;
        		default:
        			break;
        	}
        });

        System.out.println("===filter 筛选出成人男===");
        List<Person> mans = personList.stream().filter(person -> "男".equals(person.getGender()) && person.getAge() >= 18).collect(Collectors.toList());
        mans.forEach(person -> System.out.println(person.toString()));

        System.out.println("===Comparator 根据年龄升序排===");
        personList.sort(Comparator.comparing(Person::getAge));
        print();

        System.out.println("===Comparator 根据ID降序排===");
        personList.sort(Comparator.comparing(Person::getId).reversed());
        print();

        System.out.println("===Comparator 组合排序===");
        personList.sort(Comparator.comparing(Person::getGender).thenComparing(Person::getAge));
        print();

        System.out.println("goodbye");
    }

    private static void print(){
        personList.forEach(person -> System.out.println(person.toString()));
    }
}

