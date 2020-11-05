package designpattern.builder;

/**
 * 具体建造者（服务器）
 *
 * @author wangdongxing
 * @since 2020/9/27 3:32 下午
 */
public class WaiterBuilder extends Builder {
    
    private Product product;
    
    public WaiterBuilder() {
        this.product = new Product();
    }
    
    @Override
    Builder buildA(String mes) {
        product.setBuildA(mes);
        return this;
    }
    
    @Override
    Builder buildB(String mes) {
        product.setBuildB(mes);
        return this;
    }
    
    @Override
    Builder buildC(String mes) {
        product.setBuildC(mes);
        return this;
    }
    
    @Override
    Builder buildD(String mes) {
        product.setBuildD(mes);
        return this;
    }
    
    @Override
    Product build() {
        return product;
    }
}
