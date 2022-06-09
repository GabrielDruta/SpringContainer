package beans.factory;

import beans.ApplicationContextTest;
import beans.prototype.Prototype;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest extends ApplicationContextTest {

    @Test
    public void testFactory() {
        Factory factory = context.getBean(Factory.class);
        assertNotNull(factory);
    }

    @Test
    public void testProdus() {
        Produs p1 = context.getBean(Produs.class);
        Produs p2 = (Produs) context.getBean("createProdus");

        assertSame(p1, p2);
        assertNotNull(p1);
    }

    @Test
    public void testPrototyp() {
        Prototyp p1 = context.getBean(Prototyp.class);
        Prototyp p2 = (Prototyp) context.getBean("createPrototyp");

        assertNotSame(p1, p2);
        assertNotNull(p1);
    }

//    @Test
//    public void testPrototype() {
//        Prototype p1 = context.getBean(Prototype.class);
//        Prototype p2 = (Prototype) context.getBean("createPrototype");
//
//        assertNotSame(p1, p2);
//        assertNotNull(p1);
//    }


}
