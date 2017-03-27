package ca.ubc.cs.cpsc210.resourcefinder.model;


import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

// Registry of available resources
public class ResourceRegistry {
    private List<Resource> resources;

    // EFFECTS: constructs empty resource registry
    public ResourceRegistry() {
        resources = new LinkedList<>();
    }

    // MODIFIES: this
    // EFFECTS: add resource to registry, maintains resources in the order added to registry
    public void addResource(Resource resource) {
        resources.add(resource);
    }

    // EFFECTS: returns resources in registry as unmodifiable list (in order that they were added
    // to registry)
    public List<Resource> getResources() {
        return Collections.unmodifiableList(resources);
    }

    // EFFECTS: returns set of resources in registry that offer the given service
    public Set<Resource> getResourcesOfferingService(Service service) {
        Set<Resource> resourcesset;
        resourcesset = new HashSet<>();
        for (Resource item : resources) {
            if (item.offersService(service)) {
                resourcesset.add(item);
            }
        }
        return resourcesset;
    }

    // EFFECTS: returns set of resources in registry that offer all the services in requestedServices set
    public Set<Resource> getResourcesOfferingAllServicesInSet(Set<Service> requestedServices) {
        Set<Resource> resourcesset;
        resourcesset = new HashSet<>();
        for (Resource item : resources) {
            if (item.offersAllServicesInSet(requestedServices)) {
                resourcesset.add(item);
            }
        }
        return resourcesset;
    }

    // EFFECTS: returns set of resources in registry that off any of the services in requestedServices set
    public Set<Resource> getResourcesOfferingAnyServicesInSet(Set<Service> requestedServices) {
        Set<Resource> resourcesset;
        resourcesset = new HashSet<>();
        for (Resource item : resources) {
            if (item.offersAnyServicesInSet(requestedServices)) {
                resourcesset.add(item);
            }
        }
        return resourcesset;
    }
}
