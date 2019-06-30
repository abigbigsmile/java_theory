package design_pattern.chainOfResponsibility_designpattern.second;

public class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.setRequestStr(
                request.getRequestStr()
                        .replace("敏感","和谐")
                        .replace("fuck","f**k")
        );
        filterChain.doFilter(request, response, filterChain);
        response.setResponseStr(response.getResponseStr() + "HtmlFilter  ");
    }
}
