package com.mylan.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class SetCharacterEncodingFilter
 */
@WebFilter(dispatcherTypes = {
		DispatcherType.REQUEST, 
		DispatcherType.FORWARD, 
		DispatcherType.INCLUDE, 
		DispatcherType.ERROR
}
			, urlPatterns = { "/*" })
public class SetCharacterEncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SetCharacterEncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest  request;
        HttpServletResponse response;
        try {
            request = (HttpServletRequest) req;
            response = (HttpServletResponse) res;
        } catch (ClassCastException e) {
            throw new ServletException("non-HTTP request or response");
        }
        String encoding = filterConfig.getInitParameter("encoding");
        if(encoding==null){
        	encoding = "UTF-8";
        }
        
        //POST:
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset="+encoding);
		chain.doFilter(request, response);
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	private FilterConfig filterConfig;
	
	public void init(FilterConfig filterConfig) throws ServletException {
	
		this.filterConfig = filterConfig;
		
	}

}
