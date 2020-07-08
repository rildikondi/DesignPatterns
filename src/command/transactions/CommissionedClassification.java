package command.transactions;

import java.util.List;

public class CommissionedClassification  implements PayClassification{
    private double basePay;
    private double commissionRate;
    private List<SalesReceipt> salesReceiptList;


    @Override
    public void calculatePay() {

    }
}
