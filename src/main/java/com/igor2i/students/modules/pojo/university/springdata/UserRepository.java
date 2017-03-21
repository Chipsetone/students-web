package com.igor2i.students.modules.pojo.university.springdata;

import com.igor2i.students.modules.pojo.university.objects.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Семакин Виктор
 */
public interface UserRepository extends CrudRepository<User, Long>{
}
