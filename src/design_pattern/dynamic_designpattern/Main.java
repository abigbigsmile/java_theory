package design_pattern.dynamic_designpattern;


public class Main {

    public static void main(String[] args) throws Exception{
 //       Runnable cat = new Cat();
//        CatTimeExtendProxy catTiimeExtendProxy = new CatTimeExtendProxy();
//        CatLogPolymerizationProxy catLogPolymerizationProxy = new CatLogPolymerizationProxy(cat);
//        CatTimePolymerizationProxy catTimePolymerizationProxy = new CatTimePolymerizationProxy(catLogPolymerizationProxy);
//        cat.run();
//        catTiimeExtendProxy.run();
//        catTimePolymerizationProxy.run();
//        catLogPolymerizationProxy.run();
//        InnovationHandler innovationHandler = new TimeInnovationHandler(cat);
//        Runnable catTimePolymerizationProxy = (Runnable) Proxy.newProxyInstance(Runnable.class, innovationHandler);
//        catTimePolymerizationProxy.run();

        Transactable transactable = new TransactionPrepare();
        InnovationHandler transactionInnovationHandler = new TransactionInnovationHandler(transactable);
        Transactable transactionPrepareProxy = (Transactable)Proxy.newProxyInstance(Transactable.class,transactionInnovationHandler);
        transactionPrepareProxy.saveSomething();


    }
}
