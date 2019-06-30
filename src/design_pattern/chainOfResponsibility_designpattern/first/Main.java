package design_pattern.chainOfResponsibility_designpattern.first;

public class Main {

    public static void main(String[] args) {
        String msg = "敏感,<script>,:),what the fuck .";
        System.out.println(msg);
        MsgProcessor msgProcessor = new MsgProcessor();
        msgProcessor.setMsg(msg);
        FilterChain filterChainA = new FilterChain();
        FilterChain filterChainB = new FilterChain();
        filterChainA.addFilter(new HtmlFilter())
                .addFilter(new FaceFilter());
        filterChainB.addFilter(new SensitiveFilter());
        filterChainA.addFilter(filterChainB);
        msgProcessor.setFilterChain(filterChainA);
        msg = msgProcessor.process();
        System.out.println(msg);
    }

}
