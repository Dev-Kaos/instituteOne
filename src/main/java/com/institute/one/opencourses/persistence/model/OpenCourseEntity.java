package com.institute.one.opencourses.persistence.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.institute.one.courses.persistence.model.CourseEntity;
import com.institute.one.schooldays.persistence.model.SchooldayEntity;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name = "open_courses")
public class OpenCourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private CourseEntity course;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "schoolday_id", referencedColumnName = "id")
    private SchooldayEntity schoolday;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "first_pay")
    private Double firstPay;

    @Column(name = "total_pay")
    private Double totalPay;

    @Column(name = "state")
    private StateEnum state;

}
