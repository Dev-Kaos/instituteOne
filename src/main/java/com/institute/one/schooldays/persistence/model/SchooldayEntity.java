package com.institute.one.schooldays.persistence.model;

import java.util.HashSet;
import java.util.Set;

import com.institute.one.utilities.enums.CertificationEnum;
import com.institute.one.utilities.enums.CourseTypeEnum;
import com.institute.one.utilities.enums.StateEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schooldays")
public class SchooldayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "state")
    private StateEnum state;

    // @ManyToOne
    // @JoinColumn(name = "clienteid", referencedColumnName = "id")
    // private Cliente cliente;

}