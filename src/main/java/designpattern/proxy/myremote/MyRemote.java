package designpattern.proxy.myremote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程服务接口
 *
 * @author wangdongxing
 * @since 2018-12-03 19:44
 */
public interface MyRemote extends Remote {

    String sayHello() throws RemoteException;
}
