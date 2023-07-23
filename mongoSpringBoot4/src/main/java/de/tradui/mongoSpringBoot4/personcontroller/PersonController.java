/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.tradui.mongoSpringBoot4.personcontroller;

import de.tradui.mongoSpringBoot4.Service.PersonService;
import de.tradui.mongoSpringBoot4.model.Person;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MM
 */
@RestController
@RequestMapping("/p")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;
//    public PersonController(PersonService personService) {
//       this.personService = personService;
// }
    
    @GetMapping("/hello")
    public String sayHello(){
        return "hallo welt";
    }
    
    @PostMapping("/insert")
    public ResponseEntity insertPerson(@RequestBody Person person){
        personService.insertPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/selectallperson")
    public ResponseEntity<List<Person>> selectAllPerson(){
        return ResponseEntity.ok(personService.selectAllPerson());
    }
    @GetMapping("/selectbyname/{name}")
    public ResponseEntity<List<Person>> selectAllPerson(@PathVariable String name){
        return ResponseEntity.ok(personService.selectAllByPerson(name));
       
        
    }
    @PostMapping("/selectbynameandcity")
    public ResponseEntity<List<Person>> selectbynameandcity(@RequestBody Person person){
        return ResponseEntity.ok(personService.selectAllByNameAndCity(person));
    }
    @PostMapping("/selectbynameorcity")
    public ResponseEntity<List<Person>> selectbynameorcity(@RequestBody Person person){
        return ResponseEntity.ok(personService.selectAllByNameOrCity(person));
    }
    @PutMapping("/updatePerson/{familneu}")
    public ResponseEntity updatebyId(@RequestBody Person person, @PathVariable String familneu){
        personService.updatePersonById(person,familneu);
        return ResponseEntity.ok().build();
    }
}
