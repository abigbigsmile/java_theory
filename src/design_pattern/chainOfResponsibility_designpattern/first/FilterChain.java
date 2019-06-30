package design_pattern.chainOfResponsibility_designpattern.first;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter{

    private List<Filter> filters = new ArrayList<>();

    public FilterChain addFilter(Filter filter){
        this.filters.add(filter);
        return this;
    }

    public String doFilter(String msg){
        for(Filter filter : filters){
            msg = filter.doFilter(msg);
        }
        return msg;
    }

}
