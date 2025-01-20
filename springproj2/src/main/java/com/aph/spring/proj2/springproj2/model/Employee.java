package com.aph.spring.proj2.springproj2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name",length = 25,nullable = false)
    private String name;
    @Column(name ="position",length = 10,nullable = false)
    private String position;
    @Column(name = "created_at",length = 13,nullable = true)
    private String createdAt;
    @Column(name="updated_at",length = 13,nullable = true)
    private String updatedAt;
}
