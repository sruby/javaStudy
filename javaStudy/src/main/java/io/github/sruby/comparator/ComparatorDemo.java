package io.github.sruby.comparator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import io.github.sruby.utils.IteratorUtil;
import io.github.sruby.utils.SoutUtil;

/**
 * Comparator
 * @author liuwf on 2016年5月23日 上午1:07:36
 */
public class ComparatorDemo
{
	
	Person person0 = new Person("aruby", "20");
	Person person1 = new Person("sruby", "20");
	Person person2 = new Person("rubys", "21");
	/**
	 * ArrayList
	 * @author liuwf on 2016年5月23日 上午1:09:27
	 */
	@Test
	public void testArrayList()
	{
		/**
		 * list是有序输出
		 */
		List<Person> list = new ArrayList<>();
		list.add(person1);
		list.add(person2);
		list.add(person0);
		IteratorUtil.iterate(list);
		
	}
	
	/**
	 * TreeSet根据排序值去重
	 * @author liuwf on 2016年5月23日 上午1:30:47
	 */
	@Test
	public void testTreeSet()
	{
		/**
		 * 1.TreeSet中的对象必须实现Comparable接口
		 * 2.排序值是一样的对象会被过滤
		 * 3.因为需要排序,所以TreeSet存入的对象需要能够进行比较,如果不能比较则会出现类型转换异常
		 */
		Set<Person> set = new TreeSet<>();
		set.add(person1);
		set.add(person2);
		set.add(person0);
		IteratorUtil.iterate(set);
		SoutUtil.systou(set.size());
		
		Set<Integer> setInteger = new TreeSet<>();
		setInteger.add(1);
		setInteger.add(3);
		setInteger.add(2);
		IteratorUtil.iterate(setInteger);
		
		for (Integer integer : setInteger)
		{
			SoutUtil.systou(integer);
		}
	}
	
	/**
	 * HashSet根据hashcode和equals去重
	 * @author liuwf on 2016年5月23日 上午1:31:04
	 */
	@Test
	public void testHashSet()
	{
		/**
		 * TreeSet中的对象必须实现Comparable接口
		 * 排序值是一样的对象会被过滤
		 */
		Set<Person> set = new HashSet<>();
		set.add(person1);
		set.add(person2);
		set.add(person0);
		IteratorUtil.iterate(set);
		SoutUtil.systou(set.size());
	}
	
	public class Person implements Comparable
	{
		public Person(String name, String age)
		{
			super();
			this.name = name;
			this.age = age;
		}


		private String name,age;

		
		public String getName()
		{
			return name;
		}

		
		public void setName(String name)
		{
			this.name = name;
		}

		
		public String getAge()
		{
			return age;
		}

		
		public void setAge(String age)
		{
			this.age = age;
		}


		@Override
		public String toString()
		{
			return "Person [name=" + name + ", age=" + age + "]";
		}


//		@Override
//		public int compareTo(Object o)
//		{
//			return this.getAge().hashCode()+this.getName().hashCode();
//		}
		
		/**
		 * 如果每个对象都返回同样的排序值,这在TreeSet中只能放入一个对象
		 * @author liuwf on 2016年5月23日 上午1:26:18
		 * @param o
		 * @return
		 */
		@Override
		public int compareTo(Object o)
		{
			return 0;
		}


//		@Override
//		public int hashCode()
//		{
//			final int prime = 31;
//			int result = 1;
//			result = prime * result + getOuterType().hashCode();
//			result = prime * result + ((age == null) ? 0 : age.hashCode());
//			result = prime * result + ((name == null) ? 0 : name.hashCode());
//			return result;
//		}
		@Override
		public int hashCode()
		{
			return 1111;
		}


		@Override
		public boolean equals(Object obj)
		{
//			if (this == obj)
//				return true;
//			if (obj == null)
//				return false;
//			if (getClass() != obj.getClass())
//				return false;
//			Person other = (Person) obj;
//			if (!getOuterType().equals(other.getOuterType()))
//				return false;
//			if (age == null)
//			{
//				if (other.age != null)
//					return false;
//			}
//			else if (!age.equals(other.age))
//				return false;
//			if (name == null)
//			{
//				if (other.name != null)
//					return false;
//			}
//			else if (!name.equals(other.name))
//				return false;
			return true;
		}


		private ComparatorDemo getOuterType()
		{
			return ComparatorDemo.this;
		}
		
		
	}
}
