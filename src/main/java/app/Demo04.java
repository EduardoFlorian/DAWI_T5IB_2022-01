package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Obtener los datos de un usuario pero seg?n su codgio
		
		
		//Grabar en la tabla --> JPA
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

				
		//Manejador de entidades
		EntityManager em = fabrica.createEntityManager();
				

		//empezo la transaccion
		em.getTransaction().begin();
		
		//eliminar un usuario
		Usuario u = em.find(Usuario.class, 1);
		em.remove(u);

		//confirmar la transaccion
		em.getTransaction().commit();
		em.close();

	}

}
