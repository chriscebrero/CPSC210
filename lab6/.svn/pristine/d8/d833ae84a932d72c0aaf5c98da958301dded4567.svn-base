package ca.ubc.cs.cpsc210.invoicemanager.model;

/**
 * Created by Dante on 2016-10-24.
 */
public class DiscountServiceRecord extends AbstractServiceRecord {
    public static int DISCOUNT_CALLOUT = 0;
    public static int DISCOUNT_SERVICE_HOURLY = 80;
    public static int DISCOUNT_SERVICEPTS_BASE = 0;
    public static int DISCOUNT_SERVICEPTS_HOURLY = 0;

    public DiscountServiceRecord(int hours) {
        super(hours, ServiceType.DISCOUNT);
        this.recordID = ++nextRecordID;
        buildInvoice();
    }

    @Override
    public int getServicePoints() {
        int servicePoints;
        servicePoints = DiscountServiceRecord.DISCOUNT_SERVICEPTS_BASE + hours * DiscountServiceRecord.DISCOUNT_SERVICEPTS_HOURLY;
        return servicePoints;
    }

    @Override
    public int getCalloutFee() {
        int calloutFee;
        calloutFee = DiscountServiceRecord.DISCOUNT_CALLOUT;
        return calloutFee;
    }

    @Override
    public int getServiceFee() {
        int serviceFee;
        serviceFee = DiscountServiceRecord.DISCOUNT_SERVICE_HOURLY * hours;
        return serviceFee;
    }
}
