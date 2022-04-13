package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Listado de usuarios segun su tipo
		
		//Grabar en la tabla --> JPA
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

				
		//Manejador de entidades
		EntityManager em = fabrica.createEntityManager();

		//Consulta con TypeQuery
		TypedQuery<Usuario> consulta =em.createQuery("select usu from Usuario usu where usu.tipo = :parametrotipo ", Usuario.class);
		consulta.setParameter("parametrotipo", 2);
		//Para poder listar un TypedQuery
		//El metodo getResultList es el metodo que nos devuelve el listado de nuestra consulta de tipo typequery
		
		java.util.List<Usuario> listadoUsuario = consulta.getResultList();
		
		//Version resumida
		//java.util.List<Usuario> listadoUsuarios =em.createQuery("select usu from Usuario usu", Usuario.class).getResultList();
		
		
		//Imprimir
		for(Usuario u: listadoUsuario) {
			System.out.println(u);
		}
		em.close();
	}

}
