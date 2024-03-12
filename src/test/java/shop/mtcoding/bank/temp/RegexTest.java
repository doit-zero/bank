package shop.mtcoding.bank.temp;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

public class RegexTest {

    @Test
    public void 한글만된다_test() throws Exception{
        String value = "한글";
        Boolean result = Pattern.matches("^[가-힝]+$",value); // [가-힝]이 한글만 된다는 정규표현식임
        System.out.println("테스트 : " + result);
    }

    @Test
    public void 한글은안된다_test() throws Exception{
        String value = "123123";
        Boolean result = Pattern.matches("^[^ㄱ-ㅎ가-힝]+$",value);
        System.out.println("테스트 : " + result);
    }

    @Test
    public void 영어만된다_test() throws Exception{
        String value = "ass";
        Boolean result = Pattern.matches("^[a-zA-Z]+$",value); // [가-힝]이 한글만 된다는 정규표현식임
        System.out.println("테스트 : " + result);
    }

    @Test
    public void 영어는안된다_test() throws Exception{
        String value = "121123";
        Boolean result = Pattern.matches("^[^a-zA-Z]+$",value);
        System.out.println("테스트 : " + result);
    }

    @Test
    public void 영어와숫자만된다_test() throws Exception{
        String value = "as11s";
        Boolean result = Pattern.matches("^[a-zA-Z0-9]+$",value);
        System.out.println("테스트 : " + result);
    }

    @Test
    public void 영어만되고_길이는_최소2최대4이다_test() throws Exception{
        String value = "ass2";
        Boolean result = Pattern.matches("^[a-zA-Z]{2,4}+$",value); // [가-힝]이 한글만 된다는 정규표현식임
        System.out.println("테스트 : " + result);
    }
}
