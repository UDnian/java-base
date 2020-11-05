package designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义：有时又叫作部分-整体模式，它是一种将对象组合成树状的层次结构的模式，用来表示“部分-整体”的关系，使用户对单个对象和组合对象具有一致的访问性。
 * <p>
 * 模式的结构
 * 组合模式包含以下主要角色。
 * 抽象构件（Component）角色：它的主要作用是为树叶构件和树枝构件声明公共接口，并实现它们的默认行为。在透明式的组合模式中抽象构件还声明访问和管理子类的接口；在安全式的组合模式中不声明访问和管理子类的接口，管理工作由树枝构件完成。
 * 树叶构件（Leaf）角色：是组合中的叶节点对象，它没有子节点，用于实现抽象构件角色中 声明的公共接口。
 * 树枝构件（Composite）角色：是组合中的分支节点对象，它有子节点。它实现了抽象构件角色中声明的接口，它的主要作用是存储和管理子部件，通常包含 Add()、Remove()、GetChild() 等方法。
 *
 * @author wangdongxing
 * @since 2020/10/12 3:05 下午
 */
public class CompositeMain {
    public static void main(String[] args) {
        Component c0 = new Composite();
        Component c1 = new Composite();
        Component leaf1 = new Leaf("1");
        Component leaf2 = new Leaf("2");
        Component leaf3 = new Leaf("3");
        c0.add(leaf1);
        c0.add(c1);
        c1.add(leaf2);
        c1.add(leaf3);
        c0.operation();
    }
}

interface Component {
    void add(Component component);
    
    void remove(Component component);
    
    Component getChild(int i);
    
    void operation();
}

//树叶构件
class Leaf implements Component {
    private String name;
    
    Leaf(String name) {
        this.name = name;
    }
    
    @Override
    public void add(Component c) {
    }
    
    @Override
    public void remove(Component c) {
    }
    
    @Override
    public Component getChild(int i) {
        return null;
    }
    
    @Override
    public void operation() {
        System.out.println("树叶" + name + "：被访问！");
    }
}

//树枝构件
class Composite implements Component {
    private List<Component> children = new ArrayList<>();
    
    @Override
    public void add(Component c) {
        children.add(c);
    }
    
    @Override
    public void remove(Component c) {
        children.remove(c);
    }
    
    @Override
    public Component getChild(int i) {
        return children.get(i);
    }
    
    @Override
    public void operation() {
        for (Object obj : children) {
            ((Component) obj).operation();
        }
    }
}