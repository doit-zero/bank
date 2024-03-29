package shop.mtcoding.bank.domain.transaction;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import shop.mtcoding.bank.domain.account.Account;

import java.time.LocalDateTime;

@NoArgsConstructor // 스프링이 Entity 객체를 생성할 때 빈생성자로 new 를 하기 때문이다.
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "transaction_tb")
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account withdrawAccount;

    @ManyToOne
    private Account depositAccount;

    @Column(nullable = false)
    private Long amount;

    private Long withdrawAccountBalance; // 계좌 출금 후 남은 잔액 내역
    private Long depositAccountBalance; // 계좌에 입금 후 남은 잔액 내역

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) // 데이터베이스 인식할 수 있게 해
    private TransactionEnum gubun; // 출금인지 입금인지 전송인지 확인

    // 계좌가 사라져도 로그는 남아야 함
    private String sender;
    private String receiver;
    private String tel;


    @CreatedDate // Insert 시 날짜가 자동으로 들어감
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate // Insert , Update 할때 날짜가 자동으로 들어감
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public Transaction(Long id, Account withdrawAccount, Account depositAccount, Long amount, Long withdrawAccountBalance, Long depositAccountBalance, TransactionEnum gubun, String sender, String receiver, String tel, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.withdrawAccount = withdrawAccount;
        this.depositAccount = depositAccount;
        this.amount = amount;
        this.withdrawAccountBalance = withdrawAccountBalance;
        this.depositAccountBalance = depositAccountBalance;
        this.gubun = gubun;
        this.sender = sender;
        this.receiver = receiver;
        this.tel = tel;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
