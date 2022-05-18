package spring.website.supermaket.data.repository;

import spring.website.supermaket.data.entity.Company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
