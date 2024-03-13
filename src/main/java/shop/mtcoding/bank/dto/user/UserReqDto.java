package shop.mtcoding.bank.dto.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import shop.mtcoding.bank.domain.user.User;
import shop.mtcoding.bank.domain.user.UserEnum;

@Getter
public class UserReqDto {
    @Setter
    @Getter
    public static class JoinReqDto{
        // 유효성 검사

        // 영문과 숫자 길이 최소 2~20자 이내
        @Pattern(regexp = "", message = "영문/숫자 2~20자 이내로 작성해주세요")
        @NotEmpty
        private String username;

        // 길이 4~20
        @NotEmpty
        private String password;

        // 이메일 형식이여야함
        @NotEmpty
        private String email;

        // 영어,한글, 1~20 자
        @NotEmpty
        private String fullname;

        public User toEntity(BCryptPasswordEncoder bCryptPasswordEncoder){
            return User.builder()
                    .username(username)
                    .password(bCryptPasswordEncoder.encode(password))
                    .email(email)
                    .fullname(fullname)
                    .role(UserEnum.CUSTOMER)
                    .build();
        }

    }
}
