package climbers.models.climbing;

import climbers.models.climber.Climber;
import climbers.models.mountain.Mountain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ClimbingImpl implements Climbing{
    @Override
    public void conqueringPeaks(Mountain mountain, Collection<Climber> climbers) {
        List<String> peaks = new ArrayList<>(mountain.getPeaksList());

        for (Climber climber: climbers){
            while (climber.canClimb()&&!peaks.isEmpty()){
                String  currentPeak= peaks.get(0);
                climber.getRoster().getPeaks().add(currentPeak);
                climber.climb();
                peaks.remove(0);

            }
        }


    }
}
