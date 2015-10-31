package tel_ran.cars.interfaces;

import tel_ran.cars.dao.Car;
import tel_ran.interfaces.OrmDatabase;

public interface ICarsRepository extends OrmDatabase {
void add(Car car);
}
