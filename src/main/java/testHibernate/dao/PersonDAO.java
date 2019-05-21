package testHibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

import testHibernate.model.Person;

@Component
public class PersonDAO {

//    @PersistenceContext(unitName = "testHibernate.person_catalog")
    @PersistenceContext
    private EntityManager em;

    public List<Person> getAllPersons() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> q = cb.createQuery(Person.class);
        Root<Person> root = q.from(Person.class);
        q.select(root);
        List<Person> personList = em.createQuery(q).getResultList();
        return personList;
    }

}
