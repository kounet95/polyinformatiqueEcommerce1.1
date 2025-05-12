package org.example.queryblog;

import org.example.queryblog.entite.Domain;
import org.example.queryblog.entite.Tag;
import org.example.queryblog.entite.Utilisateurs;
import org.example.queryblog.repos.DomainRepository;
import org.example.queryblog.repos.TagRepository;
import org.example.queryblog.repos.UtilisateurRepos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.UUID;

@SpringBootApplication
public class QueryBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueryBlogApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            DomainRepository domainRepository,
            TagRepository tagRepository,
            UtilisateurRepos utilisateurRepos
    ) {
        return args -> {
            System.out.println("Initializing query-side database...");


            String tagId1 = "tag-1";
            String tagId2 = "tag-2";
            String tagId3 = "tag-3";


            if (!tagRepository.existsById(tagId1)) {
                Tag tag1 = Tag.builder()
                        .id(tagId1)
                        .name("Technology")
                        .tag_items(new ArrayList<>())
                        .build();
                tagRepository.save(tag1);
            }

            if (!tagRepository.existsById(tagId2)) {
                Tag tag2 = Tag.builder()
                        .id(tagId2)
                        .name("Programming")
                        .tag_items(new ArrayList<>())
                        .build();
                tagRepository.save(tag2);
            }

            if (!tagRepository.existsById(tagId3)) {
                Tag tag3 = Tag.builder()
                        .id(tagId3)
                        .name("Web Development")
                        .tag_items(new ArrayList<>())
                        .build();
                tagRepository.save(tag3);
            }

            System.out.println("Tags created successfully");


            String domainId1 = "domain-1";
            String domainId2 = "domain-2";


            if (!domainRepository.existsById(domainId1)) {
                Domain domain1 = Domain.builder()
                        .id(domainId1)
                        .name("Software Development")
                        .description("Software Development domain")
                        .tag_id(tagId1)
                        .articles(new ArrayList<>())
                        .build();
                domainRepository.save(domain1);
            }

            if (!domainRepository.existsById(domainId2)) {
                Domain domain2 = Domain.builder()
                        .id(domainId2)
                        .name("Data Science")
                        .description("Data Science domain")
                        .tag_id(tagId2)
                        .articles(new ArrayList<>())
                        .build();
                domainRepository.save(domain2);
            }

            System.out.println("Domains created successfully");


            String authorId1 = "author-1";
            String authorId2 = "author-2";


            if (!utilisateurRepos.existsById(authorId1)) {
                Utilisateurs author1 = Utilisateurs.builder()
                        .id(authorId1)
                        .username("johndoe")
                        .email("john.doe@example.com")
                        .name("John Doe")
                        .phone("+1234567890")
                        .address("123 Main St, City")
                        .commentList(new ArrayList<>())
                        .items(new ArrayList<>())
                        .build();
                utilisateurRepos.save(author1);
            }

            if (!utilisateurRepos.existsById(authorId2)) {
                Utilisateurs author2 = Utilisateurs.builder()
                        .id(authorId2)
                        .username("janedoe")
                        .email("jane.doe@example.com")
                        .name("Jane Doe")
                        .phone("+0987654321")
                        .address("456 Oak St, Town")
                        .commentList(new ArrayList<>())
                        .items(new ArrayList<>())
                        .build();
                utilisateurRepos.save(author2);
            }

            System.out.println("Authors created successfully");
            System.out.println("Query-side database initialization completed!");
        };
    }
}
