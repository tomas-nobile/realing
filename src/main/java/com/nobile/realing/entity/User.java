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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Email(message = "{validation.email}") 
    @NotBlank(message = "{validation.not_blank}")
	@NotNull(message = "{validation.not_null}")
    @Column(name = "email", nullable = false,unique=true )
    private String email;


    @Pattern(regexp = "^[\\p{Alnum}]{1,32}$", message = "{validation.username.pattern.alphanumeric}")
    @Size(min = 5, message = "{validation.user.size.too_short}") 
    @Size(max = 20, message = "{validation.user.size.too_long}")
    @NotBlank(message = "{validation.not_blank}")
	@NotNull(message = "{validation.not_null}")
	@Column( nullable = false, unique = true)
	private String username;

    @NotBlank(message = "{validation.not_blank}")
	@NotNull(message = "{validation.not_null}")
	@Column(nullable = false)
	private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<File> file;

}
