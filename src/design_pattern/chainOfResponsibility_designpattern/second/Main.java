package design_pattern.chainOfResponsibility_designpattern.second;

public class Main {

    public static void main(String[] args) {
        String msg = "敏感,<script>,:),what the fuck .";

        Request request = new Request();
        Response response = new Response();
        request.setRequestStr(msg);
        response.setResponseStr("");
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new HtmlFilter())
                .addFilter(new FaceFilter())
                .addFilter(new SensitiveFilter());
        filterChain.doFilter(request, response, filterChain);
        System.out.println(request.getRequestStr());
        System.out.println(response.getResponseStr());
    }

}
