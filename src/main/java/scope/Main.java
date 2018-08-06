package scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context 
		= new AnnotationConfigApplicationContext(ScopeConfig.class);
		SingleService s1 = context.getBean(SingleService.class);
		SingleService s2 = context.getBean(SingleService.class);
		PrototypeService p1 = context.getBean(PrototypeService.class);
		PrototypeService p2 = context.getBean(PrototypeService.class);
		
		System.out.println("s1==s2:"+s1.equals(s2));
		System.out.println("p1==p2:"+p1.equals(p2));
		
		context.close();
	}

}
