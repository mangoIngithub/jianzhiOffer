package design_pattern;
/**单例模式：任何情况都只有一个实例        推荐使用4、6  注意线程安全、加载时间、序列化
 * 应用场景：  
 *  1.外部资源：每台计算机有若干个打印机，但只能有一个PrinterSpooler，以避免两个打印作业同时输出到打印机。
 *    内部资源：大多数软件都有一个（或多个）属性文件存放系统配置，这样的系统应该有一个对象管理这些属性文件 
    2. Windows的Task Manager（任务管理器）就是很典型的单例模式
    3. windows的Recycle Bin（回收站）也是典型的单例应用。在整个系统运行过程中，回收站一直维护着仅有的一个实例。 
    4. 网站的计数器，一般也是采用单例模式实现，否则难以同步。 
    5. 应用程序的日志应用，一般都何用单例模式实现，这一般是由于共享的日志文件一直处于打开状态，
                   因为只能有一个实例去操作，否则内容不好追加。 
    6. Web应用的配置对象的读取，一般也应用单例模式，这个是由于配置文件是共享的资源。 
    7. 数据库连接池的设计一般也是采用单例模式，因为数据库连接是一种数据库资源。数据库软件系统中使用数据库连接池，  主要是节省打开
                 或者关闭数据库连接所引起的效率损耗，这种效率上的损耗还是非常昂贵的，因为何用单例模式来维护，就可以大大降低这种损耗。 
    8. 多线程的线程池的设计一般也是采用单例模式，这是由于线程池要方便对池中的线程进行控制。 
    9. 操作系统的文件系统，也是大的单例模式实现的具体例子，一个操作系统只能有一个文件系统。 
    10. HttpApplication 也是单例的典型应用。熟悉ASP.Net(IIS)的整个请求生命周期的人应该知道HttpApplication也是单例模式，
                    所有的HttpModule都共享一个HttpApplication实例. 
 * @author lzw
 * @date 2018年1月2日
 * @version version1.0
 */
public class Singleton {
	private Singleton() {
		
	}
//1.饿汉模式(立即加载) 优点：线程安全，缺点：类加载就初始化了，实例存在整个程序周期，降低内存使用率
	/*
	 private static Singleton instance=new Singleton();
	public static Singleton getInstance() {
		return instance;
	}
	*/
	
//2.懒汉模式(延迟加载) 缺点：线程不安全
/*	
	private static Singleton instance=null;
	public static Singleton getInstance() {
		if(instance==null) {
			instance=new Singleton();
		}
		return instance;
	}
	*/
	
//3.懒汉模式（synchronized 线程安全） 缺点:整个方法同步 效率很低
	
/*	private static Singleton instance=null;
	public static synchronized Singleton getInstance() {
		if(instance==null) {
			instance=new Singleton();
		}
		return instance;
	}
	*/
	
 //4.双重校验锁    在if里面加同步代码，并且在同步代码里再判断然后初始化   
/*            但是由于指令重排优化的存在，导致初始化Singleton和将对象地址赋给instance字段的顺序是不确定的。
	  在某个线程创建单例对象时，在构造方法被调用之前，就为该对象分配了内存空间并将对象的字段设置为默认值。
	   此时就可以将分配的内存地址赋值给instance字段了，然而该对象可能还没有初始化。
	  若紧接着另外一个线程来调用getInstance，取到的就是状态不正确的对象，程序就会出错。
            并且为了避免指令，要使用jdk1.5之后的关键字volatile,禁止指令重排*/
/*
	private static volatile Singleton instance=null;
	public static Singleton getInstance() {
		if(instance==null) {
			synchronized(Singleton.class) {
				if(instance==null) {
					instance=new Singleton();
				}
			}
		}
		return instance;
	}
	*/
//5.静态内部类  饿汉模式，利用类加载器在类加载时就初始化实例，导致内存浪费。
//	静态内部类可以在被显示调用时才加载，并且只加载一次。因此是延迟加载且线程安全
/*	
	private static class SingletonHolder{
		private static Singleton instance=new Singleton();
	}
	public static Singleton getInstance() {
		return SingletonHolder.instance;
	}
	*/

//6.静态内部类完整版   解决序列化反序列化导致多例问题
/*我们知道java 对象的序列化操作是实现Serializable接口，我们就可以把它往内存地写再从内存里读出而"组装"成一个跟原来一模一样的对象.
 *  但是当我们遇到单例序列化的时候，就出现问题了。当从内存读出而组装的对象破坏了单例的规则，会创建新的对象。
 *  单例要求JVM只有一个对象，而通过反序化时就会产生一个克隆的对象，这就打破了单例的规则。
 * 
 * 当该类implements Serializable，在该类加一段readResovle()代码
 */
/*	
	private static class SingletonHolder{
		private static Singleton instance=new Singleton();
	}
	public static Singleton getInstance() {
		return SingletonHolder.instance;
	}
	private Object readResolve() {
		return SingletonHolder.instance;
	}
	*/

//7.枚举类   以上除了序列化问题，还有反射可以强行调用私有构造器创建实例。
// 枚举可以解决线程安全，反射，并且自动序列化机制，防止反序列化的时候创建新的对象。
/*	
	public enum Singleton1{
		Instance;
		public void whateverMethod() {  
	    }  
	}
	*/
}
