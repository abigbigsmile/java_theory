package design_pattern.chainOfResponsibility_designpattern.second;

public class HtmlFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.setRequestStr(
                request.getRequestStr()
                .replace("<","(")
                .replace(">",")")
        );
        filterChain.doFilter(request, response, filterChain);
        response.setResponseStr(response.getResponseStr() + "HtmlFilter  ");
    }
}
