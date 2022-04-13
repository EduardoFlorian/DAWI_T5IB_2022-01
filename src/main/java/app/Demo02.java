package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//actualizar datos de usuario
		Usuario u = new Usuario(33, "Carla", "Toro", "u0032@mail.com", "10002", "2022-03-24", 2, 1);

		//Grabar en la tabla --> JPA
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		//Manejador de entidades
		EntityManager em = fabrica.createEntityManager();

		//empezo la transaccion
		em.getTransaction().begin();

		//proceso --> actualizar en la tabla
		em.merge(u);//actualiza si existe el codigo, sino lo inserta
		
		//confirmar la transaccion
		em.getTransaction().commit();
		em.close();


	}

}
