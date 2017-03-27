package ca.ubc.cs.cpsc210.resourcefinder.parser;

import ca.ubc.cs.cpsc210.resourcefinder.model.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

// Handler for XML resource parsing
public class ResourceHandler extends DefaultHandler {
    private ResourceRegistry registry;
    private StringBuilder accumulator;
    private Resource resource;
    private String name;
    private ContactInfo contactInfo;
    private Set<Service> services = new HashSet<>();
    private String address;
    private GeoPoint geoLocation;
    private URL webAddress;
    private String phoneNumber;
    private double lat;
    private double lon;

    // EFFECTS: constructs resource handler for XML parser
    public ResourceHandler(ResourceRegistry registry) {
        this.registry = registry;
        accumulator = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        if(qName.toLowerCase().equals("resource")) {
            name = null;
            address = null;
            lat = 0;
            lon = 0;
            webAddress = null;
            phoneNumber = null;
            services = new HashSet<>();
            contactInfo = null;
            resource = null;
            geoLocation = null;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);

        String data = accumulator.toString().trim();

        if (qName.toLowerCase().equals("name")) {
            name = data;
        }

        if (qName.toLowerCase().equals("address")) {
            address = data;
        }

        if (qName.toLowerCase().equals("lat")) {
            try {
                lat = Double.parseDouble(data);
            } catch (Exception e) {
                throw new SAXException();
            }
        }

        if (qName.toLowerCase().equals("lon")) {
            try {
                lon = Double.parseDouble(data);
            } catch (Exception e) {
                throw new SAXException();
            }
        }

        if (qName.toLowerCase().equals("webaddress")) {
            try {
                webAddress = new URL(data);
            } catch (Exception e) {
                throw new SAXException();
            }
        }

        if (qName.toLowerCase().equals("location")) {
            geoLocation = new GeoPoint(lat, lon);
        }

        if (qName.toLowerCase().equals("phone")) {
            phoneNumber = data;
        }

        if (qName.toLowerCase().equals("service")) {
            switch (data) {
                case "Food":
                    services.add(Service.FOOD);
                    break;
                case "Senior services":
                    services.add(Service.SENIOR);
                    break;
                case "Shelter":
                    services.add(Service.SHELTER);
                    break;
                case "Counselling":
                    services.add(Service.COUNSELLING);
                    break;
                case "Youth services":
                    services.add(Service.YOUTH);
                    break;
                case "Legal advice":
                    services.add(Service.LEGAL);
                    break;
            }
        }

        if (qName.toLowerCase().equals("resource")) {

            if (name != null && address != null && geoLocation != null && webAddress != null && phoneNumber != null && services.size() != 0) {

                contactInfo = new ContactInfo(address, geoLocation, webAddress, phoneNumber);

                resource = new Resource(name, contactInfo);

                for (Service item : services) {
                    resource.addService(item);
                }

                registry.addResource(resource);
            }
        }

        if (qName.toLowerCase().equals("resource")) {
            if (registry.getResources().size() == 0) {
                throw new SAXException();
            }
        }

        accumulator.setLength(0);

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        accumulator.append(ch, start, length);
    }
}
