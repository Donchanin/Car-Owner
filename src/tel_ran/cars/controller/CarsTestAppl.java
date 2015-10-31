package tel_ran.cars.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tel_ran.cars.dao.Car;
import tel_ran.cars.interfaces.ICarsRepository;

public class CarsTestAppl {

	public static void main(String[] args) {
		AbstractApplicationContext ctx=new FileSystemXmlApplicationContext("beans.xml");
		ICarsRepository repository=(ICarsRepository) ctx.getBean("repository");
		Car car=new Car();
		car.setNumber(1235);
		car.setVendor("Honda");
		car.setVolume(3);
		car.setYear(2016);
		repository.add(car);
		String []res=repository.runRequest("SELECT c.number,c.vendor FROM Car c");
		displayRes(res);
	}

	private static void displayRes(String[] res) {
		for(String str:res)
			System.out.println(str);
		
	}

}
