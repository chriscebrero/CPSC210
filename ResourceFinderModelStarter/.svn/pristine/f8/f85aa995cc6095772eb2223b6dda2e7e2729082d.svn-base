package ca.ubc.cs.cpsc210.resourcefinder.model;

import java.util.*;

// Represents a resource in the social services sector
public class Resource {
    private String name;
    private ContactInfo contactInfo;
    private Set<Service> services;

    // EFFECTS: constructs resource with given name and contact information
    public Resource(String name, ContactInfo contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.services = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    // EFFECTS: returns true if this resource offers the given service
    public boolean offersService(Service service) {
        if (services.contains(service)) {
            return true;
        }
        return false;
    }

    // EFFECTS: returns true if this resource offers all services in the requestedServices set; false otherwise
    //          (returns true if given the empty set)
    public boolean offersAllServicesInSet(Set<Service> requestedServices) {
        if (requestedServices.isEmpty()) {
            return true;
        }
        if (services.containsAll(requestedServices)) {
            return true;
        }
        else
            return false;
    }

    // EFFECTS: returns true if this resources offers any of the services in requestedServices set; false otherwise
    //          (returns false if given the empty set)
    public boolean offersAnyServicesInSet(Set<Service> requestedServices) {
        if (requestedServices.isEmpty()) {
            return false;
        }
        for (Service item : requestedServices) {
            if (services.contains(item)) {
                return true;
            }
        }
        return false;
    }

    // MODIFIES: this
    // EFFECTS: adds service to this resource, if it's not already added
    public void addService(Service service) {
            services.add(service);
    }

    // MODIFIES: this
    // EFFECTS: removes service from this resource
    public void removeService(Service service) {
        services.remove(service);
    }

    // EFFECTS: returns services offered by this resource as unmodifiable set
    public Set<Service> getServices() {
        return Collections.unmodifiableSet(services);
    }
}
