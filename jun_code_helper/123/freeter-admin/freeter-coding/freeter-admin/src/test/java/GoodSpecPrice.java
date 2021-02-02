import org.junit.Test;

public class GoodSpecPrice {

	private Long goodId;
	private long goodspecId;
	
	   @Test
	    public void test() {
	    	String domain = "http://img.cnadmart.com";
	    	String filePath = "http://img.cnadmart.com/20180605/957802b4507d4cd1a963f6f9b4183ce2.png";
	    	String fileName = filePath.substring(domain.length()+1);
	    	System.out.println(fileName);
	    }
	    
 }
