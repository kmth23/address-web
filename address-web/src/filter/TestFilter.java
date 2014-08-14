package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName="WebFilterTest", urlPatterns={"/test"}, initParams={@WebInitParam(name="encoding", value="Windows-31J")})
public class TestFilter implements Filter {

	private String encoding = null;

	@Override
    public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
	}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;");

    	chain.doFilter(request, response);
    }

	@Override
    public void destroy() {
    }

}
