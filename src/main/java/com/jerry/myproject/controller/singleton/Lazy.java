package com.jerry.myproject.controller.singleton;


import java.lang.reflect.Constructor;

/**
 * @author jerry
 */
public class Lazy {


    /**
     * 懒汉式 懒加载
     */


    //volatile
    private volatile static Lazy instance = null;

    private Lazy() {
    }


    /**
     * 双重检测锁模式（DCL懒汉式）
     *
     * 延迟初始化。和懒汉模式一致，只有在初次调用静态方法getSingleton，才会初始化signleton实例。
     * 性能优化。同步会造成性能下降，在同步前通过判读singleton是否初始化，减少不必要的同步开销。
     * 线程安全。同步创建Singleton对象，同时注意到静态变量singleton使用volatile修饰。
     * @return
     */
    public static Lazy getInstance() {
        if(null == instance){
            synchronized (Lazy.class){
                if (instance == null) {
                    instance = new Lazy();
                    /**
                     * new 不是一个原子操作
                     * 1、分配内存空间
                     * 2、执行构造方法，初始化对象
                     * 3、将对象指向前面分配的空间
                     *
                     * 在CPU可能执行的是132，需要给instance添加volatile
                     *
                     * synchronized保证原子性
                     * volatile保证可见性
                     */
                }
            }
        }

        return instance;
    }


    /**
     * 反射破坏单例  反射属于人为破坏
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Lazy lazy1 = Lazy.getInstance();

        Constructor<Lazy> declaredConstructor = Lazy.class.getDeclaredConstructor(null);
        //无视私有构造器
        declaredConstructor.setAccessible(true);
        //创建一个新的Lazy对象
        Lazy lazy2 = declaredConstructor.newInstance();

        //lazy1和lazy2不是同一个对象
        System.out.println(lazy1);
        System.out.println(lazy2);

        Lazy lazy3 = Lazy.getInstance();
        System.out.println(lazy3);

        //1==3!=2
    }



}
