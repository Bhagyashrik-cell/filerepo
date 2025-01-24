package com.cjc.main.curd.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.curd.model.Person;
import com.cjc.main.curd.repository.HomeRepository;
import com.cjc.main.curd.serviceI.HomeServiceI;

import jakarta.transaction.Transactional;
@Service
public  class HomeServiceImpl implements HomeServiceI {
	@Autowired
	HomeRepository hr;

	@Override
	public void saveData(Person s) 
	{
		hr.save(s);
		
	}

//	@Override
//	public List<Person> getAllData() {
//		List<Person> list=(List<Person>) hr.findAll();
//		
//		return list;
//	}

//	
	 public  Person getAllData(String un,String ps) {
		
		
		return hr.findPersonByUnameAndPassword(un, ps);
	}

	
@Override
	public Person editDataByUid(int uid) {
		
		return hr.findByUid(uid);
	}


@Override
public void deletData(int uid) {
	hr.deleteByUid(uid);
	
}

@Override
public List<Person> getAllPersonData() {
	
	return hr.findAllPerson();
}

@Override
public void updatePerson(int uid, String name, String uname, String password, String mobileno) {
	
	 hr.updatePersonDetails(uid, name, uname, password, mobileno);
}

//	@Override
//	public Person findAllByUnameAndPassword(String un, String ps) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}

	
