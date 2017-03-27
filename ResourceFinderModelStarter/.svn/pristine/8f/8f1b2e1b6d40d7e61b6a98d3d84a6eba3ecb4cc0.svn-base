package ca.ubc.cs.cpsc210.resourcefinder.tests.model;

import ca.ubc.cs.cpsc210.resourcefinder.model.Resource;
import ca.ubc.cs.cpsc210.resourcefinder.model.Service;
import org.junit.Before;
import org.junit.Test;

import java.time.format.TextStyle;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static ca.ubc.cs.cpsc210.resourcefinder.model.Service.LEGAL;
import static ca.ubc.cs.cpsc210.resourcefinder.model.Service.SHELTER;
import static org.junit.Assert.*;

// unit tests for Resource class
public class ResourceTest {
    private Resource testResource;
    private Set<Service> testSerivces;

    @Before
    public void runBefore() {
        testResource = new Resource("Family Services", null);
        testSerivces = new HashSet<>();
    }

    @Test
    public void testResource() {
        testSerivces.add(Service.LEGAL);
        testSerivces.add(Service.FOOD);
        testSerivces.add(Service.SENIOR);
        assertEquals("Family Services", testResource.getName());
        assertEquals(null, testResource.getContactInfo());
        assertFalse(testResource.offersAllServicesInSet(testSerivces));
        testResource.addService(Service.FOOD);
        testResource.addService(Service.COUNSELLING);
        testResource.addService(Service.SENIOR);
        assertTrue(testResource.offersService(Service.FOOD));
        assertFalse(testResource.offersService(Service.LEGAL));
        testResource.addService(Service.LEGAL);
        assertTrue(testResource.offersAllServicesInSet(testSerivces));
        testSerivces.add(Service.SHELTER);
        assertFalse(testResource.offersAllServicesInSet(testSerivces));
    }

    @Test
    public void testResource1() {
        assertTrue(testResource.offersAllServicesInSet(testSerivces));
        assertFalse(testResource.offersAnyServicesInSet(testSerivces));
        testSerivces.add(Service.LEGAL);
        testResource.addService(Service.LEGAL);
        testResource.addService(Service.COUNSELLING);
        testResource.addService(Service.SHELTER);
        assertTrue(testResource.offersAnyServicesInSet(testSerivces));
        testSerivces.remove(Service.LEGAL);
        testSerivces.add(Service.SENIOR);
        assertFalse(testResource.offersAnyServicesInSet(testSerivces));
        testResource.removeService(Service.LEGAL);
        assertFalse(testResource.offersAnyServicesInSet(testSerivces));
    }
    
    @Test
    public void testResource2() {
        testSerivces.add(Service.LEGAL);
        testSerivces.add(Service.COUNSELLING);
        testResource.addService(Service.LEGAL);
        testResource.addService(Service.COUNSELLING);
        assertEquals(testSerivces, testResource.getServices());
    }

    @Test
    public void testResource3() {
        testResource.addService(Service.LEGAL);
        testResource.addService(Service.COUNSELLING);
        testSerivces.add(Service.LEGAL);
        testSerivces.add(Service.SENIOR);
        assertTrue(testResource.offersAnyServicesInSet(testSerivces));
    }

    @Test
    public void testResource4() {
        testResource.addService(Service.LEGAL);
        testResource.addService(Service.COUNSELLING);
        testSerivces.add(Service.SENIOR);
        assertFalse(testResource.offersAnyServicesInSet(testSerivces));
    }

    @Test
    public void testResource5() {
        testResource.addService(Service.LEGAL);
        testResource.addService(Service.COUNSELLING);
        testSerivces.add(Service.SENIOR);
        assertFalse(testResource.offersAllServicesInSet(testSerivces));
        testResource.addService(Service.SENIOR);
        testSerivces.add(Service.LEGAL);
        testSerivces.add(Service.COUNSELLING);
        assertTrue(testResource.offersAllServicesInSet(testSerivces));
        testResource.removeService(Service.LEGAL);
        assertFalse(testResource.offersAllServicesInSet(testSerivces));
    }
}