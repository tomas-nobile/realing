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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Email(message = "{validation.user.email}") 
    @NotBlank(message = "{validation.user.email.not_blank}")
	@NotNull(message = "{validation.user.email.not_null}")
    @Column(name = "email", nullable = false,unique=true )
    private String email;

    @NotBlank(message = "{validation.user.password.not_blank}")
	@NotNull(message = "{validation.user.password.not_null}")
    @Size(min = 6, message = "{validation.user.password.size.too_short}") 
    @Size(max = 20, message = "{validation.user.password.size.too_long}")
	@Column(nullable = false)
	private String password;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

}
