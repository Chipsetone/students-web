package com.igor2i.students.modules.pojo.university.springdata;

import com.igor2i.students.modules.pojo.university.objects.Lection;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Семакин Виктор
 */
public interface LectionRepository extends CrudRepository<Lection, Long> {
}
