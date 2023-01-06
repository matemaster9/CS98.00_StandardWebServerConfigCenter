package cs.matemaster.effective_java;

/**
 * @author matemaster
 */
public enum PayrollDay {

    Monday,

    Tuesday,

    Wednesday,

    Thursday,

    Friday,

    Saturday,

    Sunday,
    ;

    private static final int BASE_WORK_HOUR = 8;

    public int pay(int workHour, int hourlyWage) {

        switch (this) {
            case Saturday:
            case Sunday:
                return workHour * hourlyWage * 2;
            default:
                int basePay = workHour * hourlyWage;
                return workHour <= BASE_WORK_HOUR ? basePay : basePay + ((workHour - BASE_WORK_HOUR) * hourlyWage * 2);
        }
    }
}
