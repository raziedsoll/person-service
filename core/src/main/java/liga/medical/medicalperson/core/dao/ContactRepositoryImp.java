package liga.medical.medicalperson.core.dao;

import liga.medical.medicalperson.core.dao.api.ContactRepository;
import liga.medical.medicalperson.core.model.entity.Address;
import liga.medical.medicalperson.core.model.entity.Contact;
import liga.medical.medicalperson.core.model.entity.PersonData;
import liga.medical.medicalperson.core.model.entity.MedicalCard;
import liga.medical.medicalperson.core.model.entity.Illness;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class ContactRepositoryImp implements ContactRepository {
    @Override
    public Contact getContactById(int contactId) {
        Session session = null;
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Contact.class)
                .addAnnotatedClass(PersonData.class)
                .addAnnotatedClass(MedicalCard.class)
                .addAnnotatedClass(Illness.class)
                .buildSessionFactory()) {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Contact contact = session.get(Contact.class, contactId);
            session.getTransaction().commit();
            return contact;

        } finally {
            assert session != null;
            session.close();
        }
    }

    @Override
    public int postContact(Contact contact) {
        Session session = null;
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Contact.class)
                .addAnnotatedClass(PersonData.class)
                .addAnnotatedClass(MedicalCard.class)
                .addAnnotatedClass(Illness.class)
                .buildSessionFactory()) {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Set<Address> addresses = contact.getAddressSet();
            session.saveOrUpdate(contact);
            for (Address address : addresses) {
                session.save(address);
            }
            session.getTransaction().commit();
            return contact.getId();
        } finally {
            assert session != null;
            session.close();
        }
    }

    @Override
    public void deleteContact(int id) {
        Session session = null;
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Contact.class)
                .addAnnotatedClass(PersonData.class)
                .addAnnotatedClass(MedicalCard.class)
                .addAnnotatedClass(Illness.class)
                .buildSessionFactory()) {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Contact contact = session.get(Contact.class, id);
            session.delete(contact);

            session.getTransaction().commit();

        } finally {
            assert session != null;
            session.close();
        }
    }

    @Override
    public List<Contact> getAllContact() {
        Session session = null;
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Contact.class)
                .addAnnotatedClass(PersonData.class)
                .addAnnotatedClass(MedicalCard.class)
                .addAnnotatedClass(Illness.class)
                .buildSessionFactory()) {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Query<Contact> query = session.createQuery("select c from Contact as c");
            List<Contact> contactList = query.getResultList();

            session.getTransaction().commit();
            return contactList;
        } finally {
            assert session != null;
            session.close();
        }
    }
}
