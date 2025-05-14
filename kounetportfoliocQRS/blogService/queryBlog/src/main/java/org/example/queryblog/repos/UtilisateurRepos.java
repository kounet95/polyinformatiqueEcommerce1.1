package org.example.queryblog.repos;

import com.example.polyinformatiquecommon.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepos extends JpaRepository<Customer,String> {

}
