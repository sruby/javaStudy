package io.github.sruby.designpattern.factory;


public class Client
{
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, CloneNotSupportedException
	{
		HumanFactory humanFactory = new HumanFactory();
		
		AbstractHuman yellowHuman = humanFactory.createHuman(new YellowHuman());
		yellowHuman.getColor();
		yellowHuman.speak();
		yellowHuman.setName("xiaoming");
		
		AbstractHuman blackHuman = humanFactory.createHuman(new BlackHuman());
		blackHuman.getColor();
		blackHuman.speak();
		
		AbstractHuman yellowHuman2 = humanFactory.createHuman(new YellowHuman());
		System.out.println(yellowHuman2.getName());
	}
}
