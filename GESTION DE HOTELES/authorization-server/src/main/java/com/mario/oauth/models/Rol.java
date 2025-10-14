package com.mario.oauth.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="ROLES_AUTH")
@Getter
@Setter

@NoArgsConstructor
public class Rol {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLES_SEQ")
	@SequenceGenerator(name= "ROLES_SEQ", sequenceName = "ROLES_SEQ", allocationSize = 1)
	@Column(name = "ID_ROL" )
	private Long id;
	
	@Column(name="NOMBRE", nullable=false,length=20,unique=true)
	
	private String nombre;
}
