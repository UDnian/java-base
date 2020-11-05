package designpattern.builder;

/**
 * 产品
 *
 * @author wangdongxing
 * @since 2020/9/27 3:30 下午
 */
public class Product {
    private String buildA;
    
    private String buildB;
    
    private String buildC;
    
    private String buildD;
    
    public String getBuildA() {
        return buildA;
    }
    
    public void setBuildA(String buildA) {
        this.buildA = buildA;
    }
    
    public String getBuildB() {
        return buildB;
    }
    
    public void setBuildB(String buildB) {
        this.buildB = buildB;
    }
    
    public String getBuildC() {
        return buildC;
    }
    
    public void setBuildC(String buildC) {
        this.buildC = buildC;
    }
    
    public String getBuildD() {
        return buildD;
    }
    
    public void setBuildD(String buildD) {
        this.buildD = buildD;
    }
    
    @Override
    public String toString() {
        return "套餐组成{" + "buildA='" + buildA + '\'' + ", buildB='" + buildB + '\'' + ", buildC='" + buildC + '\''
                + ", buildD='" + buildD + '\'' + '}';
    }
}
