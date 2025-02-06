package dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import connection.HibernateUtil;
import model.Reuniones;
import model.Users;

public class DaoReuniones {

	public DaoReuniones() {
	}
	/**
	 * Function that update a meeting state
	 * 
	 * @param id
	 * @param estado the new state to update
	 */
	public void updateReunionState(int idReunion, String estado) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Reuniones reunion = session.get(Reuniones.class, idReunion);
			if (reunion != null) {
				reunion.setEstadoEus(estado);
				session.update(reunion);
			} else {
				System.out.println("Reunion not found: " + idReunion);
			}
			session.update(reunion);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * Function that returns all meetings by the teacher's email
	 * 
	 * @param email
	 * @return
	 */
	public ArrayList<Reuniones> getReunionesByUsersEmail(String email) {
		ArrayList<Reuniones> reunionesList = new ArrayList<Reuniones>();

		DaoUser daoUser = new DaoUser();
		Users user = daoUser.getUserByEmail(email);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {

			if (user.getTipos().getId() == 4) {
				tx = session.beginTransaction();

				String hql = "FROM Reuniones where usersByAlumnoId = :key1";

				reunionesList = (ArrayList<Reuniones>) session.createQuery(hql).setParameter("key1", user).list();

				tx.commit();
				
			} else {
				tx = session.beginTransaction();

				String hql = "FROM Reuniones where usersByProfesorId = :key1";

				reunionesList = (ArrayList<Reuniones>) session.createQuery(hql).setParameter("key1", user).list();

				tx.commit();
			}

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return reunionesList;
	}
	
	/**
	 * Function that add a meeting
	 * @param reunion
	 */
	public Reuniones addReunion(Reuniones reunion) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(reunion);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return reunion;
	}

}
