package it.garbi.consuntivo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name="user")
@Entity
@AllArgsConstructor @NoArgsConstructor
public class User {
	
	@Getter @Setter
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotEmpty @NotBlank @NotNull
	private Integer id;
	
	@Getter @Setter
	@Column(name="username")
	@NotEmpty @NotBlank @NotNull
	private String username;
	
	@Getter @Setter
	@Column(name="password")
	@NotEmpty @NotBlank @NotNull
	private String password;
	
	@Getter @Setter
	@Column(name="email")
	@NotEmpty @NotBlank @NotNull
	private String email;
	
	@Getter @Setter
	@Column(name="nome")
	@NotEmpty @NotBlank @NotNull
	private String nome;
	
	@Getter @Setter
	@Column(name="cognome")
	@NotEmpty @NotBlank @NotNull
	private String cognome;
	
	@Column(name="permission")
	@NotEmpty @NotBlank @NotNull
	@Getter @Setter
	private String permission;

}
