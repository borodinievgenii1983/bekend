package ru.javabegin.tasklist.backendspringboot.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.javabegin.tasklist.backendspringboot.entity.Task;

// принцип ООП: абстракция-реализация - здесь описываем все доступные способы доступа к данным
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    // учитываем, что параметр может быть null или пустым
    @Query("SELECT p FROM Task p where " +
            "(:title is null or :title='' or lower(p.title) like lower(concat('%', :title,'%'))) and" +
            "(:completed is null or p.completed=:completed) and " +
            "(:priority is null or p.priority.id=:priority) and " +
            "(:category is null or p.category.id=:category)"
    )
    // искать по всем переданным параметрам (пустые параметры учитываться не будут)
    Page<Task> findByParams(@Param("title") String title,
                            @Param("completed") Integer completed,
                            @Param("priority") Long priority,
                            @Param("category") Long category,
                            Pageable pageable
    );



}
