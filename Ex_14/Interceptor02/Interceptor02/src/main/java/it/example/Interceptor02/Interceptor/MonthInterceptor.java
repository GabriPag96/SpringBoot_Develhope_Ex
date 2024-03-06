package it.example.Interceptor02.Interceptor;


import it.example.Interceptor02.Entity.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    private final List<Month> months = new ArrayList<>(); ;

    public MonthInterceptor()
    {

        months.add(new Month(1,"January", "Gennaio", "Januar"));
        months.add(new Month(2,"February", "Febbraio", "dsafaf"));
        months.add(new Month(3,"March", "Marzo", "dhghdh"));
        months.add(new Month(4,"April", "Aprile", "vxcbsh"));
        months.add(new Month(5,"May", "Maggio", "Mein Kampf"));
        months.add(new Month(6,"June", "Giugno", "jhkjkgj"));

    }

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String headRequest = request.getHeader("monthNumber");

        if (headRequest == null ||  headRequest.isEmpty()){

            response.sendError(HttpServletResponse.SC_BAD_REQUEST,"not absent");
            return false;

        }else {

            for (Month month : months){

                if (month.getMonthNumber() == Integer.parseInt(headRequest)){

                    request.setAttribute("monthNumber",month);
                    return true;
                }
            }
            Month emptyMonth = new Month(0, "nope", "nope", "nope");
            request.setAttribute("monthNumber",emptyMonth);
            return true;
        }
    }

    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                @Nullable Exception ex) throws Exception {
    }
}
