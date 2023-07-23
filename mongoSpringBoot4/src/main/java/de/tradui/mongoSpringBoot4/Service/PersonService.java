/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.tradui.mongoSpringBoot4.Service;

import de.tradui.mongoSpringBoot4.model.Person;
import de.tradui.mongoSpringBoot4.repository.PersonRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MM
 */
@Service
@RequiredArgsConstructor
@Transactional
public class PersonService {
    private final PersonRepository personRepository;

//    public PersonService(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }
//    
    public void insertPerson(Person person){
        personRepository.save(person);
    }
    public List<Person> selectAllPerson(){
        return personRepository.findAll();
    }
    public List<Person> selectAllByPerson(String name){
        return personRepository.findByName(name);
    }
    public List<Person> selectAllByNameAndCity(Person person){
       return personRepository.findByNameAndCity(person.getName(), person.getCity());  
    }
        public List<Person> selectAllByNameOrCity(Person person){
       return personRepository.findByNameOrCity(person.getName(), person.getCity());  
    }
        public void updatePersonById(Person person, String familneu){
             List<Person> persons = personRepository.findByIds(person.getId());
             for(Person p:persons){
                 p.setFamil(familneu);
                 personRepository.save(p);
             }
             
        }
}
