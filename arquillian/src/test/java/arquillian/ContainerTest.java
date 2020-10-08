package arquillian;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import services.DbService;
import services.StartupService;
import services.UserService;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class ContainerTest {

    @Inject
    private UserService userService;
    
    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
                .addClass(UserService.class)
                .addClass(DbService.class)
                .addClass(StartupService.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(jar.toString(true));
        return jar;
    }

    @Test
    public void testContainer() {
       Assert.assertEquals("Test User" , userService.getUser());
    }
}
