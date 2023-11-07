package exception02;

import java.io.IOException;

public class AutoCloseObj implements AutoCloseable{

	@Override
	public void close() throws java.lang.Exception {
	   System.out.println("close()");
		
	}

	


}
