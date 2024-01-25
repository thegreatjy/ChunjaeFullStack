package kr.co.chunjae.startspringboot.controller;

import kr.co.chunjae.startspringboot.service.StatisticService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.TimeoutException;

@Controller
@RequestMapping("statistics")
@RequiredArgsConstructor
@Slf4j
@ControllerAdvice
@Log4j2
public class StatisticController {
    StatisticService statisticService;

    @GetMapping("exc_in_controller")
    public void controllerException() {
        throw new NullPointerException(); // controller에서 NullPointerException 예외발생 -> @ExceptionHandler(value = NullPointerException.class) 선언된 메서드에서 처리된다.
    }

    @GetMapping("exc_in_service")
    public void serviceException() {
            statisticService.makeException(); // service에서 ArrayIndexOutOfBoundsException 예외발생 -> 결국 컨트롤러에서 예외 발생된 것과 동일
    }

    @GetMapping("exc_in_repository")
    public void repositoryException() {
        statisticService.makeExceptionInRepository(); // service->repository에서 throws로 ArrayIndexOutOfBoundsException 예외발생  -> 결국 컨트롤러에서 예외 발생된 것과 동일
    }

    @GetMapping("check/exception/null")
    @ExceptionHandler(value = NullPointerException.class)
    public String nullException() throws Exception{
        // ...
        return "error/null";
    }

    @GetMapping("check/exception/oob")
    @ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)
    public String oobException() throws Exception{
        // ...
        log.warn("oob oob");
        return "error/oob";
    }

    @GetMapping("check/time-out")
    @ExceptionHandler(value = TimeoutException.class)
    public String notFoundException() throws Exception{
        // ...
        return "error/timeoutException";
    }
}
