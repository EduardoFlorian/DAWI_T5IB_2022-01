package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Obtener los datos de un usuario pero según su codgio
		
		
		//Grabar en la tabla --> JPA
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

				
		//Manejador de entidades
		EntityManager em = fabrica.createEntityManager();
				

		//empezo la transaccion
		em.getTransaction().begin();
		
		//eliminar un usuario
		Usuario u = em.find(Usuario.class, 40);
		if(u == null) {
			System.out.println("Usuario no existe");
		}
		else {
			em.remove(u);
			System.out.println("Usuario eliminado");
		}
		//confirmar la transaccion
		em.getTransaction().commit();
		em.close();
	}

}
