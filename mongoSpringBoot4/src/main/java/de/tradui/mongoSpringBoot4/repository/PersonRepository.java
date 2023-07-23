/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.tradui.mongoSpringBoot4.repository;

import de.tradui.mongoSpringBoot4.model.Person;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


/**
 *
 * @author MM
 */
public interface PersonRepository extends MongoRepository<Person, Long>{
    //find,findAll,insert,insertAll
    public List<Person> findByName(String name);
    @Query("{ 'name': ?0, 'city': ?1}")
     public List<Person> findByNameAndCity(String name, String city);
    @Query("{$or: [{ 'name': ?0},{'city': ?1}]}")
    public List<Person> findByNameOrCity(String name, String city);
    @Query("{'id': ?0}")
    public List<Person> findByIds(String id);
}
