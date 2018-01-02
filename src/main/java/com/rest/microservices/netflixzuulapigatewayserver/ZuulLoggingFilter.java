package com.rest.microservices.netflixzuulapigatewayserver;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ZuulLoggingFilter extends ZuulFilter{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// Logic of this filter goes in this method.
	@Override
	public Object run() {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		Date date = new Date();
		logger.info("TIMESTAMP: {}  request: {} URI: {}", date.toString(), request, request.getRequestURI());
		return null;
	}

	// Toggle this filter on/off
	@Override
	public boolean shouldFilter() {
		return true;
	}

	// Sets the order in which Zuul applies filters
	@Override
	public int filterOrder() {
		return 1;
	}

	 /**
     * to classify a filter by type. Standard types in Zuul are "pre" for pre-routing filtering,
     * "route" for routing to an origin, "post" for post-routing filters, "error" for error handling.
     * We also support a "static" type for static responses see  StaticResponseFilter.
     * Any filterType made be created or added and run by calling FilterProcessor.runFilters(type)
     *
     * @return A String representing that type
     */
	@Override
	public String filterType() {
		return "pre";
	}

}
