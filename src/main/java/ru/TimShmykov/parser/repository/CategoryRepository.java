package ru.TimShmykov.parser.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.TimShmykov.parser.model.Category;


@Repository
public interface CategoryRepository extends CrudRepository <Category, Long> {



}
