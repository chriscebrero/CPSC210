package ca.ubc.cs.cpsc210.invoicemanager.model;

/**
 * Created by Dante on 2016-10-24.
 */
public class RegularServiceRecord extends AbstractServiceRecord{
    public static int REG_CALLOUT = 80;
    public static int REG_SERVICE_HOURLY = 80;
    public static int REG_SERVICEPTS_BASE = 10;
    public static int REG_SERVICEPTS_HOURLY = 2;

    public RegularServiceRecord(int hours) {
        super(hours, ServiceType.REGULAR);
        this.recordID = ++nextRecordID;
        buildInvoice();
    }

    @Override
    public int getServicePoints() {
        int servicePoints;
        servicePoints = RegularServiceRecord.REG_SERVICEPTS_BASE + hours * RegularServiceRecord.REG_SERVICEPTS_HOURLY;
        return servicePoints;
    }

    @Override
    public int getCalloutFee() {
        int calloutFee;
        calloutFee = RegularServiceRecord.REG_CALLOUT;
        return calloutFee;
    }

    @Override
    public int getServiceFee() {
        int serviceFee;
        serviceFee = RegularServiceRecord.REG_SERVICE_HOURLY * hours;
        return serviceFee;
    }
}
