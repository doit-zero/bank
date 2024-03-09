package shop.mtcoding.bank.domain.user;

import java.time.LocalDateTime;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 스프링이 User 객체 생성할 때 빈생성자로 new 를 하기 때문이다.
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user_tb")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 20)
    private String username;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(nullable = false, length = 20)
    private String email;

    @Column(nullable = false, length = 20)
    private String fullname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserEnum role;

    @CreatedDate // Insert 시 날짜가 자동으로 들어감
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate // Insert , Update 할때 날짜가 자동으로 들어감
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public User(Long id, String username, String password, String email, String fullname, UserEnum role,
            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
