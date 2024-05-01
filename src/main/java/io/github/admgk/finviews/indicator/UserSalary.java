package io.github.admgk.finviews.indicator;

import io.github.admgk.finviews.utils.Period;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name="user_salary")
class UserSalary extends Indicator {
    static final String NAME = "User Salary";
    static final Period PERIOD_TYPE = Period.YEAR;

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    Integer id;

    @Column(name = "salary_period")
    Date userSalaryPeriod;

    @Column(name = "salary_value")
    BigDecimal userSalaryValue;

    public UserSalary() {}

    public UserSalary(Integer id, Date userSalaryPeriod, BigDecimal userSalaryValue) {
        this.id = id;
        this.userSalaryPeriod = userSalaryPeriod;
        this.userSalaryValue = userSalaryValue;
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
        return userSalaryPeriod;
    }

    public void setPeriod(Date userSalaryPeriod) {
        this.userSalaryPeriod = userSalaryPeriod;
    }

    @Override
    public BigDecimal getValue() {
        return userSalaryValue;
    }

    public void setValue(BigDecimal userSalaryValue) {
        this.userSalaryValue = userSalaryValue;
    }
}
