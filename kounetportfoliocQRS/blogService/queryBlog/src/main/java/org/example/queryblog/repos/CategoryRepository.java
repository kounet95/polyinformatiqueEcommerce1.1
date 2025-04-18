package org.example.queryblog.repos;

import org.example.queryblog.entite.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {

}
