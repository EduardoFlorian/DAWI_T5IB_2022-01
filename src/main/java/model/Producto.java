package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="tb_productos")
public class Producto {
	@Id
	private String id_prod;
	private String des_prod;
	private int stk_prod;
	private double pre_prod;
	
	@ManyToOne
	@JoinColumn(name="idcategoria", insertable = false, updatable = false)
 	private Categoria categoria; //Para el listado join 
	private int idcategoria; //Nos va servir para grabar un producto
	private int est_prod;
	@ManyToOne
	@JoinColumn(name="idprovedor", insertable = false, updatable = false)
	private Proveedor provedor;
	private int idprovedor;
	
	
	
}
