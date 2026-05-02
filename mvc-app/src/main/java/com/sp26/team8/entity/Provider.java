package com.sp26.team8.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "providers")
@Data
@EqualsAndHashCode(callSuper = true) 
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "provider_id")
public class Provider extends User {

    @Column(nullable = false)
    private String name;

    @Column
    private String phoneNumber;

    @Column
    private String address;

    
    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CleaningService> services;
}


