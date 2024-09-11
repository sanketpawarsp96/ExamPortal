package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Student_details;

public interface Student_detailsRepository extends JpaRepository<Student_details, Integer> {

}
