package final2017;

import java.util.Collection;

public interface FlightFilter {

	Collection<Flight> filter(Collection<Flight> flights, Criterion c);
}
