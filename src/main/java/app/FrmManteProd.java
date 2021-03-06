package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Categoria;
import model.Producto;
import model.Proveedor;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	private JPanel contentPane;
	
	private JTextArea txtSalida;
	private JTextField txtC?digo;
	JComboBox cboCategorias;
	JComboBox cboProveedores;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnNewButton.setBounds(324, 29, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);
		
		txtC?digo = new JTextField();
		txtC?digo.setBounds(122, 11, 86, 20);
		contentPane.add(txtC?digo);
		txtC?digo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Id. Producto :");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);
		
		cboCategorias = new JComboBox();
		cboCategorias.setBounds(122, 70, 86, 22);
		contentPane.add(cboCategorias);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);
		
		JLabel lblNomProducto = new JLabel("Nom. Producto :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 42, 144, 20);
		contentPane.add(txtDescripcion);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 106, 102, 14);
		contentPane.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 103, 77, 20);
		contentPane.add(txtStock);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 134, 102, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 131, 77, 20);
		contentPane.add(txtPrecio);
		
		JLabel lblProveedores = new JLabel("Proveedor:");

		lblProveedores.setBounds(230, 106, 102, 14);

		contentPane.add(lblProveedores);

		

		cboProveedores = new JComboBox();

		cboProveedores.setBounds(300, 104, 120, 22);

		contentPane.add(cboProveedores);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar.setBounds(324, 65, 89, 23);
		contentPane.add(btnBuscar);
		
		llenaComboCategoria();
		llenaComboProveedores();
	}

	private void llenaComboProveedores() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		
		//Manejador de entidades
		EntityManager em = fabrica.createEntityManager();

		//Aca no es necesario empezar ni terminar una transaccion pq no estamos cambiando nada
		//Geenralmente cuando hacemos una consulta estamos recuperando informacion no modificandola
		
		//Consulta con TypeQuery
		TypedQuery<Proveedor> consulta =em.createQuery("select p from Proveedor p", Proveedor.class);
		
		//Para poder listar un TypedQuery
		//El metodo getResultList es el metodo que nos devuelve el listado de nuestra consulta de tipo typequery
		java.util.List<Proveedor> listadoProveedores = consulta.getResultList();
		
		
		//Imprimir
		cboProveedores.addItem("Seleccione");
		for(Proveedor pro: listadoProveedores) {
			cboProveedores.addItem(pro.getIdprovedor() +"-"+ pro.getNombre_rs());
		}
		em.close();
		
	}

	void llenaComboCategoria() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		
		//Manejador de entidades
		EntityManager em = fabrica.createEntityManager();

		//Aca no es necesario empezar ni terminar una transaccion pq no estamos cambiando nada
		//Geenralmente cuando hacemos una consulta estamos recuperando informacion no modificandola
		
		//Consulta con TypeQuery
		TypedQuery<Categoria> consulta =em.createQuery("select ca from Categoria ca", Categoria.class);
		
		//Para poder listar un TypedQuery
		//El metodo getResultList es el metodo que nos devuelve el listado de nuestra consulta de tipo typequery
		java.util.List<Categoria> listadoCategorias = consulta.getResultList();
		
		
		//Imprimir
		cboCategorias.addItem("Seleccione");
		for(Categoria ca: listadoCategorias) {
			cboCategorias.addItem(ca.getIdcategoria() +"-"+ ca.getDescripcion());
		}
		em.close();
	}
	
	void listado() {
		//Crear un listado de los productos
		
		//Grabar en la tabla --> JPA
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

				
		//Manejador de entidades
		EntityManager em = fabrica.createEntityManager();

		//Aca no es necesario empezar ni terminar una transaccion pq no estamos cambiando nada
		//Geenralmente cuando hacemos una consulta estamos recuperando informacion no modificandola
		
		//Consulta con TypeQuery
		TypedQuery<Producto> consulta =em.createQuery("select pro from Producto pro", Producto.class);
		
		//Para poder listar un TypedQuery
		//El metodo getResultList es el metodo que nos devuelve el listado de nuestra consulta de tipo typequery
		java.util.List<Producto> listadoProductos = consulta.getResultList();
		
		txtSalida.setText("");
		
		for(Producto p: listadoProductos) {
			txtSalida.append("************************************************" + "\n");
			txtSalida.append("Id Producto : " + p.getId_prod() + "\n");
			txtSalida.append("Descripcicon: " + p.getDes_prod() + "\n");
			txtSalida.append("Stock       : " + Integer.toString(p.getStk_prod()) + "\n");
			txtSalida.append("Precio      : " + Double.toString(p.getPre_prod()) + "\n");
			txtSalida.append("Categoria   : " +Integer.toString(p.getIdcategoria())+" (" + p.getCategoria().getDescripcion()+")"+"\n");
			txtSalida.append("Estado      : " +Integer.toString(p.getEst_prod())+"\n");
			txtSalida.append("Proveedor   : " +Integer.toString(p.getIdprovedor())+" ("+ p.getProvedor().getNombre_rs()+")"+"\n\n");
	
		}
	
		em.close();
	}
	
	void registrar() {
		
		//Leer datos
		String idproducto = txtC?digo.getText();
		String descripcion = txtDescripcion.getText();
		int stock = Integer.parseInt( txtStock.getText());
		double precio = Double.parseDouble( txtPrecio.getText());
		int categoria = cboCategorias.getSelectedIndex();
		int estado = 1;
		int proveedor = cboProveedores.getSelectedIndex();
		
		//Crear producto
		Producto pro = new Producto();
		
		pro.setId_prod(idproducto);
		pro.setDes_prod(descripcion);
		pro.setStk_prod(stock);
		pro.setPre_prod(precio);
		pro.setIdcategoria(categoria);
		pro.setEst_prod(estado);
		pro.setIdprovedor(proveedor);
		
		//Grabar en la tabla --> JPA
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		//Manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//Empezar mi transaccion
		em.getTransaction().begin();
		//Proceso
		em.persist(pro); //Para grabar en la tabla o entidad
		//Confirmar la transaccion
		em.getTransaction().commit();
		//Cerrar mi manejador
		em.close();
		
		JOptionPane.showMessageDialog(this, "Producto registrado");
		
	}
	void buscar() {
		//variables

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();

		//proceso

		em.getTransaction().begin();

		Producto p = em.find(Producto.class, txtC?digo .getText());

		
		//Salida

		txtDescripcion.setText(p.getDes_prod());

		cboCategorias.setSelectedIndex(p.getIdcategoria());

		txtPrecio.setText(Double.toString(p.getPre_prod()));

		txtStock.setText(Integer.toString(p.getStk_prod()));

		cboProveedores.setSelectedIndex(p.getIdprovedor());

		// confirmar la transaccion

		em.getTransaction().commit();

		em.close();	
	}
}
