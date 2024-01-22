package kr.co.chunjae;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoggerController {
    public static Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @GetMapping("/logger01")
    public String requestMethod(Model model){
        logger.trace("trace 메세지");
        logger.debug("debug mgs");
        logger.info("info msg");
        logger.warn("warn msg");
        logger.error("error msg");
        return "webpage11_01";
    }
}
