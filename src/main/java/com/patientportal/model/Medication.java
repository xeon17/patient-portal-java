package com.patientportal.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "medications")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "medication", cascade = CascadeType.ALL)
    private Set<PrescriptionMedication> prescriptionMedications;

    @NonNull
    private String dosage;

    @NonNull
    private String frequency;

    @NonNull
    private String duration;

    @NonNull
    private String notes;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
