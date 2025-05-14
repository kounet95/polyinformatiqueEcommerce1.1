package org.example.queryblog.repos;


import com.example.polyinformatiquecommon.blog.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, String> {

}
