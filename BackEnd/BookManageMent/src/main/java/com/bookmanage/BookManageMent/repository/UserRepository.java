package com.bookmanage.BookManageMent.repository;
import com.bookmanage.BookManageMent.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
