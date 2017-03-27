package ca.ubc.cs.cpsc210.invoicemanager.model;

/**
 * Created by Dante on 2016-10-24.
 */
public class EmergencyServiceRecord extends AbstractServiceRecord {
    public static int EMERG_CALLOUT = 150;
    public static int EMERG_SERVICE_HOURLY = 100;
    public static int EMERG_SERVICEPTS_BASE = 0;
    public static int EMERG_SERVICEPTS_HOURLY = 0;

    public EmergencyServiceRecord(int hours) {
        super(hours, ServiceType.EMERGENCY);
        this.recordID = ++nextRecordID;
        buildInvoice();
    }

    @Override
    public int getServicePoints() {
        int servicePoints;
        servicePoints = EmergencyServiceRecord.EMERG_SERVICEPTS_BASE + hours * EmergencyServiceRecord.EMERG_SERVICEPTS_HOURLY;
        return servicePoints;
    }

    @Override
    public int getCalloutFee() {
        int calloutFee;
        calloutFee = EmergencyServiceRecord.EMERG_CALLOUT;
        return calloutFee;
    }

    @Override
    public int getServiceFee() {
        int serviceFee;
        serviceFee = EmergencyServiceRecord.EMERG_SERVICE_HOURLY * hours;
        return serviceFee;
    }
}
