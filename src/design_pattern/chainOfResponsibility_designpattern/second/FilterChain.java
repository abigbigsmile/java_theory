package design_pattern.chainOfResponsibility_designpattern.second;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {

    //标志执行到第几个filter
    private int index = 0;
    private List<Filter> filters = new ArrayList<>();

    public FilterChain addFilter(Filter filter){
        this.filters.add(filter);
        return this;
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain){
        if(index == filters.size())return;
        Filter filter = filters.get(index);
        index++;
        filter.doFilter(request, response, filterChain);


    }

}
