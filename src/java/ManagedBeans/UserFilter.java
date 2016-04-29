package ManagedBeans;

import domen.Lekar;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dragana
 */
public class UserFilter implements Filter {
 private FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config=filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Lekar lekar = (Lekar) req.getSession().getAttribute("lekar");
        String uri = req.getRequestURI();

        if (lekar == null) {
            if (uri.indexOf("logovanje.xhtml") <= 0) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/logovanje.xhtml");
            } else {
                chain.doFilter(request, response);

            }
        } else {
            if (uri.indexOf("logovanje.xhtml") >= 0) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/pocetna.xhtml");
            }
            else{
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {
        config=null;
    }

}
