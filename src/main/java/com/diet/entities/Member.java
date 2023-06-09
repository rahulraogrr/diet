package com.diet.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "t_members")
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;

    private String firstName;

    private String lastName;

    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Statistics.class, orphanRemoval = true)
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Set<Statistics> statistics = new HashSet<>();

    @CreationTimestamp
    private LocalDateTime createTs;

    @UpdateTimestamp
    private LocalDateTime updateTs;
}
