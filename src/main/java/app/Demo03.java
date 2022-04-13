package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//eliminar usuario


		//Grabar en la tabla --> JPA
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

				
		//Manejador de entidades
		EntityManager em = fabrica.createEntityManager();
				

		//empezo la transaccion
		em.getTransaction().begin();

		//eliminar un usuario
		//forma 1 - borrado logico -> donde no lo borras, solo cambias el estado, flag
		//Update ;V= Borrado logico

		//forma 2 - borrado fisico -> borra el registro
		
		//Usuario a eliminar (Si queremos eliminar un objeto debemos pasarle ub ojeto con todos sus datos)
		Usuario u = new Usuario(3, "Carla", "Toro", "u002@mail.com","10002", "2022-03-24", 2, 1);
		em.remove(u);

		//confirmar la transaccion
		em.getTransaction().commit();
		em.close();


	}

}
