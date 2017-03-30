package io.github.sruby.innerclass;

import java.util.Date;

/**
 * 内部类
 * @author sruby on 2016年8月15日 上午12:52:51
 */
public class InnerClassTest {
	//匿名内部类使用实例变量不用使用final修饰
	String a ;
	
	/**
	 * 匿名内部类使用声明的变量需要使用final修饰
	 * @author sruby on 2016年8月15日 上午12:58:16
	 * @param name
	 * @param age
	 * @param date
	 */
    public void display(final String name,String age,final Date date){
    	/**
    	 * 匿名内部类中使用局部变量需要final修饰并初始化
    	 * 原因：局部变量在display执行完毕后就会被回收，
    	 * 而这时如果内部类使用被销毁的局部变量(内部类的对象是可以作为返回值返回的)，就会出问题。
    	 * 声明为final后，就不再是变量，而是一个常量，编译器会在编译时期用常量替换内部类中的相应变量，
    	 * 则不会存在访问不存在的变量的问题。
    	 * http://stackoverflow.com/questions/1299837/cannot-refer-to-a-non-final-variable-inside-an-inner-class-defined-in-a-differen
    	 * TODO BYSRUBY 为什么常量是在编译时期进行替换的
    	 */
    	final String b = null;
        class InnerClass{
            void display(){
                System.out.println(name+date+a+b);
            }
        }
        
        InnerClass innerClass = new InnerClass();
        innerClass.display();
    }
    
    public static void main(String[] args)
	{
    	InnerClassTest innerClassTest = new InnerClassTest();
    	innerClassTest.display("test", "22",new Date());
	}
}