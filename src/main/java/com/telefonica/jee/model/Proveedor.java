package com.telefonica.jee.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Proveedor
 *
 */
@Entity
@Table(name="proveedor")
@NamedQuery(name="Proveedor.findAll", query="SELECT p FROM Proveedor p")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_proveedor")
	private Integer id_proveedor;
	
	@Column(name = "nombre_proveedor")
	private String nombre_proveedor;

	@ManyToMany
	@JoinTable(name = "proveedor_producto",
	joinColumns = @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor"),
	inverseJoinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "id_producto"))
	private List<Proveedor> proveedores = new ArrayList<>();
	
	public Proveedor() {
		super();
	}
	
	public Proveedor(Integer id_proveedor, String nombre_proveedor, List<Proveedor> proveedores) {
		super();
		this.id_proveedor = id_proveedor;
		this.nombre_proveedor = nombre_proveedor;
		this.proveedores = proveedores;
	}

	public Integer getId_proveedor() {
		return this.id_proveedor;
	}

	public void setId_proveedor(Integer id_proveedor) {
		this.id_proveedor = id_proveedor;
	}   
	public String getNombre_proveedor() {
		return this.nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Proveedor [id_proveedor=" + id_proveedor + ", nombre_proveedor=" + nombre_proveedor + ", num proveedores: "
				+ proveedores.size() + "]";
	}
	
	
}
