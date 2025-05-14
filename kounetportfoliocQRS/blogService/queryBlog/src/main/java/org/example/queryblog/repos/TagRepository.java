package org.example.queryblog.repos;
import com.example.polyinformatiquecommon.blog.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, String> {

}
