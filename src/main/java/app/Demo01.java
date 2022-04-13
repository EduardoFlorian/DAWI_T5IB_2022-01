package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Valores del nuevo Usuario
		Usuario usuario = new Usuario(40, "Pedro", "Perez", "jperez@gamil.com","345", "2020/01/05", 1, 1);
		//Grabar en la tabla --> JPA
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		//Manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//Empezar mi transaccion
		em.getTransaction().begin();
		//Proceso
		em.persist(usuario); //Para grabar en la tabla o entidad
		//Confirmar la transaccion
		em.getTransaction().commit();
		//Cerrar mi manejador
		em.close();
		
	}

}
