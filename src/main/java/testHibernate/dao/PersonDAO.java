package testHibernate.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import testHibernate.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.List;


@Component
public class PersonDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonDAO.class);


    @PersistenceContext(unitName = "testHibernate.person_catalog")
    private EntityManager em;

      @Transactional(value = "txManager")

    public List<Person> getAllPersons() throws SQLException, Exception {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> q = cb.createQuery(Person.class);
        Root<Person> root = q.from(Person.class);
        q.select(root);
        LOGGER.info("SELECT FROM TABLE PERSON!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        return em.createQuery(q).getResultList();
    }

}
