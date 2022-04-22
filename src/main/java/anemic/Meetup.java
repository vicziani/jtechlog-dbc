package anemic;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Meetup {

    private Long id;

    private int limit;

    private List<String> attendees = new ArrayList<>();

}
