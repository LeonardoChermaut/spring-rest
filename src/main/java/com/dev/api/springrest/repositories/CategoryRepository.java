package com.dev.api.springrest.repositories;

import com.dev.api.springrest.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{


}