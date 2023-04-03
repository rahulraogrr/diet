package com.diet.entities;

import com.diet.enums.YesNo;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "t_diet_statistics")
public class Statistics implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Temporal(TemporalType.DATE)
    private LocalDate dietDate;

    private Float water;

    private Float walk;

    private Float elliptical;

    private Float rowingMachine;

    private Float weight;

    @Enumerated(EnumType.STRING)
    private YesNo allActivitiesCompleted;

    @CreationTimestamp
    private LocalDateTime createTs;

    @UpdateTimestamp
    private LocalDateTime updateTs;
}