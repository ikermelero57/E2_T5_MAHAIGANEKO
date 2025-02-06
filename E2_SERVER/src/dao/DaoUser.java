package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import connection.HibernateUtil;
import model.Horarios;
import model.Users;

public class DaoUser {

	private static final String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
	
	public DaoUser() {
	}
	
	/**
	 * Function that returns the user with the same id if it has the same password as the one passed as a parameter
	 * @param email the user's email
	 * @param encripdedPassword the user's password
	 * @return Users
	 */
	public Boolean login(String email, String encripdedPassword) {
		Boolean loginCredentialsOk = false;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			String hql = "FROM Users WHERE email = :key1";
			Users user = (Users) session.createQuery(hql).setParameter("key1", email).uniqueResult();

			String password = new String();
			
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-1");
				byte dataBytes[] = user.getPassword().getBytes();
				System.out.println(user.getPassword());
				md.update(dataBytes);
				byte resumen[] = md.digest();
				password = new String(resumen);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}

			// Comprobación de si el usuario existe.
			if (password.equals(encripdedPassword)) {
				loginCredentialsOk = true;
			}

			tx.commit();
		} catch (Exception e) {
			System.out.println("Error en login");
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return loginCredentialsOk;
	}
	
	/**
	 * Function that returns the user with the same email
	 * @param email the user's email
	 * @return Users
	 */
	public Users getUserByEmail(String email) {
		Users user = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			String hql = "FROM Users WHERE email = :key1";
			user = (Users) session.createQuery(hql).setParameter("key1", email).uniqueResult();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return user;
	}
	
	/**
	 * function that returns all the teachers
	 * @return ArrayList<Users>
	 */
	public ArrayList<Users> getTeachers() {
		ArrayList<Users> teachersList = new ArrayList<Users>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			String hql = "FROM Users WHERE tipo_id = :key1";
			teachersList = (ArrayList<Users>) session.createQuery(hql).setParameter("key1", 3).list();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return teachersList;
	}
	
	/**
	 * function that returns all the students
	 * @return ArrayList<Users>
	 */
	public ArrayList<Users> getStudents() {
		ArrayList<Users> studentsList = new ArrayList<Users>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			String hql = "FROM Users WHERE tipo_id = :key1";
			studentsList = (ArrayList<Users>) session.createQuery(hql).setParameter("key1", 4).list();
			for (Users user : studentsList) {
				user.getEmail();
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
		return studentsList;
	}
	
	public String changePassword(String email) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		String newPassword = generatePassword(12);
		
		try {
			tx = session.beginTransaction();

			String hql = "UPDATE Users set password = :key1 WHERE email = :key2";
			session.createQuery(hql).setParameter("key1", newPassword).setParameter("key2", email).executeUpdate();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return newPassword;
	}


    public static String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARSET.length());
            password.append(CHARSET.charAt(randomIndex));
        }
        return password.toString();
    }

    public static void main(String[] args) {
        System.out.println(generatePassword(12));
    }
}
