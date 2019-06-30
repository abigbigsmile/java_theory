package design_pattern.chainOfResponsibility_designpattern.first;


//消息过滤器
public class MsgProcessor {

    //待过滤信息
    private String msg;
    //过滤链
    private FilterChain filterChain;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public FilterChain getFilterChain() {
        return filterChain;
    }

    public void setFilterChain(FilterChain filterChain) {
        this.filterChain = filterChain;
    }

    public String process(){
        return filterChain.doFilter(msg);
    }
}
