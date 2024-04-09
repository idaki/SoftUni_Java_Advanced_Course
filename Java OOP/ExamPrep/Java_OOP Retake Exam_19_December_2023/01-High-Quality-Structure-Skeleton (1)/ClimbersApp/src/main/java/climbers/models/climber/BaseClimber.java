package climbers.models.climber;

import climbers.common.ExceptionMessages;
import climbers.models.roster.Roster;
import climbers.models.roster.RosterImpl;
import climbers.utils.DoubleUtils;
import climbers.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseClimber implements Climber{

    private String name;
    private double strength;
    private Roster roster;

    public BaseClimber(String name, double strength) {
        this.setName(name);
        this.setStrength(strength);
         this.roster = new RosterImpl();
    }

    public void setName(String name) {
        if (StringUtils.isNullOrEmpty(name)){
            throw new NullPointerException(ExceptionMessages.CLIMBER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setStrength(double strength) {
        if (DoubleUtils.isSmallerOrEqualToZero(strength)){
            throw new IllegalArgumentException(ExceptionMessages.CLIMBER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getStrength() {
        return this.strength;
    }

    @Override
    public boolean canClimb() {
        return this.strength>0;
    }

    @Override
    public Roster getRoster() {
        return this.roster;
    }

    @Override
    public String toString() {
        String conqueredPeaks="";
        if(this.roster.getPeaks().isEmpty()){
            conqueredPeaks="none";
        }else{
          List<String> peaks= new ArrayList<>(this.roster.getPeaks());
          conqueredPeaks  = peaks.stream().collect(Collectors.joining(", "));
        }

        StringBuilder sb =new StringBuilder();
       sb.append(String.format("Name: %s",this.name))
               .append(System.lineSeparator())
               .append(String.format("Strength: %.0f",this.strength))
               .append(System.lineSeparator())
               .append("Conquered peaks: "+conqueredPeaks);

        return sb.toString().trim();

    }
}
