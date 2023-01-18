package com.nobile.realing.entity;

import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "file")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "file", cascade = CascadeType.ALL)
    private List<ContentTranslate> contentTranslate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
}
