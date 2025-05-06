package org.example.commandeblog;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.example.polyinformatiquecoreapi.commands.*;
import org.example.polyinformatiquecoreapi.dto.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class CommandeBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommandeBlogApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CommandGateway commandGateway) {
        return args -> {
            System.out.println("Starting to create sample data...");

            // Create Tags
            List<String> tagIds = new ArrayList<>();
            String tagId1 = UUID.randomUUID().toString();
            String tagId2 = UUID.randomUUID().toString();
            String tagId3 = UUID.randomUUID().toString();

            tagIds.add(tagId1);
            tagIds.add(tagId2);
            tagIds.add(tagId3);

            commandGateway.send(new CreateTagCommand(tagId1, new TagDTO(tagId1, "Technology", new ArrayList<>())));
            commandGateway.send(new CreateTagCommand(tagId2, new TagDTO(tagId2, "Programming", new ArrayList<>())));
            commandGateway.send(new CreateTagCommand(tagId3, new TagDTO(tagId3, "Web Development", new ArrayList<>())));

            System.out.println("Tags created successfully");

            // Create Domains (Categories)
            List<String> domainIds = new ArrayList<>();
            String domainId1 = UUID.randomUUID().toString();
            String domainId2 = UUID.randomUUID().toString();

            domainIds.add(domainId1);
            domainIds.add(domainId2);

            commandGateway.send(new CreateCategoryCommand(domainId1, new DomainDTO(domainId1, "Software Development", new ArrayList<>())));
            commandGateway.send(new CreateCategoryCommand(domainId2, new DomainDTO(domainId2, "Data Science", new ArrayList<>())));

            System.out.println("Domains created successfully");

            // Create Authors
            List<String> authorIds = new ArrayList<>();
            String authorId1 = UUID.randomUUID().toString();
            String authorId2 = UUID.randomUUID().toString();

            authorIds.add(authorId1);
            authorIds.add(authorId2);

            commandGateway.send(new CreateAuthorCommand(authorId1, new AuthorDTO(
                    authorId1,
                    "johndoe",
                    "john.doe@example.com",
                    "John Doe",
                    "+1234567890",
                    "123 Main St, City",
                    new ArrayList<>(),
                    new ArrayList<>()
            )));

            commandGateway.send(new CreateAuthorCommand(authorId2, new AuthorDTO(
                    authorId2,
                    "janedoe",
                    "jane.doe@example.com",
                    "Jane Doe",
                    "+0987654321",
                    "456 Oak St, Town",
                    new ArrayList<>(),
                    new ArrayList<>()
            )));

            System.out.println("Authors created successfully");

            // Create Articles
            String articleId1 = UUID.randomUUID().toString();
            String articleId2 = UUID.randomUUID().toString();

            List<String> articleTagIds1 = new ArrayList<>();
            articleTagIds1.add(tagId1);
            articleTagIds1.add(tagId2);

            List<String> articleTagIds2 = new ArrayList<>();
            articleTagIds2.add(tagId2);
            articleTagIds2.add(tagId3);

            commandGateway.send(new CreatePostCommand(articleId1, new ArticleDTO(
                    articleId1,
                    "This is the content of the first article about Java programming.",
                    "https://example.com/images/java.jpg",
                    "Introduction to Java Programming",
                    LocalDate.now(),
                    authorId1,
                    domainId1,
                    articleTagIds1,
                    new ArrayList<>()
            )));

            commandGateway.send(new CreatePostCommand(articleId2, new ArticleDTO(
                    articleId2,
                    "This is the content of the second article about web development with Spring Boot.",
                    "https://example.com/images/spring.jpg",
                    "Building Web Applications with Spring Boot",
                    LocalDate.now().minusDays(2),
                    authorId2,
                    domainId1,
                    articleTagIds2,
                    new ArrayList<>()
            )));

            System.out.println("Articles created successfully");

            // Create News
            String newsId1 = UUID.randomUUID().toString();

            List<String> newsTagIds = new ArrayList<>();
            newsTagIds.add(tagId1);

            commandGateway.send(new CreateNewsCommand(newsId1, new NewsDTO(
                    newsId1,
                    "Summary of the latest technology news",
                    "Detailed content about the latest technology trends and innovations.",
                    "https://example.com/images/tech-news.jpg",
                    "Latest Technology Trends",
                    LocalDate.now().minusDays(1),
                    authorId1,
                    domainId1,
                    newsTagIds,
                    new ArrayList<>()
            )));

            System.out.println("News created successfully");

            // Create Events
            String eventId1 = UUID.randomUUID().toString();

            List<String> eventTagIds = new ArrayList<>();
            eventTagIds.add(tagId3);

            commandGateway.send(new CreateEventCommand(eventId1, new EventDTO(
                    eventId1,
                    "Conference Center, New York",
                    LocalDateTime.now().plusMonths(1),
                    LocalDateTime.now().plusMonths(1).plusDays(3),
                    "Join us for the annual web development conference featuring top speakers and workshops.",
                    "https://example.com/images/webconf.jpg",
                    "Web Development Conference 2023",
                    LocalDate.now(),
                    authorId2,
                    domainId1,
                    eventTagIds,
                    new ArrayList<>()
            )));

            System.out.println("Events created successfully");

            // Create Comments
            String commentId1 = UUID.randomUUID().toString();
            String commentId2 = UUID.randomUUID().toString();

            commandGateway.send(new AddCommentCommand(commentId1, new CommentDTO(
                    commentId1,
                    "Great article! Very informative.",
                    LocalDate.now(),
                    authorId2,
                    articleId1
            )));

            commandGateway.send(new AddCommentCommand(commentId2, new CommentDTO(
                    commentId2,
                    "Looking forward to the event!",
                    LocalDate.now(),
                    authorId1,
                    eventId1
            )));

            System.out.println("Comments created successfully");
            System.out.println("All sample data created successfully!");
        };
    }
}
