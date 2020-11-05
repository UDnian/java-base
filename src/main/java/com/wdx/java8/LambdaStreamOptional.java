package com.wdx.java8;

import com.wdx.java8.model.Apple;
import com.wdx.java8.model.Car;
import com.wdx.java8.model.Dish;
import com.wdx.java8.model.Insurance;
import com.wdx.java8.model.Person;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 行为参数化（函数式编程）：把方法（你的代码）作为参数传递给另一个方法的能力。
 * 接口可以包含实现类没有提供实现的方法签名!缺失的方法主体随接口提供了(因此就有了默认实现)，而不是由实现类提供。
 * Lambda表􏱋式理解为简洁地表示可传递的匿名函数的一种方式:它没有名称，但它有参数列表、函数主体、返回类型，可能还有一个可以􏱠出的异常列表。
 * Lambda表达式由参数、􏿙箭头和主体组成"() -> {}"，() 相当于参数列表，{}相当于方法体
 *
 * @author wangdongxing
 * @since 2019-02-19 08:37
 */
public class LambdaStreamOptional {
    
    public static void main(String[] args) {
        /* 匿名类写法 */
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World 1");
            }
        };
        
        /* Lambda写法 */
        Runnable r2 = () -> System.out.println("Hello World 2");
        
        // java.util.function.Predicate<T>接口定义了一个名叫test的抽象方法，它接受泛型T对象，并返回一个boolean
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        
        // java.util.function.Consumer<T>定义了一个名叫accept的抽象方法，它接受泛型T的对象，没有返回(void)。你如果需要访问类型T的对象，并对其执行某些操作，就可以使用 这个接口
        Consumer<Integer> consumer = i -> System.out.println(i);
        
        // java.util.function.Function<T, R>接口定义了一个叫作apply的方法，它接受一个泛型T的对象，并返回一个泛型R的对象。如果你需要定义一个Lambda
        // ，将输入对象的信息映射到输出，就可以使用这个接口(比如提取苹果的重量，或把字符串映射为它的长度)
        List<Integer> l = map(Arrays.asList("lambdas", "in", "action"), (String s) -> s.length());
        
        // 针对专门的输入参数类型的函数式接口的名称都要加上对应的原始类型前􏰘，比如DoublePredicate、IntConsumer、LongBinaryOperator、IntFunction等。
        // Function接口还有针对输出参数类型的变种:ToIntFunction<T>、IntToDoubleFunction等。

        /*
        使用案例        Lambda例子                                       对应的函数式接口
        布尔表达式       (List<String> list) -> list.isEmpty()           Predicate<List<String>>
        创建对象        () -> new Apple(10)                              Supplier<Apple>
        消费一个对象     (Apple a) -> System.out.println(a.getWeight())   Consumer<Apple>
        从一个对象中 选择/提取    (String s) -> s.length()                 Function<String, Integer>或 ToIntFunction<String>
        合并两个值       (int a, int b) -> a * b                         IntBinaryOperator
        比较两个对象     (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight())
        Comparator<Apple>或BiFunction<Apple, Apple,Integer>或ToIntBiFunction<Apple, Apple>
        */
        
        /* 方法引用 */
        List<Apple> appleList = Arrays.asList(new Apple("red", 2), new Apple("green", 1));
        // 没使用方法引用前
        appleList.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        // 使用方法引用
        appleList.sort(Comparator.comparing(Apple::getWeight));

        /*
        Lambda                                      等效的方法引用
        (Apple a) -> a.getWeight()                  Apple::getWeight
        () -> Thread.currentThread().dumpStack()    Thread.currentThread()::dumpStack
        (str, i) -> str.substring(i)                String::substring
        (String s) -> System.out.println(s)         System.out::println
        */
        
        /* 复合Lambda表达式的有用方法 */
        // 逆序
        appleList.sort(Comparator.comparing(Apple::getWeight).reversed());
        // 比较器链 两个苹果一样重时，用颜色排序
        appleList.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
        // 谓词复合 谓词接口包括三个方法:negate(非)、and和or
        // 要么是重(150克以上)的红苹果，要么是绿苹果
        Predicate<Apple> redApple = a -> "red".equals(a.getColor());
        Predicate<Apple> redAndHeavyAppleOrGreen = redApple.and(a -> a.getWeight() > 150)
                .or(a -> "green".equals(a.getColor()));
        // 函数复合
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        // 返回4
        int result = h.apply(1);
        
        /* 流stream */
        // 总而言之，流的使用一般包括三件事:
        //􏱟 一个数据源(如集合)来执行一个查询;
        //􏱟 一个中间操作链，形成一条流的流水线;(filter,map,limit,sorted,distinct)
        //􏱟 一个终端操作，执行流水线，并能生成结果。(forEach,count,collect)
        
        List<Dish> menu = Arrays.asList(new Dish("fish", 200, 1), new Dish("apple", 10, 2));
        // 选出400卡路里以下的菜肴-按照卡路里排序-提取菜肴名称-将所有名称保存在list中
        List<String> lowCaloricDishesName = menu.stream().filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName).collect(Collectors.toList());
        
        List<String> titleList = Arrays.asList("Java8", "In", "Action");
        titleList.stream().forEach(System.out::println);
        
        // 流的扁平化
        // 给定单词列表 ["Hello","World"]，你想要返回列表["H","e","l", "o","W","r","d"]
        // 使用flatMap方法的效果是，各个数组并不是分别映射成一个流，而是映射成流的内容。所有使用map(Arrays::stream)时生成的单个流都被合并起来，即扁平化为一个流。
        List<String> words = Arrays.asList("Hello", "World");
        // 错误
        words.stream().map(word -> word.split("")).map(Arrays::stream).distinct().collect(Collectors.toList());
        // 正确
        words.stream().map(w -> w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        
        // 查找和匹配 (短路求值：有些􏰮作不需要处理整个流就能得到结果)
        // Stream API通过allMatch、anyMatch、noneMatch、findFirst和findAny方法提供了这样的工具
        
        // 归约 reduce
        // reduce接受两个参数:
        // 􏱟 一个初始值，这里是0;
        // 􏱟 一个BinaryOperator<T>来将两个元素结合起来产生一个新值，这里我们用的是lambda (a, b) -> a + b。
        List<Integer> numbers = Arrays.asList(1, 2, 4);
        // 元素求和
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        // 最大值
        int max = numbers.stream().reduce(0, Integer::max);
        
        // 数值流 IntStream、DoubleStream和 LongStream
        int calories = menu.stream().mapToInt(Dish::getCalories).sum();
        // 从1到100的偶数
        IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());
        
        // 构建流
        // 由值创建流
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        int[] numberArray = { 2, 3, 5, 7, 11, 13 };
        // 由数组创建流
        int sum2 = Arrays.stream(numberArray).sum();
        // 由文件生成流
        try {
            Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 由函数生成流：创建无限流 Stream.iterate和Stream.generate
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
        
        // 流收集数据
        // 所有收集器，都是一个可以用reducing工厂方法定义的归约过程 的特殊情况而已。Collectors.reducing工厂方法是所有这些特殊情况的一般化。
        int totalCalories = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
        // 也可以
        int totalCalories2 = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        // 也可以
        int totalCalories1 = menu.stream().map(Dish::getCalories).reduce(0, (i, j) -> i + j);
        // reducing 它需要三个参数:
        //􏱟 第一个参数是归约操作的起始值，也是流中没有元素时的返回值，所以很显然对于数值和而言0是一个合适的值。
        //􏱟 第二个参数就是使用的函数，将菜肴转换成一个表示其所含热量的int。
        //􏱟 第三个参数是一个BinaryOperator，将两个项目累积成一个同类型的值。这里它就是对两个int求和。
        // 归约操作的工作原理：利用累积函数，把一个初始化为起始值的累加器，和把转换函数应用到流中每个元素上得到的结果不断迭代合并起来。
        
        // 分组 (Collectors.groupingBy)
        Map<Integer, List<Dish>> dishesByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        Map<Integer, List<String>> typeToNameListMap = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(Dish::getName, Collectors.toList())));
        Map<String, Integer> nameCaloriesMap = menu.stream()
                .collect(Collectors.toMap(Dish::getName, Dish::getCalories));
        // 多级分组 (Dish::getType为一级分类，dish.getCalories为二级分类)
        Map<Integer, Map<Integer, List<Dish>>> dishesByTypeCaloricLevel = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return 1;
                    } else if (dish.getCalories() <= 700) {
                        return 2;
                    } else {
                        return 3;
                    }
                })));
        // 按子组收集数据
        // 菜肴每种类型的个数
        Map<Integer, Long> typesCount = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        // 以Dish的类型作为键，以包装了该类型中热量最高的Dish 的Optional<Dish>作为值
        Map<Integer, Optional<Dish>> mostCaloricByType = menu.stream().collect(
                Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
        // 分区 分区是分组的特殊情况:由一个谓词(返回一个布尔值的函数)作为分类函数，它称分区函数。分为两组——true是一组，false是一组。
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream()
                .collect(Collectors.partitioningBy(Dish::getIsVegetarian));
        
        // 调试debug peek方法
        // peek的设计初􏸍就是在流的每个元素恢复运行之前，插入执行一个动作。
        // 但是它不像forEach那样恢复整个流的运行，而是在一个元素上完成操作之后，它只会将操作顺承到流水线中的下一个操作。
        List<Integer> result3 = numbers.stream().peek(x -> System.out.println("from stream: " + x)).map(x -> x + 17)
                .collect(Collectors.toList());
        
        /* Optional取代null */
        // 空的Optional
        Optional<Car> optCar = Optional.empty();
        // 非空值创建Optional
        Car car = new Car();
        Optional<Car> optCar1 = Optional.of(car);
        // 可接受null的Optional
        Optional<Car> optionalCar = Optional.ofNullable(car);
        
        // 使用map从Optional对象中提取和转换值
        Insurance insurance = new Insurance();
        Optional<Insurance> insuranceOptional = Optional.ofNullable(insurance);
        Optional<String> nameOptional = insuranceOptional.map(Insurance::getName);
        // 使用flatMap链接Optional对象
        Person person = new Person();
        Optional<Person> optPerson = Optional.of(person);
        String name = optPerson.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName)
                .orElse("Unknown");
        
        // 默认行为及解引用Optional对象
        // 􏱟 get()是这些方法中最简单但又最不安全的方法。如果变量存在，它直接返回􏷽装的变量 值，否则就􏱠出一个NoSuchElementException异常。
        // 􏱟 orElse(T other)是我们在代码清单10-5中使用的方法，正如之前提到的，它允许你在 Optional对象不包含值时提供一个默认值。
        // 􏱟 ifPresent(Consumer<? super T>)让你能在变量值存在时执行一个作为参数传入的方法，否则就不进行任何操作。
        // 􏱟 isPresent()如果Optional对象包含值，该方法就返回true。
        
        // 使用filter剔除特定的值
        insuranceOptional.filter(insurance0 -> "CambridgeInsurance".equals(insurance0.getName()))
                .ifPresent(x -> System.out.println("ok"));
    }
    
    private static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }
    
}
