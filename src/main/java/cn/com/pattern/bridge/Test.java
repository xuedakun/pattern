package cn.com.pattern.bridge;
/**
 * 桥接模式
 * @author xuekun
 *
 */

abstract class AbstractCar {
	void run() {
	};
}

abstract class AbstractRoad {
	AbstractCar aCar;
	
	void run() {
	};
}
abstract class People {
	AbstractRoad road;

	void run() {
	};
}

class Man extends People {
	void run() {
		super.run();
		System.out.print("男人开着");
		road.run();

	};
}

class WoMan extends People {
	void run() {
		super.run();
		System.out.print("女人开着");
		road.run();

	};
}


class Street extends AbstractRoad {
	@Override
	void run() {
		// TODO Auto-generated method stub
		super.run();
		aCar.run();
		System.out.println("在市区街道行驶");
	}
}

class SpeedWay extends AbstractRoad {
	@Override
	void run() {
		// TODO Auto-generated method stub
		super.run();
		aCar.run();
		System.out.println("在高速公路行驶");
	}
}

class Car extends AbstractCar {
	@Override
	void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.print("小汽车");
	}
}

class Bus extends AbstractCar {
	@Override
	void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.print("公交车");
	}
}

public class Test {
	public static void main(String[] args) {
		People woMan = new WoMan();
		AbstractRoad speedWay = new SpeedWay();
		speedWay.aCar = new Car();
		woMan.road = speedWay;
		woMan.run();

		People man = new Man();
		AbstractRoad street = new Street();
		street.aCar = new Bus();
		man.road = street;
		man.run();
	}
}
