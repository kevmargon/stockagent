package com.telefonica.jee.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Producto
 *
 */
@Entity
@Table(name="producto")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_producto;
	
	private String nombre_producto;
	
	private BigDecimal precio_producto;
	
	private String marca_producto;

	public Producto() {
		super();
	}   
	public Integer getId_producto() {
		return this.id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}   
	public String getNombre_producto() {
		return this.nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}   
	public BigDecimal getPrecio_producto() {
		return this.precio_producto;
	}

	public void setPrecio_producto(BigDecimal precio_producto) {
		this.precio_producto = precio_producto;
	}   
	public String getMarca_producto() {
		return this.marca_producto;
	}

	public void setMarca_producto(String marca_producto) {
		this.marca_producto = marca_producto;
	}
   
}
