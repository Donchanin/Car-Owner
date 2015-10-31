package tel_ran.cars.repository;

import javax.persistence.*;

import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import tel_ran.cars.dao.Car;
import tel_ran.cars.interfaces.ICarsRepository;
import tel_ran.interfaces.OrmDatabase;

public class CarsRepository implements ICarsRepository {
@PersistenceContext(unitName="springHibernate")
EntityManager em;
	
@Override
	public String[] runRequest(String jpqlStr) {
		String res[];
		if(isSingleRequest(jpqlStr))
			res=runSingleRequest(jpqlStr);
		else
			res=runMultipleRequest(jpqlStr);
		return res;
	}
	
	private String[] runMultipleRequest(String jpqlStr) {
		Query query=em.createQuery(jpqlStr);
		List<Object[]> res=query.getResultList();
		return arrayObjectsToArrayStrings(res);
	}
	private String[] arrayObjectsToArrayStrings(List<Object[]> list) {
		String [] res=new String[list.size()];
		int iRes=0;
		for(Object[] arObj:list){
			String str=arObj[0].toString();
			for(int i=1;i<arObj.length;i++){
				str=str+" "+arObj[i].toString();
			}
			res[iRes++]=str;
		}
		
		return res;
	}
	
	private String[] runSingleRequest(String jpqlStr) {
		Query query=em.createQuery(jpqlStr);
		List<Object> res=query.getResultList();
		return objectsToArrayString(res);
	}
	private String[] objectsToArrayString(List<Object> list) {
		String [] res=new String[list.size()];
		int iRes=0;
		for(Object obj:list)
			res[iRes++]=obj.toString();
		return res;
	}
	
	private boolean isSingleRequest(String jpqlStr) {
		int indFrom=jpqlStr.indexOf("FROM");
		String upFrom=jpqlStr.substring(0, indFrom);
		String [] tokens=upFrom.split(",");
		return tokens.length<=1;
	}
	
	@Override
	@Transactional(readOnly=false)
	public void add(Car car) {
		if(em.find(Car.class, car.getNumber())==null)
			em.persist(car);
		
	}

}
