# Junit Bank App

### Jpa LocalDateTime 자동으로 생성하는 법

- @EnableJpaAuditing ( Main 클래스에)
- @EntityListeners(AuditingEntityListener.class) (Entity 클래스)

```java
  @CreatedDate // Insert 시 날짜가 자동으로 들어감
  @Column(nullable = false)
  private LocalDateTime createdAt;@LastModifiedDate // Insert , Update 할때 날짜가 자동으로 들어감
  @Column(nullable = false)
  private LocalDateTime updatedAt;
```
