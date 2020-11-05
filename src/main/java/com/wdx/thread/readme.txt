线程笔记：

停止线程的策略：用 isInterrupted() 方法判断线程是否打断，
	如果true就抛出 isInterrupted() 异常来停止进程。详见test4

线程锁的是对象：
	例test6包中，myMethod方法不加synchronized时，输出
	begin thread name: A
    begin thread name: B
    end
    end
    加上synchronized时，输出
    begin thread name: A
    end
    begin thread name: B
    end

虽然线程A先持有object对象的锁，但线程B完全可以异步调用非synchronized类型的方法。详见test7

脏读一定会出现操作实例变量的情况下，这就是不同线程“争抢”实例变量的结果。

当一个线程得到一个对象锁后，再次请求此对象锁时是可以再次得到该对象的锁的。
	这也证明在一个synchronized方法/块的内部调用本类的其他synchronized方法/块时，是永远可以得到锁的。

出现异常，锁自动释放。

不在synchronized块中就是异步执行，在synchronized块中就是同步执行。一半异步，一半同步；详见test8

当一个线程访问object的一个synchronized(this)同步代码块时，其他线程对同一个object中所有其他
	synchronized(this)同步代码块的访问将被阻塞，这说明synchronized使用的“对象监视器”是一个。

使用“synchronized(非this对象x)同步代码块”格式进行同步操作时，对象监视器必须是同一个对象。
	如果不是同一个对象监视器，运行的结果就是异步调用了，就会交叉运行。

关键字synchronized还可以应用在static静态方法上，如果这么写，就是对当前的*.java文件对应的Class类进行持锁，
	对象锁 和 Class锁 不是同一类锁，所以是异步执行。

synchronized(string)同步块与String联合使用，若参数string相同时，则两个线程会持有相同的锁，
	因此大多数情况下，同步synchronized代码块都不使用String作为锁对象。

当两个线程持有一个对象锁时，即使对象的属性被改变了，运行依然是同步的。

volatile:
	作用：强制从公共堆栈中取得变量的值，而不是从线程私有数据栈中取得变量的值。
	使用场合：在多个线程中可以感知实例变量被更改了，并且可以获得最新的值使用，
		也就是用多线程读取共享变量时可以获得最新值使用。
	与synchronized比较：
		.volatile是线程同步的轻量级实现，性能肯定比synchronized要好，且volatile只能修饰变量，
			而synchronized可修饰方法，以及代码块。随着JKD新版本发布，
			synchronized在执行效率上得到很大提升，开发中使用synchronized的比率还是比较大的。
		.多线程访问volatile不会发生阻塞，而synchronized会出现阻塞。
		.volatile能保证数据的可见性，但不能保证原子性；而synchronized可以保证原子性，也可以间接保证可见性，
			因为它会将私有内存和公有内存中的数据做同步。
		.再次重申下，volatile解决的是变量在多个线程之间的可见性；
			而synchronized解决的是多个线程之间访问资源的同步性。

线程安全包含原子性和可见性两个方面，Java的同步机制都是围绕这两个方面来确保线程安全的。







