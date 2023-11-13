package com.example.flower.users;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppUser {
    @Id
    private int id;
    @Column(unique = true)
    private String email;
    @Transient
    private LocalDate dob;
    private int age;

    public int getAge() {
        if (dob == null) {
            return 0; // Or handle the null case as needed
        }

        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dob, currentDate);
        return period.getYears();
    }

    public AppUser(AppUser user) {
        this.email = user.email;
        this.dob = user.dob;
        this.age = user.age;
    }
}
