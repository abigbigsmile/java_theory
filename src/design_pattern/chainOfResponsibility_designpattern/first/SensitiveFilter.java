package design_pattern.chainOfResponsibility_designpattern.first;

public class SensitiveFilter implements Filter {

    @Override
    public String doFilter(String msg) {
        return msg.replace("敏感","和谐")
                .replace("fuck","f**k");
    }
}
