package quoters;

import javax.annotation.PostConstruct;

@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {
    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    @PostConstruct
    public void init() {
        System.out.println("Init...");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("repeat = " + repeat);
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }
}
