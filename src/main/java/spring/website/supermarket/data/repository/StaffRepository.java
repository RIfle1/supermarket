package spring.website.supermarket.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.website.supermarket.data.entity.Staff;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    @Query("select s from Staff s " +
            "where lower(s.staff_fname) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(s.staff_lname) like lower(concat('%', :searchTerm, '%'))")
    List<Staff> searchStaff(@Param("searchTerm") String searchTerm);


}
