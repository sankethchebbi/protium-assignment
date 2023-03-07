package com.example.sanketh.repository;

import com.example.sanketh.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Student, String>
{
}