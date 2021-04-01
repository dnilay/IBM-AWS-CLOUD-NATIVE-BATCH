package com.example.demo.repo;

import com.example.demo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface TodoRepository extends JpaRepository<Todo,Integer> {


}
