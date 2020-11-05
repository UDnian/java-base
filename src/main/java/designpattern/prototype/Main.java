package designpattern.prototype;

/**
 * 定义：用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。
 * 浅克隆：创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址。
 * 深克隆：创建一个新对象，属性中引用的其他对象也会被克隆，不再指向原有对象地址。
 * 优点：
 * Java 自带的原型模式基于内存二进制流的复制，在性能上比直接 new 一个对象更加优良。
 * 可以使用深克隆方式保存对象的状态，使用原型模式将对象复制一份，并将其状态保存起来，简化了创建对象的过程，以便在需要的时候使用（例如恢复到历史某一状态），可辅助实现撤销操作。
 * 缺点：
 * 需要为每一个类都配置一个 clone 方法
 * clone 方法位于类的内部，当对已有类进行改造的时候，需要修改代码，违背了开闭原则。
 * 当实现深克隆时，需要编写较为复杂的代码，而且当对象之间存在多重嵌套引用时，为了实现深克隆，每一层对象对应的类都必须支持深克隆，实现起来会比较麻烦。因此，深克隆、浅克隆需要运用得当。
 *
 * @author wangdongxing
 * @since 2020/9/26 6:15 下午
 */
public class Main {
    
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person("wang", 30, new Address(12, "回龙观"));
        Person person1 = (Person) person.clone();
        System.out.println(person == person1);
        System.out.println(person.address == person1.address);
        System.out.println(person);
        System.out.println(person1);
    }
}

class Person implements Cloneable {
    
    public String name;
    
    public Integer age;
    
    public Address address;
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 浅克隆
        // return super.clone();
        /* 深克隆 */
        Person person = (Person) super.clone();
        person.address = (Address) address.clone();
        return person;
    }
    
    Person(String name, Integer age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + ", address=" + address + '}';
    }
}

class Address implements Cloneable {
    private Integer cityId;
    
    private String street;
    
    Address(Integer cityId, String street) {
        this.cityId = cityId;
        this.street = street;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    @Override
    public String toString() {
        return "Address{" + "cityId=" + cityId + ", street='" + street + '\'' + '}';
    }
}
