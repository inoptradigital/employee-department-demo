package com.inoptra.employeedepartmentdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * SalaryComponent is dependent upon base salary and can be calculated as baseSalary multiplied by respective factor.
 * i.e. SalaryComponent_amount = baseSalary * factor;
 * Actual salary can be calculated as sum of all SalaryComponent amounts.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Min(value = 0, message = "base salary must be greater than zero")
    private double baseSalary;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="salary_id")
    private List<SalaryComponent> salaryComponents;
}
