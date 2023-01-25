package com.nobile.realing.entity;

import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


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

    @Size(max = 50, message = "{validation.file.name.size.too_long}")
    @NotBlank(message = "{validation.file.name.not_blank}")
	@NotNull(message = "{validation.file.name.not_null}")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "{validation.file.ubication.not_blank}")
	@NotNull(message = "{validation.file.ubication.not_null}")
    @Column(name = "ubication", nullable = false)
    private String ubication;

    @JsonIgnore
    @OneToMany(mappedBy = "file", cascade = CascadeType.ALL)
    private List<ContentTranslate> contentTranslate;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
}
