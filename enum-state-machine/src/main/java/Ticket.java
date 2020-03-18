import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Ticket{
//    https://cleanjava.wordpress.com/2012/02/25/enum-as-state-machine/
    private String id;
    private String topic;
    private TicketState status;




}
