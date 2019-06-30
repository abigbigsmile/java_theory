package design_pattern.chainOfResponsibility_designpattern.first;

public class HtmlFilter implements Filter{

    @Override
    public String doFilter(String msg) {
        return msg.replace("<","(")
                .replace(">",")");
    }
}
