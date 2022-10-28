package liga.medical.medicalperson.core.dao;

import liga.medical.medicalperson.core.dao.api.AddressRepository;
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

@Repository
public class AddressRepositoryImp implements AddressRepository {
    @Override
    public List<Address> getAllAddresses() {
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

            Query<Address> query = session.createQuery("select a from Address as a");
            List<Address> addressList = query.getResultList();

            session.getTransaction().commit();
            session.close();
            return addressList;

        } finally {
            assert session != null;
            session.close();
        }
    }

    @Override
    public int postAddress(Address address) {
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
            session.saveOrUpdate(address);
            session.getTransaction().commit();
            return address.getId();
        } finally {
            assert session != null;
            session.close();
        }
    }

    @Override
    public void deleteAddress(int id) {
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
            Address address = session.get(Address.class, id);
            session.delete(address);
            session.getTransaction().commit();

        } finally {
            assert session != null;
            session.close();
        }
    }
}
