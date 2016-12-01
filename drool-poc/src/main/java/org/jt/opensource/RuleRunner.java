package org.jt.opensource;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.definition.KnowledgePackage;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;
import org.jt.opensource.bean.RuleBean;

public class RuleRunner {  
    private static final String RULES_FILE="/rules/complex-rule.drl";  
    public void runRules(Object[] facts){  
    	System.setProperty("drools.dateformat","yyyy-MM-dd"); 
    	    long start = System.currentTimeMillis();
            KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();  
            KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();  
            System.out.println( "Loading file: " + RULES_FILE );  
            kbuilder.add( ResourceFactory.newClassPathResource( RULES_FILE,RuleRunner.class ),ResourceType.DRL );
           
         //   kbuilder.add(ResourceFactory.newFileResource(file), arg1);
            if (kbuilder.hasErrors() ) {  
            	print( kbuilder.getErrors());
                throw new RuntimeException("charge.drl is a invalid rule file!");  
            }  
            Collection<KnowledgePackage> pkgs = kbuilder.getKnowledgePackages();  
           
            kbase.addKnowledgePackages( pkgs );  
            StatelessKnowledgeSession  ksession = kbase.newStatelessKnowledgeSession();  
            
            System.out.println("it take " +(System.currentTimeMillis() - start) + " ms to initialized ");
            
            for ( int i = 0; i < facts.length; i++ ) {  
                //Object fact = facts[i];  
                start = System.currentTimeMillis();
                RuleBean fact = new RuleBean();
                if (facts[i] == "jack")
                fact.setAmount(0.2);
                else fact.setAmount(333);
                fact.setDate(new Date());
                
                System.out.println( "Inserting fact: " + fact );  
            //    ksession.insert( fact );  
               // ksession.fireAllRules();  
               ksession.execute(fact);
               System.out.println("the amount after execute:"+ fact.getAmount());
               System.out.println("it take " +(System.currentTimeMillis() - start) + " ms to process one object ");
               
            }  
            
           
           
        }  
    
    private void print(KnowledgeBuilderErrors errors) {
    	
    Iterator<KnowledgeBuilderError> it = errors.iterator();
    
    while (it.hasNext()) {
    	System.out.println(it.next());
    }
    
    	
    }
    public static void main(String arg[]) {
    	RuleRunner runner  = new RuleRunner();
    	runner.runRules(new String[]{"jack","solon"});
    }
   
}
