package ca.ubc.cs.cpsc210.resourcefinder.tests.model;

import ca.ubc.cs.cpsc210.resourcefinder.model.Resource;
import ca.ubc.cs.cpsc210.resourcefinder.model.ResourceRegistry;
import ca.ubc.cs.cpsc210.resourcefinder.model.SelectionState;
import ca.ubc.cs.cpsc210.resourcefinder.model.Service;
import org.junit.Before;
import org.junit.Test;
import org.junit.validator.PublicClassValidator;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

// unit tests for SelectionState class
public class SelectionStateTest {
    private SelectionState testSelectionState;
    private ResourceRegistry registry;
    private Resource r1;
    private Resource r2;
    private Resource r3;
    private Resource r4;

    @Before
    public void runBefore() {
        registry = new ResourceRegistry();
        loadResources();

        testSelectionState = new SelectionState(registry);
    }

    @Test
    public void testSelectionState() {
        Set<Resource> resourcesset;
        resourcesset = new HashSet<>();
        testSelectionState.selectService(Service.YOUTH);
        testSelectionState.selectService(Service.FOOD);
        testSelectionState.setSelectAll();
        resourcesset.add(r2);
        assertEquals(resourcesset, testSelectionState.getResourcesWithSelectedServices());
        testSelectionState.deselectService(Service.YOUTH);
        resourcesset.add(r1);
        resourcesset.add(r4);
        assertEquals(resourcesset, testSelectionState.getResourcesWithSelectedServices());
        testSelectionState.setSelectAny();
        assertEquals(resourcesset, testSelectionState.getResourcesWithSelectedServices());

    }

    @Test
    public void testSelectionState1() {
        Set<Resource> resourcesset;
        resourcesset = new HashSet<>();
        resourcesset.add(r1);
        resourcesset.add(r2);
        resourcesset.add(r3);
        resourcesset.add(r4);
        assertEquals(resourcesset, testSelectionState.getResourcesWithSelectedServices());
    }

    @Test
    public void testSelectionState2() {
        Set<Service> servicesset;
        servicesset = new HashSet<>();
        Set<Resource> resourcesset;
        resourcesset = new HashSet<>();
        resourcesset.add(r1);
        resourcesset.add(r3);
        resourcesset.add(r4);
        servicesset.add(Service.SENIOR);
        servicesset.add(Service.SHELTER);
        testSelectionState.setSelectedServices(servicesset);
        assertEquals(resourcesset, testSelectionState.getResourcesWithSelectedServices());
    }

//    // MODIFIES: this
//    // EFFECTS:  adds services to resources and resources to resource registry
    private void loadResources() {
        r1 = new Resource("Res 1", null);
        r2 = new Resource("Res 2", null);
        r3 = new Resource("Res 3", null);
        r4 = new Resource("Res 4", null);

        r1.addService(Service.FOOD);
        r1.addService(Service.SHELTER);
        r2.addService(Service.YOUTH);
        r2.addService(Service.FOOD);
        r3.addService(Service.SENIOR);
        r3.addService(Service.COUNSELLING);
        r4.addService(Service.SHELTER);
        r4.addService(Service.FOOD);
        r4.addService(Service.LEGAL);

        registry.addResource(r1);
        registry.addResource(r2);
        registry.addResource(r3);
        registry.addResource(r4);
    }
}