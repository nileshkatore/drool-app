package drools.drools;


import org.kie.api.io.Resource;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

import com.baeldung.drools.config.DroolsBeanFactory;
import com.baeldung.drools.model.Customer;
import com.baeldung.drools.model.Customer.CustomerType;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	App app = new App();
    	app.test();
    }
    
    private void test(){
        System.out.println( "Hello World!" );
        Resource resource = ResourceFactory.newClassPathResource("com/baeldung/drools/rules/Discount.xls", getClass());
        KieSession kSession = new DroolsBeanFactory().getKieSession(resource);
        Customer customer = new Customer(CustomerType.INDIVIDUAL, 5);
        kSession.insert(customer);
        System.out.println( "customer.getDiscount() - " + customer.getDiscount() );

        kSession.fireAllRules();
        System.out.println( "customer.getDiscount() - " + customer.getDiscount() );
    	
    }
    
}
