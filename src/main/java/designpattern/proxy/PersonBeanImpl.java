package designpattern.proxy;

/**
 * 顾客不能改变别人的名字
 * 顾客自己不能改变自己的rating
 *
 * @author wangdongxing
 * @since 2018-12-03 20:07
 */
public class PersonBeanImpl implements PersonBean {
    public PersonBeanImpl(String name) {
        this.name = name;
    }
    
    /**
     * 姓名
     */
    private String name;
    
    /**
     * 兴趣
     */
    private String interests;
    
    /**
     * 评分
     */
    private int rating;
    
    /**
     * 评分次数
     */
    private int rationCount = 0;
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void setInterests(String interests) {
        this.interests = interests;
    }
    
    @Override
    public void setHotOrNotRating(int rating) {
        this.rating += rating;
        rationCount++;
    }
    
    @Override
    public String toString() {
        return "PersonBeanImpl{" + "name='" + name + '\'' + ", interests='" + interests + '\'' + ", rating=" + rating
                + ", rationCount=" + rationCount + '}';
    }
}
