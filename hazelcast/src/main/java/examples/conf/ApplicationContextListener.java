package examples.conf;

import java.util.logging.Level;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.logging.Logger;


@WebListener
public class ApplicationContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Logger.getLogger(ApplicationContextListener.class).log(Level.INFO, "--------------HAZELCAST INIT START------------");
		
		Hazelcast.getOrCreateHazelcastInstance();
		
		Logger.getLogger(ApplicationContextListener.class).log(Level.INFO, "--------------HAZELCAST INITIALIZED------------");
	}
	

	@Override
	public void contextDestroyed(ServletContextEvent sce) {		
		Hazelcast.getHazelcastInstanceByName("devHz").getLifecycleService().shutdown();
		Logger.getLogger(ApplicationContextListener.class).log(Level.INFO, "--------------HAZELCAST STOPPED------------");
		
	}	
	
//	public static boolean getOS(){
//		OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
//		if(!osBean.getName().startsWith("Windows"))
//			return false;
//		return true;
//	}
//	
//	public static Config getConfig() {
//		Config config = new Config();
//		config.setProperty("hazelcast.logging.type", "log4j");
//		ManagementCenterConfig managementCenterConfig = new ManagementCenterConfig("http://localhost:8090/haz", 1);
//		managementCenterConfig.setEnabled(true);
//		config.setManagementCenterConfig(managementCenterConfig );
//		config.getManagementCenterConfig().setEnabled(true);
//		config.getManagementCenterConfig().setUrl("http://localhost:8090/haz");
//		config.setInstanceName("dev");
//		NetworkConfig network = config.getNetworkConfig();
//		network.setPort(6001);
//		network.setPortAutoIncrement(true);
//		JoinConfig join = network.getJoin();
//		TcpIpConfig tcpIpConfig = join.getTcpIpConfig();
//		tcpIpConfig.addMember("192.168.2.72").setEnabled(true);
//		tcpIpConfig.addMember("192.168.2.86").setEnabled(true);
//		tcpIpConfig.addMember("127.0.0.1").setEnabled(true);
//		join.getMulticastConfig().setEnabled(false);
//        return config;
//	}
}

