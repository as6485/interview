package javabasics.datastructure;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

enum TransactionStatus{
    APPROVED(List.of("00", "10", "87")),
    CAPTURE(List.of("04", "41", "43"));

    private final List<String> codes;

    TransactionStatus(List<String> values)
    {
        this.codes = values;
    }

    public List<String> getValues()
    {
        return codes;
    }

    // Reverse lookup method
    public static Optional<TransactionStatus> getTransactionStatusByCode(String code) {
        return Arrays.stream(TransactionStatus.values())
                .filter(status -> status.getValues().contains(code)).findFirst();
    }
}


public class EnumExamples {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(TransactionStatus.values())); //[APPROVED, CAPTURE]
        System.out.println(TransactionStatus.valueOf("APPROVED")); //APPROVED
        System.out.println(TransactionStatus.APPROVED.getValues()); //[00, 10, 87]
        TransactionStatus.getTransactionStatusByCode("00")
                .ifPresentOrElse(
                        (v) -> {System.out.println(v.name());},
                        () -> System.out.println("Not Found"));
    }
}
