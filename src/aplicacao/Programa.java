package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(null,"Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null,"Joaquim torees", "joaka@gmail.com");
		Pessoa p3 = new Pessoa(null,"Ana Maria", "ana@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
//		//inicia a transação com o banco de dados
//		em.getTransaction().begin();
//		
//		//cria os objetos p1,p2,p3
//		em.persist(p1);
//		em.persist(p2);
//		em.persist(p3);
//		
//		//confirma as alterações feitas
//		em.getTransaction().commit();
		
		//Busca objeto pelo ID
//		Pessoa p = em.find(Pessoa.class, 2);
//		System.out.println(p);
		
		//apagar pessoa do banco
		//so consigo deletar objeto monitorado / se o objeto estiver destacado não consigo deletar
		//destacado é que ja esta persistido
		
		//monitorado é objeto que eu acabei de inserir ou busquei do banco de dados
		Pessoa p = em.find(Pessoa.class, 2); //monitorando
		em.remove(p);
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		System.out.println("Pronto");
		em.close();
		emf.close();
		
	}

}
