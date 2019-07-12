package com.example.testpractice.asm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class HandleGFFunction {
    class GF {
        GF(){
        }
        void thinking() {
            System.out.println("I am a grand father.");
        }
    }
    class FA extends GF {
        void thinking() {
            System.out.println("I am a father.");
        }
    }
    class SN extends FA {
        void thinking() {
            //请在Thining中填入适当代码，不能修改其他地方代码
            //实现调用祖父类的thinking方法
            //方法一
            new GF().thinking();

            System.out.println("I am a son.");
            //使用MethodType构造出要调用方法的返回类型，JDK1.8 以后不能这么使用了
            MethodType methodType = MethodType.methodType(void.class);
            try {
                //找到祖父类的构造函数
                MethodHandle inithandle = MethodHandles.lookup().findConstructor(GF.class, methodType);
                //获取祖父类实例对象
                Object o = inithandle.invoke();
                //找到祖父类里被覆写的方法并把该方法绑定到祖父类实例上
                MethodHandle handle = MethodHandles.lookup() .findVirtual(GF.class, "thinking", methodType).bindTo(o);
                //调用祖父类里被父类覆写的方法
                handle.invoke();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        (new HandleGFFunction().new SN()).thinking();
        //方法二
        //使用MethodType构造出要调用方法的返回类型
        MethodType methodType = MethodType.methodType(void.class);
        try {
            //找到祖父类的构造函数
            MethodHandle constructor = MethodHandles.lookup().findConstructor(GF.class, methodType);
            //获取父类的实例对象
            Object obj = constructor.invoke();
            //找到祖父类里被覆写的方法，并把该方法绑定到祖父类上
            MethodHandle thinking = MethodHandles.lookup().findVirtual(GF.class, "thinking", methodType);
            MethodHandle methodHandle = thinking.bindTo(obj);
            methodHandle.invoke();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
