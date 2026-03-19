package com.sp26.team8.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "providers")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "provider_id")
public class Provider extends User {


    @Column(columnDefinition = "TEXT")
    private String bio;

    @OneToOne(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("provider")
    private Provider Provider;
}

