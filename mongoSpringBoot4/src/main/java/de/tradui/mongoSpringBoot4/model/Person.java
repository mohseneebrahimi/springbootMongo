/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.tradui.mongoSpringBoot4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author MM
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("PersonCol")
@ToString
public class Person {
    @Id
    private String id;
    @Field(name = "name")
    @Indexed(unique = true)
    private String name;
    @Field(name = "famil")
    private String famil;
    @Field(name = "city")
    private String city;
    @Field(name = "Eigendchaften")
    private PersonEigenschaft personEigenschaft;
    
    
}
