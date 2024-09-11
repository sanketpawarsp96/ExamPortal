package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Contents;

public interface ContentRepository extends JpaRepository<Contents, Integer> {

}
