package io.github.admgk.finviews.indicator;

import io.github.admgk.finviews.utils.Period;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name="average_salary")
class AverageSalary extends Indicator {
    static final String NAME = "Average Salary";
    static final Period PERIOD_TYPE = Period.YEAR;

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    Integer id;

    @Column(name = "salary_period")
    Date averageSalaryPeriod;

    @Column(name = "salary_value")
    BigDecimal averageSalaryValue;

    public AverageSalary() {}

    public AverageSalary(Integer id, Date averageSalaryPeriod, BigDecimal averageSalaryValue) {
        this.id = id;
        this.averageSalaryPeriod = averageSalaryPeriod;
        this.averageSalaryValue = averageSalaryValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    String getNAME() {
        return NAME;
    }

    @Override
    Period getPERIOD_TYPE() {
        return PERIOD_TYPE;
    }

    @Override
    public Date getPeriod() {
        return averageSalaryPeriod;
    }

    public void setPeriod(Date averageSalaryPeriod) {
        this.averageSalaryPeriod = averageSalaryPeriod;
    }

    @Override
    public BigDecimal getValue() {
        return averageSalaryValue;
    }

    public void setValue(BigDecimal averageSalaryValue) {
        this.averageSalaryValue = averageSalaryValue;
    }
}
