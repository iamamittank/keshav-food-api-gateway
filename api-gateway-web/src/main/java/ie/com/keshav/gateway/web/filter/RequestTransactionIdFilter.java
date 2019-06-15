package ie.com.keshav.gateway.web.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Amit Tank
 */
@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestTransactionIdFilter extends GenericFilterBean {

    private static final String TRANSACTION_ID_HEADER = "TRANSACTION_ID";
    private static final String REQUEST_ID_HEADER = "request-id";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        try {
            String transactionId = request.getHeader(TRANSACTION_ID_HEADER);
            if(StringUtils.isEmpty(transactionId)) {
                log.debug("Generating a unique ID for the received request to requested URI '{}'.", request.getRequestURI());
                transactionId = UUID.randomUUID().toString();
            }
            MDC.put(TRANSACTION_ID_HEADER, transactionId);
            log.debug("Transaction ID is set to '{}'.", transactionId);
            ((HttpServletResponse) servletResponse).setHeader(REQUEST_ID_HEADER, transactionId);
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            log.debug("Clearing transaction ID '{}' from the log.", MDC.get(TRANSACTION_ID_HEADER));
            MDC.remove(TRANSACTION_ID_HEADER);
        }

    }
}
