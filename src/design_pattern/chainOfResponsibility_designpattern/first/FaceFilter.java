package design_pattern.chainOfResponsibility_designpattern.first;

public class FaceFilter implements Filter{

    @Override
    public String doFilter(String msg) {
        return msg.replace(":)","^v^");
    }
}
