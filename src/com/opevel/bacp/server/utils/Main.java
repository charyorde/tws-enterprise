/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opevel.bacp.server.utils;

//import JPA20.util.JPAUtil;
import com.opevel.bacp.server.domain.Users;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/*import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;*/

/**
 *
 * @author Kayode Odeyemi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create EntityManager
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("BACP-PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.getTransaction().commit();
        /*EntityTransaction tx = em.getTransaction();
        tx.begin();

        tx.commit();*/

        String jpql = "select u from Users u where u.uid = 1";
        Query query = em.createQuery(jpql);
        List<Users> users = query.getResultList();
        displayQueryResult(jpql, users);

        /*///////// Perform the same query using Criteria API
        CriteriaBuilder cbuilder = em.getEntityManagerFactory().getCriteriaBuilder();
        CriteriaQuery<Student> criteria = cbuilder.createQuery(Student.class);
        Root<Student> st = criteria.from(Student.class);

        // ---- Build criteria
        criteria.select(st);
        criteria.where(cbuilder.ge(st.get("grade").as(Integer.class), (Number)3.0));

        stud = em.createQuery(criteria).getResultList();*/

        // ---- Display the result
        //displayQueryResult2(stud);

        em.close();
        emf.close();
        

    }

     // Display the query result
    public static void displayQueryResult(String jpql, List<Users> users) {
        System.out.println("\n------ Query result of \"" + jpql + "\"");
        for (Users u : users) {
            System.out.println("Email " + u.getEmail()+ ", " + u.getPass());
        }
    }

    /*private static void displayQueryResult2(List<Student> stud) {
        System.out.println("\n******* Query result using Criteria API");
        for (Student st : stud) {
            System.out.println("Student " + st.getSchool().getSchoolName() + ", " + st.getStudentName() + ", " + st.getGrade());
        }
    }*/

}
