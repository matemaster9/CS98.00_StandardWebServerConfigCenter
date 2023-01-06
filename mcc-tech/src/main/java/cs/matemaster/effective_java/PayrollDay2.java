package cs.matemaster.effective_java;

/**
 * @author matemaster
 */
public enum PayrollDay2 {

    Monday,

    Tuesday,

    Wednesday,

    Thursday,

    Friday,

    Saturday(PayrollStrategy.Weekend),

    Sunday(PayrollStrategy.Weekend),
    ;

    private final PayrollStrategy payrollStrategy;



    PayrollDay2() {
        this(PayrollStrategy.Weekday);
    }

    PayrollDay2(PayrollStrategy payrollStrategy) {
        this.payrollStrategy = payrollStrategy;
    }

    public int pay(int workHour, int hourlyWage) {
        return payrollStrategy.pay(workHour, hourlyWage);
    }

    private enum PayrollStrategy {
        Weekday {
            @Override
            public int pay(int workHour, int hourlyWage) {
                int basePay = workHour * hourlyWage;
                return workHour <= BASE_WORK_HOUR ? basePay : basePay + ((workHour - BASE_WORK_HOUR) * hourlyWage * 2);
            }
        },

        Weekend {
            @Override
            public int pay(int workHour, int hourlyWage) {
                return workHour * hourlyWage * 2;
            }
        },
        ;

        private static final int BASE_WORK_HOUR = 8;

        abstract int pay(int workHour, int hourlyWage);
    }
}
