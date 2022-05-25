package spring.website.supermarket.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.website.supermarket.data.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u " +
            "where lower(u.user_fname) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(u.user_lname) like lower(concat('%', :searchTerm, '%'))")
    List<User> searchUser(@Param("searchTerm") String searchTerm);


}
