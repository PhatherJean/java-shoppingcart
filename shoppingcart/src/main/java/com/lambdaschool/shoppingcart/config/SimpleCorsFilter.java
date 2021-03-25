package com.lambdaschool.shoppingcart.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Filter;


@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCorsFilter implements Filter
{
    @Override
    public void doFilter(
            ServletRequest servreq,
            ServletResponse servresp,
            FilterChain filterChain)
            throws
            IOException,
            ServletException{
        HttpServletResponse resp = (HttpServletResponse) servresp;
        HttpServletRequest req = (HttpServletRequest) servreq;

        resp.setHeader("Access-Control-Allow-Origin",
                "*");

        resp.setHeader("Access-Control-Allowed-Methods",
                "*");

        resp.setHeader("Access-Control-Allow-Headers", "*");

        resp.setHeader("Access-Control-Max-Age", "3600");

        if (HttpMethod.OPTIONS.name()
                .equalsIgnoreCase(req.getMethod()))
        {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else
            {
            filterChain.doFilter(servreq, servresp);
        }
    }
}


