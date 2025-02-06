package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import connection.HibernateUtil;
import model.Horarios;
import model.HorariosId;
import model.Users;

public class DaoHorarios {

	public DaoHorarios() {
	}
	/**
	 * Function that returns all teachers schedules
	 * @param email Teacher's email
	 * @return ArrayList<Horarios>
	 */
	public ArrayList<Horarios> getHorariosByTeachersEmail(String email) {

		DaoUser userDao = new DaoUser();
		Users user = userDao.getUserByEmail(email);

		ArrayList<Horarios> horariosList = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			String hql = "FROM Horarios WHERE users = :key1";

			horariosList = (ArrayList<Horarios>) session.createQuery(hql).setParameter("key1", user).list();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return horariosList;
	}

	/**
	 * Function that returns all Students schedules
	 * @param email Student's email
	 * @return List<Horarios>
	 */
    public List<Horarios> getHorariosByStudentId(String email) {
        List<Horarios> horariosList = null;
        
        List<Horarios> horariosListAux = new ArrayList<Horarios>();
        
        DaoUser userDao = new DaoUser();
        Users user = userDao.getUserByEmail(email);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // JPQL para obtener los horarios por el usuario
            String hql = "from Horarios as h "
                    + "join fetch h.modulos as m "
                    + "join fetch h.users as u "
                    + "join fetch u.tipos as t "
                    + "join fetch m.ciclos as c "
                    + "join fetch c.matriculacioneses as mat "
                    + "where mat.id.alumId = '" + user.getId()  
                    + "' and m.nombre not in ('Tutoria', 'Guardia')"
                    ;   
            
            horariosList = (ArrayList<Horarios>) session.createQuery(hql).list();
            
			for (Horarios h : horariosList) {
				
            	if(h.getModulos().getCurso() == 2) {
            	    horariosListAux.add(h);
            	}
            }
            
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return horariosListAux;
    }
}
