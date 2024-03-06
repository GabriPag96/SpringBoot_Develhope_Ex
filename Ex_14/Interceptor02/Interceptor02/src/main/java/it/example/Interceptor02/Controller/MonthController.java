package it.example.Interceptor02.Controller;

import it.example.Interceptor02.Entity.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/months")
public class MonthController {

    @GetMapping
    public Month getMonthByNumber(HttpServletRequest request){

        return (Month) request.getAttribute("monthNumber");

    }
}
