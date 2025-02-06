package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import connection.HibernateUtil;
import model.Horarios;
import model.Modulos;

public class DaoModulos {

	public DaoModulos() {

	}
	
	/**
	 * Function that returns the module with the same id
	 * @param id
	 * @return Modulos
	 */
	public Modulos getModulo(int id) {
		Modulos modulo = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			String hql = "FROM Modulos WHERE id = :key1";
			modulo = (Modulos) session.createQuery(hql).setParameter("key1", id).uniqueResult();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return modulo;

	}

}
