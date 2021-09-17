package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Music;


/**
 * @author - Aaron Barker
 * CIS175 - Fall 2021
 * Sep 14, 2021
 */


public class MusicHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("songs");

// INSERT NEW SONG
	public void insertSong(Music music) {
			
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(music);
		em.getTransaction().commit();
		em.close();
	}
	
	
// DELETE SPECIFIED SONG
	public void deleteSong(Music toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Music> typedQuery = em.createQuery("SELECT m FROM Music m "
													+ "WHERE m.title = :title AND m.artist = :artist", Music.class);
		
		typedQuery.setMaxResults(1);
		
		typedQuery.setParameter("title", toDelete.getTitle());
		typedQuery.setParameter("artist",toDelete.getArtist());
		
		try {
			Music result = typedQuery.getSingleResult();  // single result required
			em.getTransaction().begin();
			em.remove(result);  // remove result from 'songlist' table
			em.getTransaction().commit();
			em.close();
		}catch(NoResultException e) {
			//do nothing
		}
		
		em.getTransaction().commit();
		em.close();
	}
	

// VIEW CURRENT SONG LIST
	public List<Music> showSongs(){
		EntityManager em = emfactory.createEntityManager();
		List<Music> allItems = em.createQuery("SELECT s FROM Music s").getResultList();
		return allItems;
		}
	
	
// UPDATE SPECIFIED SONG

}
