package com.dudu.gamebounty.common.context;

import com.dudu.gamebounty.core.common.enums.Language;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


@Getter
@RequestScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class RequestContext {

    private final Language language;

    public RequestContext(HttpServletRequest request) {
        this.language = Language.from(request.getHeader("Accept-Language"));
    }
}
