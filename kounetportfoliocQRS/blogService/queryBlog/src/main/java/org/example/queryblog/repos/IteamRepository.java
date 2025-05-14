package org.example.queryblog.repos;



import com.example.polyinformatiquecommon.blog.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IteamRepository extends JpaRepository<Item,String> {
}
