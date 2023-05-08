package peaksoft.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.CompanyDao;
import peaksoft.entities.Company;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CompanyImpl implements CompanyDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Company> getAllCompanies() {
        List<Company>companies=entityManager.createQuery("FROM Company ",Company.class).getResultList();
        return companies;
    }

    @Override
    public void addCompany(Company company) {
        entityManager.persist(company);


    }

    @Override
    public Company getCompanyById(Long id) {
        Company company=entityManager.find(Company.class,id);
        return company;
    }

    @Override
    public void updateCompany(Long id, Company company) {
        Company company1=getCompanyById(id);
        company1.setCompanyName(company.getCompanyName());
        company1.setLocatedCountry(company.getLocatedCountry());
        entityManager.merge(company1);


    }

    @Override
    public void deleteCompany(Company company) {
        entityManager.remove(entityManager.contains(company)?company:entityManager.merge(company));

    }
}
