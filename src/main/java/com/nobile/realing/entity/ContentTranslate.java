package com.nobile.realing.entity;

import lombok.*;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @Size(max = 50, message = "{validation.user.size.too_long}")
    @NotBlank(message = "{validation.not_blank}")
	@NotNull(message = "{validation.not_null}")
    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(optional = false)
    @JoinColumn(name = "file_id",referencedColumnName = "id")
    private File file;

}
