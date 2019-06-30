package design_pattern.chainOfResponsibility_designpattern.second;

public interface Filter {

    public void doFilter(Request request, Response response, FilterChain filterChain);
}
