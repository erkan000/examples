package example.jsf.mb;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Bean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6529592020774759833L;

	public void longThread() throws InterruptedException {
		Thread.sleep(3000);
	}


}
