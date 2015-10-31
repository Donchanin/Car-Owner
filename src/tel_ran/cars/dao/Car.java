package tel_ran.cars.dao;
import javax.persistence.*;
@Entity
public class Car {
	@Id
	int number;
	@Override
	public String toString() {
		return "Car [number=" + number + ", vendor=" + vendor + ", year="
				+ year + ", volume=" + volume + "]";
	}
	String vendor;
	int year;
	int volume;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}

}
