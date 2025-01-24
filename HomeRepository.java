package com.cjc.main.curd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.cjc.main.curd.model.Person;

import jakarta.transaction.Transactional;
@Repository
public interface HomeRepository extends CrudRepository<Person, Integer> 
{
	public Person findAllByUnameAndPassword(String un,String ps);
	
	public Person findByUid(int uid);
	 @Query(" FROM Person ")
	    List<Person> findAllPerson();
	  @Query(" FROM Person  WHERE uname =:uname AND password =:password")
	    Person findPersonByUnameAndPassword(String uname, String password);
	  @Modifying
	    @Transactional
	    @Query("DELETE FROM Person  WHERE uid = :id" )
	    void deleteByUid( int id);
	  @Modifying
	    @Transactional
	    @Query("UPDATE Person  SET name = :name, uname = :uname, password = :password, mobileno = :mobileno WHERE uid = :uid")
	    int updatePersonDetails(int uid, String name, String uname, String password, String mobileno);
}
