package moke.mokeprojectone.controller;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Controller
public class SessionController {

    public static final String Session_UserId = "userId";

    public Map<String, Object> session = new ConcurrentHashMap<>();

    public void createSession(Object value, HttpServletResponse response){
        String sessionId = UUID.randomUUID().toString();
        session.put(sessionId, value);

        Cookie userSession = new Cookie(Session_UserId, sessionId);
        response.addCookie(userSession);
    }

    public Object getSession(HttpServletRequest request){
        Cookie sessionCookie = findCookie(request, Session_UserId);
        if(sessionCookie == null){
            return null;
        }
        return session.get(sessionCookie.getValue());
    }

    public void expired(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request, Session_UserId);
        if (sessionCookie != null){
            session.remove(sessionCookie.getValue());
        }
    }

    public Cookie findCookie(HttpServletRequest request, String cookieName){
        if (request.getCookies() == null) {
            return null;
        }
        return Arrays.stream(request.getCookies())
                .filter(cookie -> cookie.getName().equals(cookieName))
                .findAny()
                .orElse(null);
    }
}
