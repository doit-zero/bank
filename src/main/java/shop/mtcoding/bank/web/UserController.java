package shop.mtcoding.bank.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.bank.dto.ResponseDto;
import shop.mtcoding.bank.dto.user.UserReqDto;
import shop.mtcoding.bank.dto.user.UserRespDto;
import shop.mtcoding.bank.service.UserService;

import java.util.HashMap;
import java.util.Map;


// 컨트롤러는 자신의 책임인 유효성 검사를 확실하게 해야한다.
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody @Valid UserReqDto.JoinReqDto joinReqDto, BindingResult bindingResult){
        UserRespDto.JoinRespDto joinRespDto = userService.회원가입(joinReqDto);
       return new ResponseEntity<>(new ResponseDto<>(1,"회원가입 성공",joinRespDto), HttpStatus.CREATED);
    }
}
