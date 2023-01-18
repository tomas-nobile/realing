package com.nobile.realing.entity;

import lombok.*;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "content_translate")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContentTranslate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(optional = false)
    @JoinColumn(name = "file_id",referencedColumnName = "id")
    private File file;

}
