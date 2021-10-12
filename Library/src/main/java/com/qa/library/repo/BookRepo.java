package com.qa.library.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.library.Librarian;


@Repository
public interface BookRepo extends JpaRepository<Librarian, Integer>{

		public List<Librarian> findByName(String name);
	}
